package com.mccserverapp.project.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mccserverapp.project.Model.Segment;
import com.mccserverapp.project.Service.SegmentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/segment")
public class SegmentController {

    private SegmentService segmentService;

    @GetMapping
    public List<Segment> getAll() {
        return segmentService.getAll();
    }

    @GetMapping("/{id}")
    public Segment getById(@PathVariable Integer id) {
        return segmentService.getById(id);
    }

    @PostMapping
    public Segment create(@RequestBody Segment segment) {
        return segmentService.create(segment);
    }

    @PutMapping("/{id}")
    public Segment update(@PathVariable Integer id, @RequestBody Segment segment) {
        return segmentService.update(id, segment);
    }

    @DeleteMapping
    public Segment delete(@PathVariable Integer id) {
        return segmentService.delete(id);
    }

}
