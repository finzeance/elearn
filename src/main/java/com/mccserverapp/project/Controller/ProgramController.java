package com.mccserverapp.project.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mccserverapp.project.Model.Program;
import com.mccserverapp.project.Service.ProgramService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/program")
public class ProgramController {

    private ProgramService programService;

    @GetMapping
    public List<Program> getAll() {
        return programService.getAll();
    }

    @GetMapping("/{id}")
    public Program getById(@PathVariable Integer id) {
        return programService.getById(id);
    }

    @PostMapping
    public Program create(@RequestBody Program program) {
        return programService.create(program);
    }

    @PutMapping("/{id}")
    public Program update(@PathVariable Integer id, @RequestBody Program program) {
        return programService.update(id, program);
    }

    @DeleteMapping("/{id}")
    public Program delete(@PathVariable Integer id) {
        return programService.delete(id);
    }

}
