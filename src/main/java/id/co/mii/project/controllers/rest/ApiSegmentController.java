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
import id.co.mii.project.models.Segment;
import id.co.mii.project.services.SegmentService;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/segment")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class ApiSegmentController {
    private SegmentService segmentService;

    @GetMapping
    public List<Segment> getAll() {
        return segmentService.getAll();
    }

    @GetMapping("/{id}")
    public Segment getById(@PathVariable int id) {
        return segmentService.getById(id);
    }

    @PostMapping
    public Segment create(@RequestBody @Valid Segment segment) {
        return segmentService.create(segment);
    }

    @PutMapping("/{id}")
    public Segment update(@PathVariable int id, @RequestBody @Valid Segment segment) {
        return segmentService.update(id, segment);
    }

    @DeleteMapping("/{id}")
    public Segment create(@PathVariable int id) {
        return segmentService.delete(id);
    }
}
