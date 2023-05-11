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

import com.mccserverapp.project.Model.Segment;
import com.mccserverapp.project.Service.SegmentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/segment")
@PreAuthorize("hasRole('USER', 'ADMIN')")
public class SegmentController {

    private SegmentService segmentService;

    @PreAuthorize("hasAuthority('READ_USER', 'READ_ADMIN')")
    @GetMapping
    public List<Segment> getAll() {
        return segmentService.getAll();
    }
    
    @PreAuthorize("hasAuthority('READ_USER', 'READ_ADMIN')")
    @GetMapping("/{id}")
    public Segment getById(@PathVariable Integer id) {
        return segmentService.getById(id);
    }
    
    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping
    public Segment create(@RequestBody Segment segment) {
        return segmentService.create(segment);
    }
    
    @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
    @PutMapping("/{id}")
    public Segment update(@PathVariable Integer id, @RequestBody Segment segment) {
        return segmentService.update(id, segment);
    }
    
    @PreAuthorize("hasAuthority('DELETE_ADMIN')")
    @DeleteMapping
    public Segment delete(@PathVariable Integer id) {
        return segmentService.delete(id);
    }

}
