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
import id.co.mii.project.models.Privilege;
import id.co.mii.project.services.PrivilegeService;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/privilege")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class ApiPrivilegeController {
    private PrivilegeService privilegeService;

    @GetMapping
    public List<Privilege> getAll() {
        return privilegeService.getAll();
    }

    @GetMapping("/{id}")
    public Privilege getById(@PathVariable int id) {
        return privilegeService.getById(id);
    }

    @PostMapping
    public Privilege create(@RequestBody @Valid Privilege privilege) {
        return privilegeService.create(privilege);
    }

    @PutMapping("/{id}")
    public Privilege update(@PathVariable int id, @RequestBody @Valid Privilege privilege) {
        return privilegeService.update(id, privilege);
    }

    @DeleteMapping("/{id}")
    public Privilege create(@PathVariable int id) {
        return privilegeService.delete(id);
    }
}
