package id.co.mii.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import id.co.mii.project.models.Course;
import id.co.mii.project.services.CourseService;
import java.util.List;

@Controller
// @RequestMapping("/course")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class CourseController {
    private CourseService CourseService;

    @GetMapping("/course")
    public String index(Model model) {
        return "Course/course";
    }

    @GetMapping("/coursetrainer")
    public String indexTrainer(Model model) {
        return "Course/courseTrainer";
    }

    @GetMapping("/coursemanager")
    public String indexManager(Model model) {
        return "Course/courseManager";
    }

    @GetMapping("/coursecreate")
    public String createView(Course course, Model model) {
        return "Course/create-form";
    }

    @PostMapping("/course")
    public String create(Course course) {
        CourseService.create(course);
        return "redirect:/Course";
    }

    @GetMapping("/courseupdate/{id}")
    public String updateView(@PathVariable int id, Model model) {
        model.addAttribute("Course", CourseService.getById(id));
        return "Course/update-form";
    }

    @PutMapping("/course/{id}")
    public String update(@PathVariable int id, Course course) {
        CourseService.update(id, course);
        return "redirect:/Course";
    }

    @DeleteMapping("/course/{id}")
    public String delete(@PathVariable int id) {
        CourseService.delete(id);
        return "redirect:/Course";
    }
}
