package com.mccserverapp.project.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mccserverapp.project.Model.ClassSegment;
import com.mccserverapp.project.Model.Kelas;
import com.mccserverapp.project.Model.Segment;
import com.mccserverapp.project.Model.User;
import com.mccserverapp.project.Model.dto.request.ClassSegmentRequest;
import com.mccserverapp.project.Repository.ClassSegmentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassSegmentService {

    private UserService userService;
    private KelasService kelasService;
    private SegmentService segmentService;
    private ClassSegmentRepository classSegmentRepository;
    private ModelMapper modelMapper;

    public List<ClassSegment> getAll() {
        return classSegmentRepository.findAll();
    }

    public ClassSegment getById(Integer id) {
        return classSegmentRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data class-segment not found!!!"));
    }

    public ClassSegment create(ClassSegment classSegment) {
        return classSegmentRepository.save(classSegment);
    }

    public ClassSegment createWithDTO(ClassSegmentRequest classSegmentRequest) {
        ClassSegment classSegment = new ClassSegment();

        User user = userService.getById(classSegmentRequest.getUserId());
        classSegment.setUser(user); // akses trainer
        Kelas kelas = kelasService.getById(classSegmentRequest.getClassId());
        classSegment.setKelas(kelas);
        Segment segment = segmentService.getById(classSegmentRequest.getSegmentId());
        classSegment.setSegment(segment);
        return classSegmentRepository.save(classSegment);
    }

    // public ClassSegment createWithModelMapper(ClassSegmentRequest
    // classSegmentRequest) {
    // ClassSegment classSegment = modelMapper.map(classSegmentRequest,
    // ClassSegment.class);
    // classSegment.setKelas(kelasService.getById(classSegmentRequest.getClassId()));
    // classSegment.setUser(userService.getById(classSegmentRequest.getUserId()));
    // classSegment.setSegment(segmentService.getById(classSegmentRequest.getSegmentId()));

    // return classSegmentRepository.save(classSegment);

    // }

    public ClassSegment createWithModelMapper(ClassSegment classSegment) {
        ClassSegment c = new ClassSegment();

        c.setKelas(kelasService.getById(classSegment.getKelas().getId()));
        c.setUser(userService.getById(classSegment.getUser().getId()));
        c.setSegment(segmentService.getById(classSegment.getSegment().getId()));
        c.setStartDate(classSegment.getStartDate());
        c.setEndDate(classSegment.getEndDate());
        return classSegmentRepository.save(c);

    }

    public ClassSegment update(Integer id, ClassSegment classSegment) {
        getById(id);
        classSegment.setId(id);
        return classSegmentRepository.save(classSegment);
    }

    public ClassSegment delete(Integer id) {
        ClassSegment classSegment = getById(id);
        classSegmentRepository.delete(classSegment);
        return classSegment;
    }
}
