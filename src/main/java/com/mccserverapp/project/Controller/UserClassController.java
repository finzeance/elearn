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

import com.mccserverapp.project.Model.UserClass;
import com.mccserverapp.project.Model.dto.request.UserClassRequest;
import com.mccserverapp.project.Service.UserClassService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/user-class")
@PreAuthorize("hasRole('USER', 'ADMIN')")
public class UserClassController {

    private UserClassService userClassService;

    @PreAuthorize("hasAuthority('READ_USER', 'READ_ADMIN')")
    @GetMapping
    public List<UserClass> getAll() {
        return userClassService.getAll();
    }

    @PreAuthorize("hasAuthority('READ_USER', 'READ_ADMIN')")
    @GetMapping("/{id}")
    public UserClass getById(@PathVariable Integer id) {
        return userClassService.getById(id);
    }

    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping
    public UserClass create(@RequestBody UserClass userClass) {
        return userClassService.create(userClass);
    }

    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping("/dto")
    public UserClass createWithDTO(@RequestBody UserClassRequest userClassRequest) {
        return userClassService.createWithDTO(userClassRequest);
    }

    @PreAuthorize("hasAuthority('CREATE_ADMIN')")
    @PostMapping("/modelmapper")
    public UserClass createWithModelMapper(@RequestBody UserClassRequest userClassRequest) {
        return userClassService.createWithModelMapper(userClassRequest);
    }

    @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
    @PutMapping("/{id}")
    public UserClass update(@PathVariable Integer id, @RequestBody UserClass userClass) {
        return userClassService.update(id, userClass);
    }

    @PreAuthorize("hasAuthority('DELETE_ADMIN')")
    @DeleteMapping("/{id}")
    public UserClass delete(@PathVariable Integer id) {
        return userClassService.delete(id);
    }

}
