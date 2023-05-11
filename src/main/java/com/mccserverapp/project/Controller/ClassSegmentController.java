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

import com.mccserverapp.project.Model.ClassSegment;
import com.mccserverapp.project.Model.dto.request.ClassSegmentRequest;
import com.mccserverapp.project.Service.ClassSegmentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/class-segment")
public class ClassSegmentController {

    private ClassSegmentService classSegmentService;

    @GetMapping
    public List<ClassSegment> getAll() {
        return classSegmentService.getAll();
    }

    @GetMapping("/{id}")
    public ClassSegment getById(@PathVariable Integer id) {
        return classSegmentService.getById(id);
    }

    @PostMapping
    public ClassSegment create(@RequestBody ClassSegment classSegment) {
        return classSegmentService.create(classSegment);
    }

    @PostMapping("/dto")
    public ClassSegment createWithDTO(@RequestBody ClassSegmentRequest classSegmentRequest) {
        return classSegmentService.createWithDTO(classSegmentRequest);
    }

    @PostMapping("/modelmapper")
    public ClassSegment createWithModelMapper(@RequestBody ClassSegmentRequest classSegmentRequest) {
        return classSegmentService.createWithModelMapper(classSegmentRequest);
    }

    @PutMapping("/{id}") 
    public ClassSegment update(@PathVariable Integer id, @RequestBody ClassSegment classSegment) {
        return classSegmentService.update(id, classSegment);
    }

    @DeleteMapping("/{id}")
    public ClassSegment delete(@PathVariable Integer id) {
        return classSegmentService.delete(id);
    }

}
