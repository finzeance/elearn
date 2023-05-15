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
import id.co.mii.project.models.User;
import id.co.mii.project.services.UserService;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class ApiUserController {
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping
    public User create(@RequestBody @Valid User user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable int id, @RequestBody @Valid User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public User create(@PathVariable int id) {
        return userService.delete(id);
    }
}
