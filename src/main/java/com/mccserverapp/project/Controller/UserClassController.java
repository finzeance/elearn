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
@PreAuthorize("hasRole('STUDENT', 'MANAGER', 'TRAINER')")
public class UserClassController {

    private UserClassService userClassService;

    @PreAuthorize("hasAuthority('READ_STUDENT', 'READ_MANAGER', 'READ_TRAINER')")
    @GetMapping
    public List<UserClass> getAll() {
        return userClassService.getAll();
    }

    @PreAuthorize("hasAuthority('READ_STUDENT', 'READ_MANAGER', 'READ_TRAINER')")
    @GetMapping("/{id}")
    public UserClass getById(@PathVariable Integer id) {
        return userClassService.getById(id);
    }

    @PreAuthorize("hasAuthority('CREATE_MANAGER', 'CREATE_TRAINER')")
    @PostMapping
    public UserClass create(@RequestBody UserClass userClass) {
        return userClassService.create(userClass);
    }

    @PreAuthorize("hasAuthority('CREATE_MANAGER', 'CREATE_TRAINER')")
    @PostMapping("/dto")
    public UserClass createWithDTO(@RequestBody UserClassRequest userClassRequest) {
        return userClassService.createWithDTO(userClassRequest);
    }

    @PreAuthorize("hasAuthority('CREATE_MANAGER', 'CREATE_TRAINER')")
    @PostMapping("/modelmapper")
    public UserClass createWithModelMapper(@RequestBody UserClassRequest userClassRequest) {
        return userClassService.createWithModelMapper(userClassRequest);
    }

    @PreAuthorize("hasAuthority('UPDATE_MANAGER', 'UPDATE_TRAINER')")
    @PutMapping("/{id}")
    public UserClass update(@PathVariable Integer id, @RequestBody UserClass userClass) {
        return userClassService.update(id, userClass);
    }

    @PreAuthorize("hasAuthority('DELETE_MANAGER', 'DELETE_TRAINER')")
    @DeleteMapping("/{id}")
    public UserClass delete(@PathVariable Integer id) {
        return userClassService.delete(id);
    }

}
