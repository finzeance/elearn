package com.mccserverapp.project.Controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
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
@PreAuthorize("hasRole('USER', 'ADMIN')")
public class ClassSegmentController {

    private ClassSegmentService classSegmentService;

    @PreAuthorize("hasAuthority('READ_USER', 'READ_ADMIN')")
    @GetMapping
    public List<ClassSegment> getAll() {
        return classSegmentService.getAll();
    }
    
    @PreAuthorize("hasAuthority('READ_USER', 'READ_ADMIN')")
    @GetMapping("/{id}")
    public ClassSegment getById(@PathVariable Integer id) {
        return classSegmentService.getById(id);
    }
    
    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping
    public ClassSegment create(@RequestBody ClassSegment classSegment) {
        return classSegmentService.create(classSegment);
    }
    
    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping("/dto")
    public ClassSegment createWithDTO(@RequestBody ClassSegmentRequest classSegmentRequest) {
        return classSegmentService.createWithDTO(classSegmentRequest);
    }
    
    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping("/modelmapper")
    public ClassSegment createWithModelMapper(@RequestBody ClassSegmentRequest classSegmentRequest) {
        return classSegmentService.createWithModelMapper(classSegmentRequest);
    }

    @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
    @PutMapping("/{id}") 
    public ClassSegment update(@PathVariable Integer id, @RequestBody ClassSegment classSegment) {
        return classSegmentService.update(id, classSegment);
    }

    @PreAuthorize("hasAuthority('DELETE_ADMIN')")
    @DeleteMapping("/{id}")
    public ClassSegment delete(@PathVariable Integer id) {
        return classSegmentService.delete(id);
    }

}
