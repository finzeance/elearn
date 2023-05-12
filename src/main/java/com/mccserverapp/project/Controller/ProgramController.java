package com.mccserverapp.project.Controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
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
@PreAuthorize("hasRole('MANAGER', 'TRAINER')")
public class ProgramController {

    private ProgramService programService;

    @PreAuthorize("hasAuthority('READ_MANAGER', 'READ_TRAINER')")
    @GetMapping
    public List<Program> getAll() {
        return programService.getAll();
    }

    @PreAuthorize("hasAuthority('READ_MANAGER', 'READ_TRAINER')")
    @GetMapping("/{id}")
    public Program getById(@PathVariable Integer id) {
        return programService.getById(id);
    }

    @PreAuthorize("hasAuthority('CREATE_MANAGER', 'CREATE_TRAINER')")
    @PostMapping
    public Program create(@RequestBody Program program) {
        return programService.create(program);
    }

    @PreAuthorize("hasAuthority('UPDATE_MANAGER', 'UPDATE_TRAINER')")
    @PutMapping("/{id}")
    public Program update(@PathVariable Integer id, @RequestBody Program program) {
        return programService.update(id, program);
    }

    @PreAuthorize("hasAuthority('DELETE_MANAGER', 'DELETE_TRAINER')")
    @DeleteMapping("/{id}")
    public Program delete(@PathVariable Integer id) {
        return programService.delete(id);
    }

}
