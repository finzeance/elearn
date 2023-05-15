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
import id.co.mii.project.models.ClassSegment;
import id.co.mii.project.services.ClassSegmentService;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/calasssegment")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class ApiClassSegmentController {
    private ClassSegmentService classSegmentService;

    @GetMapping
    public List<ClassSegment> getAll() {
        return classSegmentService.getAll();
    }

    @GetMapping("/{id}")
    public ClassSegment getById(@PathVariable int id) {
        return classSegmentService.getById(id);
    }

    @PostMapping
    public ClassSegment create(@RequestBody @Valid ClassSegment classSegment) {
        return classSegmentService.create(classSegment);
    }

    @PutMapping("/{id}")
    public ClassSegment update(@PathVariable int id, @RequestBody @Valid ClassSegment classSegment) {
        return classSegmentService.update(id, classSegment);
    }

    @DeleteMapping("/{id}")
    public ClassSegment create(@PathVariable int id) {
        return classSegmentService.delete(id);
    }

}
