package com.mccserverapp.project.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mccserverapp.project.Model.UserClass;
import com.mccserverapp.project.Service.UserClassService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/user-class")
public class UserClassController {

    private UserClassService userClassService;

    @GetMapping
    public List<UserClass> getAll() {
        return userClassService.getAll();
    }

    @GetMapping("/{id}")
    public UserClass getById(@PathVariable Integer id) {
        return userClassService.getById(id);
    }

    @PostMapping
    public UserClass create(@RequestBody UserClass userClass) {
        return userClassService.create(userClass);
    }

    @PutMapping("/{id}")
    public UserClass update(@PathVariable Integer id, @RequestBody UserClass userClass) {
        return userClassService.update(id, userClass);
    }

    @DeleteMapping("/{id}")
    public UserClass delete(@PathVariable Integer id) {
        return userClassService.delete(id);
    }

}
