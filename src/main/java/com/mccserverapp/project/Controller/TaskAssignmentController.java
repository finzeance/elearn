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

import com.mccserverapp.project.Model.TaskAssignment;
import com.mccserverapp.project.Model.dto.request.TaskAssignmentRequest;
import com.mccserverapp.project.Service.TaskAssignmentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/task-assignment")
public class TaskAssignmentController {

    private TaskAssignmentService taskAssignmentService;

    @GetMapping
    public List<TaskAssignment> getAll() {
        return taskAssignmentService.getAll();
    }

    @GetMapping("/{id}")
    public TaskAssignment getById(@PathVariable Integer id) {
        return taskAssignmentService.getById(id);
    }

    @PostMapping
    public TaskAssignment create(@RequestBody TaskAssignment taskAssignment) {
        return taskAssignmentService.create(taskAssignment);
    }

    @PostMapping("/dto")
    public TaskAssignment createWithDTO(@RequestBody TaskAssignmentRequest taskAssignmentRequest) {
        return taskAssignmentService.createWithDTO(taskAssignmentRequest);
    }

    @PostMapping("/modelmapper")
    public TaskAssignment createWithModelMapper(@RequestBody TaskAssignmentRequest taskAssignmentRequest) {
        return taskAssignmentService.createWithModelMapper(taskAssignmentRequest);
    }

    @PutMapping("/{id}")
    public TaskAssignment update(@PathVariable Integer id, @RequestBody TaskAssignment taskAssignment) {
        return taskAssignmentService.update(id, taskAssignment);
    }

    @DeleteMapping("/{id}")
    public TaskAssignment delete(@PathVariable Integer id) {
        return taskAssignmentService.delete(id);
    }

}
