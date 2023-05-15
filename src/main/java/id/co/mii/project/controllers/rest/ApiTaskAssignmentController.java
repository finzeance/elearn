package id.co.mii.project.controllers.rest;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import id.co.mii.project.models.TaskAssignment;
import id.co.mii.project.services.TaskAssignmentService;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/taskassignment")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class ApiTaskAssignmentController {
    private TaskAssignmentService taskAssignmentService;

    @GetMapping
    public List<TaskAssignment> getAll() {
        return taskAssignmentService.getAll();
    }

    @GetMapping("/{id}")
    public TaskAssignment getById(@PathVariable int id) {
        return taskAssignmentService.getById(id);
    }

    @PostMapping
    public TaskAssignment create(@RequestBody @Valid TaskAssignment taskAssignment) {
        return taskAssignmentService.create(taskAssignment);
    }

    @PutMapping("/{id}")
    public TaskAssignment update(@PathVariable int id, @RequestBody @Valid TaskAssignment taskAssignment) {
        return taskAssignmentService.update(id, taskAssignment);
    }

    @DeleteMapping("/{id}")
    public TaskAssignment create(@PathVariable int id) {
        return taskAssignmentService.delete(id);
    }
}
