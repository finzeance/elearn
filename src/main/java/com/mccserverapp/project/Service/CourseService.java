package com.mccserverapp.project.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mccserverapp.project.Model.Course;
import com.mccserverapp.project.Repository.CourseRepository;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course getById(Integer id) {
        return courseRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data course not found"));
    }

    public Course create(Course course) {
        return courseRepository.save(course);
    }

    public Course update(Integer id, Course course) {
        getById(id);
        course.setId(id);
        return courseRepository.save(course);
    }

    public Course delete(Integer id) {
        Course course = getById(id);
        courseRepository.delete(course);
        return course;
    }

}
