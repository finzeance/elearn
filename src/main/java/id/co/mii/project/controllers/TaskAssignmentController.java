package id.co.mii.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import id.co.mii.project.models.TaskAssignment;
import id.co.mii.project.services.TaskAssignmentService;
import java.util.List;

@Controller
@RequestMapping("/taskassignment")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class TaskAssignmentController {
    private TaskAssignmentService taskAssignmentService;

    @GetMapping
    public String index(Model model) {
        List<TaskAssignment> TaskAssignments = taskAssignmentService.getAll();
        model.addAttribute("TaskAssignment", TaskAssignments);
        return "TaskAssignment/index";
    }

    @GetMapping("/create")
    public String createView(TaskAssignment TaskAssignments, Model model) {
        return "TaskAssignment/create-form";
    }

    @PostMapping
    public String create(TaskAssignment TaskAssignments) {
        taskAssignmentService.create(TaskAssignments);
        return "redirect:/TaskAssignment";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable int id, Model model) {
        model.addAttribute("TaskAssignment", taskAssignmentService.getById(id));
        return "TaskAssignment/update-form";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, TaskAssignment TaskAssignments) {
        taskAssignmentService.update(id, TaskAssignments);
        return "redirect:/TaskAssignment";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        taskAssignmentService.delete(id);
        return "redirect:/TaskAssignment";
    }
}
