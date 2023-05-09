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

import com.mccserverapp.project.Model.Course;
import com.mccserverapp.project.Model.dto.request.CourseRequest;
import com.mccserverapp.project.Service.CourseService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/course")
public class CourseController {

    private CourseService courseService;

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Integer id) {
        return courseService.getById(id);
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return courseService.create(course);
    }

    @PostMapping("/dto")
    public Course createWithDTO(@RequestBody CourseRequest courseRequest) {
        return courseService.createWithDTO(courseRequest);
    }

    @PostMapping("/modelmapper")
    public Course createWithModelMapper(@RequestBody CourseRequest courseRequest) {
        return courseService.createWithModelMapper(courseRequest);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Integer id, @RequestBody Course course) {
        return courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public Course delete(@PathVariable Integer id) {
        return courseService.delete(id);
    }

}
