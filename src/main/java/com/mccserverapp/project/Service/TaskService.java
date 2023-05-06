package com.mccserverapp.project.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mccserverapp.project.Model.Course;
import com.mccserverapp.project.Model.Task;
import com.mccserverapp.project.Model.dto.request.TaskRequest;
import com.mccserverapp.project.Repository.TaskRepository;

@Service
public class TaskService {

    private CourseService courseService;
    private TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(Integer id) {
        return taskRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data task not found!!!"));
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public Task createWithDTO(TaskRequest taskRequest) {
        Task task = new Task();
        task.setName(taskRequest.getName());
        task.setDescription(taskRequest.getDescription());

        Course course = courseService.getById(taskRequest.getCourseId());
        task.setCourse(course);
        return taskRepository.save(task);
    }

    public Task update(Integer id, Task task) {
        getById(id);
        task.setId(id);
        return taskRepository.save(task);
    }

    public Task delete(Integer id) {
        Task task = getById(id);
        taskRepository.delete(task);
        return task;
    }
}
