package id.co.mii.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import id.co.mii.project.models.ClassSegment;
import id.co.mii.project.services.ClassSegmentService;
import java.util.List;

@Controller
@RequestMapping("/classsegment")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class ClassSegmentController {
    private ClassSegmentService classSegmentService;

    @GetMapping
    public String index(Model model) {
        List<ClassSegment> classSegments = classSegmentService.getAll();
        model.addAttribute("classSegment", classSegments);
        return "ClassSegment/index";
    }

    @GetMapping("/create")
    public String createView(ClassSegment classSegment, Model model) {
        return "ClassSegment/create-form";
    }

    @PostMapping
    public String create(ClassSegment classSegment) {
        classSegmentService.create(classSegment);
        return "redirect:/ClassSegment";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable int id, Model model) {
        model.addAttribute("ClassSegment", classSegmentService.getById(id));
        return "ClassSegment/update-form";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, ClassSegment classSegment) {
        classSegmentService.update(id, classSegment);
        return "redirect:/ClassSegment";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        classSegmentService.delete(id);
        return "redirect:/ClassSegment";
    }
}
