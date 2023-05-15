package id.co.mii.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import id.co.mii.project.models.Task;
import id.co.mii.project.services.TaskService;
import java.util.List;

@Controller
@RequestMapping("/task")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class TaskController {
    private TaskService taskService;

    @GetMapping
    public String index(Model model) {
        return "Task/task";
    }

    @GetMapping("/create")
    public String createView(Task Tasks, Model model) {
        return "Task/create-form";
    }

    @PostMapping
    public String create(Task Tasks) {
        taskService.create(Tasks);
        return "redirect:/Task";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable int id, Model model) {
        model.addAttribute("Task", taskService.getById(id));
        return "Task/update-form";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, Task Tasks) {
        taskService.update(id, Tasks);
        return "redirect:/Task";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        taskService.delete(id);
        return "redirect:/ClassSegment";
    }
}
