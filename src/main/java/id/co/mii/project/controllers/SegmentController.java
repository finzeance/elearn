package id.co.mii.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import id.co.mii.project.models.Segment;
import id.co.mii.project.services.SegmentService;
import java.util.List;

@Controller
// @RequestMapping("/segment")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class SegmentController {
    private SegmentService segmentService;

    @GetMapping("/segment")
    public String index(Model model) {
        return "Segment/segment";
    }

    @GetMapping("/segmenttrainer")
    public String indexTrainer(Model model) {
        return "Segment/segmentTrainer";
    }

    @GetMapping("/segmentmanager")
    public String indexManager(Model model) {
        return "Segment/segmentManager";
    }

    @GetMapping("/segmenttable")
    public String indexSegment(Model model) {
        return "Segment/addsegment";
    }

    @GetMapping("/segmentcreate")
    public String createView(Segment Segments, Model model) {
        return "Segment/create-form";
    }

    @PostMapping("/segment")
    public String create(Segment Segments) {
        segmentService.create(Segments);
        return "redirect:/segment";
    }

    @GetMapping("/segmentupdate/{id}")
    public String updateView(@PathVariable int id, Model model) {
        model.addAttribute("Segment", segmentService.getById(id));
        return "Segment/update-form";
    }

    @PutMapping("/segment/{id}")
    public String update(@PathVariable int id, Segment Segments) {
        segmentService.update(id, Segments);
        return "redirect:/segment";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        segmentService.delete(id);
        return "redirect:/ClassSegment";
    }
}
