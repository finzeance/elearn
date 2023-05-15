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
import id.co.mii.project.models.Program;
import id.co.mii.project.services.ProgramService;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/program")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class ApiProgramController {
    private ProgramService programService;

    @GetMapping
    public List<Program> getAll() {
        return programService.getAll();
    }

    @GetMapping("/{id}")
    public Program getById(@PathVariable int id) {
        return programService.getById(id);
    }

    @PostMapping
    public Program create(@RequestBody @Valid Program program) {
        return programService.create(program);
    }

    @PutMapping("/{id}")
    public Program update(@PathVariable int id, @RequestBody @Valid Program program) {
        return programService.update(id, program);
    }

    @DeleteMapping("/{id}")
    public Program create(@PathVariable int id) {
        return programService.delete(id);
    }
}
