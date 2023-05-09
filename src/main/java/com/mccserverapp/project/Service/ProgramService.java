package com.mccserverapp.project.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mccserverapp.project.Model.Program;
import com.mccserverapp.project.Repository.ProgramRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgramService {

    private ProgramRepository programRepository;

    public List<Program> getAll() {
        return programRepository.findAll();
    }

    public Program getById(Integer id) {
        return programRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data program not found!!!"));
    }

    public Program create(Program program) {
        return programRepository.save(program);
    }

    public Program update(Integer id, Program program) {
        getById(id);
        program.setId(id);
        return programRepository.save(program);
    }

    public Program delete(Integer id) {
        Program program = getById(id);
        programRepository.delete(program);
        return program;
    }
}
