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
import id.co.mii.project.models.Role;
import id.co.mii.project.services.RoleService;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/role")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class ApiRoleController {
    private RoleService roleService;

    @GetMapping
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Role getById(@PathVariable int id) {
        return roleService.getById(id);
    }

    @PostMapping
    public Role create(@RequestBody @Valid Role role) {
        return roleService.create(role);
    }

    @PutMapping("/{id}")
    public Role update(@PathVariable int id, @RequestBody @Valid Role role) {
        return roleService.update(id, role);
    }

    @DeleteMapping("/{id}")
    public Role create(@PathVariable int id) {
        return roleService.delete(id);
    }
}
