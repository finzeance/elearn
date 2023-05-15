package com.mccserverapp.project.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mccserverapp.project.Model.Course;
import com.mccserverapp.project.Model.Segment;
import com.mccserverapp.project.Model.dto.request.CourseRequest;
import com.mccserverapp.project.Repository.CourseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService {

    private ModelMapper modelMapper;
    private FileStorageService fileStorageService;
    private SegmentService segmentService;
    private CourseRepository courseRepository;

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course getById(Integer id) {
        return courseRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data course not found"));
    }

    public Course create(Course course) {
        return courseRepository.save(course);
    }

    // membuat course dari segment
    public Course createWithDTO(CourseRequest courseRequest) {
        Course course = new Course();
        course.setName(courseRequest.getName());
        course.setDescription(courseRequest.getDescription());

        Segment segment = segmentService.getById(courseRequest.getSegmentId());
        course.setSegment(segment);
        return courseRepository.save(course);
    }

    public Course createWithModelMapper(CourseRequest courseRequest, MultipartFile file) {
        Course course = modelMapper.map(courseRequest, Course.class);
        String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        course.setFile(fileDownloadUri);
        course.setSegment(segmentService.getById(courseRequest.getSegmentId()));
        return courseRepository.save(course);
    }

    public Course update(Integer id, Course course) {
        getById(id);
        course.setId(id);
        return courseRepository.save(course);
    }

    public Course delete(Integer id) {
        Course course = getById(id);
        courseRepository.delete(course);
        return course;
    }

}
