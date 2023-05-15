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
import id.co.mii.project.models.UserClass;
import id.co.mii.project.services.UserClassService;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/userclass")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class ApiUserClassController {
    private UserClassService userClassService;

    @GetMapping
    public List<UserClass> getAll() {
        return userClassService.getAll();
    }

    @GetMapping("/{id}")
    public UserClass getById(@PathVariable int id) {
        return userClassService.getById(id);
    }

    @PostMapping
    public UserClass create(@RequestBody @Valid UserClass userClass) {
        return userClassService.create(userClass);
    }

    @PutMapping("/{id}")
    public UserClass update(@PathVariable int id, @RequestBody @Valid UserClass userClass) {
        return userClassService.update(id, userClass);
    }

    @DeleteMapping("/{id}")
    public UserClass create(@PathVariable int id) {
        return userClassService.delete(id);
    }
}
