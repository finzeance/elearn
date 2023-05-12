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

import com.mccserverapp.project.Model.Kelas;
import com.mccserverapp.project.Model.Program;
import com.mccserverapp.project.Model.dto.request.KelasRequest;
import com.mccserverapp.project.Service.KelasService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/class")
@PreAuthorize("hasRole('MANAGER')")
public class KelasController {

    private KelasService kelasService;

    @PreAuthorize("hasAuthority('READ_MANAGER')")
    @GetMapping
    public List<Kelas> getAll() {
        return kelasService.getAll();
    }

    @PreAuthorize("hasAuthority('READ_MANAGER')")
    @GetMapping("/{id}")
    public Kelas getById(@PathVariable Integer id) {
        return kelasService.getById(id);
    }
    
    @PreAuthorize("hasAuthority('CREATE_MANAGER')")
    @PostMapping
    public Kelas create(@RequestBody Kelas kelas) {
        return kelasService.create(kelas);
    }
    
    @PreAuthorize("hasAuthority('CREATE_MANAGER')")
    @PostMapping("/dto")
    public Kelas createWithDTO(@RequestBody KelasRequest kelasRequest) {
        return kelasService.createWithDTO(kelasRequest);
    }
    
    @PreAuthorize("hasAuthority('CREATE_MANAGER')")
    @PostMapping("/modelmapper")
    public Kelas createWithModelMapper(@RequestBody KelasRequest kelasRequest) {
        return kelasService.createWithModelMapper(kelasRequest);
    }
    
    @PreAuthorize("hasAuthority('UPDATE_MANAGER')")
    @PutMapping("/{id}")
    public Kelas update(@PathVariable Integer id, @RequestBody Kelas kelas) {
        return kelasService.update(id, kelas);
    }
    
    @PreAuthorize("hasAuthority('DELETE_MANAGER')")
    @DeleteMapping("/{id}")
    public Kelas delete(@PathVariable Integer id) {
        return kelasService.delete(id);
    }

}
