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

import com.mccserverapp.project.Model.TaskAssignment;
import com.mccserverapp.project.Model.dto.request.TaskAssignmentRequest;
import com.mccserverapp.project.Service.TaskAssignmentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/task-assignment")
@PreAuthorize("hasRole('USER', 'ADMIN')")
public class TaskAssignmentController {

    private TaskAssignmentService taskAssignmentService;

    @PreAuthorize("hasAuthority('READ_USER', 'READ_ADMIN')")
    @GetMapping
    public List<TaskAssignment> getAll() {
        return taskAssignmentService.getAll();
    }

    @PreAuthorize("hasAuthority('READ_USER', 'READ_ADMIN')")
    @GetMapping("/{id}")
    public TaskAssignment getById(@PathVariable Integer id) {
        return taskAssignmentService.getById(id);
    }

    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping
    public TaskAssignment create(@RequestBody TaskAssignment taskAssignment) {
        return taskAssignmentService.create(taskAssignment);
    }

    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping("/dto")
    public TaskAssignment createWithDTO(@RequestBody TaskAssignmentRequest taskAssignmentRequest) {
        return taskAssignmentService.createWithDTO(taskAssignmentRequest);
    }

    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping("/modelmapper")
    public TaskAssignment createWithModelMapper(@RequestBody TaskAssignmentRequest taskAssignmentRequest) {
        return taskAssignmentService.createWithModelMapper(taskAssignmentRequest);
    }

    @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
    @PutMapping("/{id}")
    public TaskAssignment update(@PathVariable Integer id, @RequestBody TaskAssignment taskAssignment) {
        return taskAssignmentService.update(id, taskAssignment);
    }

    @PreAuthorize("hasAuthority('DELETE_ADMIN')")
    @DeleteMapping("/{id}")
    public TaskAssignment delete(@PathVariable Integer id) {
        return taskAssignmentService.delete(id);
    }

}
