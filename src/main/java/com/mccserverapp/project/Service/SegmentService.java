package com.mccserverapp.project.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mccserverapp.project.Model.Segment;
import com.mccserverapp.project.Repository.SegmentRepository;

@Service
public class SegmentService {

    private SegmentRepository segmentRepository;

    public List<Segment> getAll() {
        return segmentRepository.findAll();
    }

    public Segment getById(Integer id) {
        return segmentRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data segment not found!!!"));
    }

    public Segment create(Segment segment) {
        return segmentRepository.save(segment);
    }

    public Segment update(Integer id, Segment segment) {
        getById(id);
        segment.setId(id);
        return segmentRepository.save(segment);
    }

    public Segment delete(Integer id) {
        Segment segment = getById(id);
        segmentRepository.delete(segment);
        return segment;
    }
}
