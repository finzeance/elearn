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
import id.co.mii.project.models.Task;
import id.co.mii.project.services.TaskService;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/task")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class ApiTaskController {
    private TaskService taskService;

    @GetMapping
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable int id) {
        return taskService.getById(id);
    }

    @PostMapping
    public Task create(@RequestBody @Valid Task task) {
        return taskService.create(task);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable int id, @RequestBody @Valid Task task) {
        return taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    public Task create(@PathVariable int id) {
        return taskService.delete(id);
    }
}
