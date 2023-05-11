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

import com.mccserverapp.project.Model.Task;
import com.mccserverapp.project.Model.dto.request.TaskRequest;
import com.mccserverapp.project.Service.TaskService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/task")
@PreAuthorize("hasRole('USER', 'ADMIN')")
public class TaskController {

    private TaskService taskService;

    @PreAuthorize("hasAuthority('READ_USER', 'READ_ADMIN')")
    @GetMapping
    public List<Task> getAll() {
        return taskService.getAll();
    }
    
    @PreAuthorize("hasAuthority('READ_USER', 'READ_ADMIN')")
    @GetMapping("/{id}")
    public Task getById(@PathVariable Integer id) {
        return taskService.getById(id);
    }
    
    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping
    public Task create(@RequestBody Task task) {
        return taskService.create(task);
    }

    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping("/dto")
    public Task createWithDTO(@RequestBody TaskRequest taskRequest) {
        return taskService.createWithDTO(taskRequest);
    }
    
    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping("/modelmapper")
    public Task createWithModelMapper(@RequestBody TaskRequest taskRequest) {
        return taskService.createWithModelMapper(taskRequest);
    }
    
    @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
    @PutMapping("/{id}")
    public Task update(@PathVariable Integer id, @RequestBody Task task) {
        return taskService.update(id, task);
    }
    
    @PreAuthorize("hasAuthority('DELETE_ADMIN')")
    @DeleteMapping("/{id}")
    public Task delete(@PathVariable Integer id) {
        return taskService.delete(id);
    }
}
