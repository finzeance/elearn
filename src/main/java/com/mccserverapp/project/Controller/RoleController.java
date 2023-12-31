package com.mccserverapp.project.Controller;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mccserverapp.project.Model.Role;
import com.mccserverapp.project.Service.RoleService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/role")
@PreAuthorize("hasRole('MANAGER')")
public class RoleController {
    
    private RoleService roleService;
    
    
    @PreAuthorize("hasAuthority('READ_MANAGER')")
    @GetMapping
    public List<Role> getAll() {
        return roleService.getAll();
    }
    
    @PreAuthorize("hasAuthority('READ_MANAGER')")
    @GetMapping("/{id}")
    public Role getById(@PathVariable Integer id) {
        return roleService.getById(id);
    }
    
    @PreAuthorize("hasAuthority('CREATE_MANAGER')")
    @PostMapping
    public Role create(@RequestBody Role role) {
        return roleService.create(role);
    }
    
    @PreAuthorize("hasAuthority('UPDATE_MANAGER')")
    @PutMapping("/{id}")
    public Role update(@PathVariable Integer id, @RequestBody Role role) {
        return roleService.update(id, role);
    }
    
    @PreAuthorize("hasAuthority('DELETE_MANAGER')")
    @DeleteMapping("/{id}")
    public Role delete(@PathVariable Integer id) {
        return roleService.delete(id);
    }

}
