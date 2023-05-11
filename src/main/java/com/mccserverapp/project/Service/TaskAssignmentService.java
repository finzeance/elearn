package com.mccserverapp.project.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mccserverapp.project.Model.Kelas;
import com.mccserverapp.project.Model.Task;
import com.mccserverapp.project.Model.TaskAssignment;
import com.mccserverapp.project.Model.dto.request.TaskAssignmentRequest;
import com.mccserverapp.project.Repository.TaskAssignmentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskAssignmentService {

    private KelasService kelasService;
    private TaskService taskService;
    private TaskAssignmentRepository taskAssignmentRepository;
    private ModelMapper modelMapper;

    public List<TaskAssignment> getAll() {
        return taskAssignmentRepository.findAll();
    }

    public TaskAssignment getById(Integer id) {
        return taskAssignmentRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data task-assignment not found"));
    }

    public TaskAssignment create(TaskAssignment taskAssignment) {
        return taskAssignmentRepository.save(taskAssignment);
    }

    public TaskAssignment createWithDTO(TaskAssignmentRequest taskAssignmentRequest) {
        TaskAssignment taskAssignment = new TaskAssignment();

        Kelas kelas = kelasService.getById(taskAssignmentRequest.getClassId());
        taskAssignment.setKelas(kelas);
        Task task = taskService.getById(taskAssignmentRequest.getTaskId());
        taskAssignment.setTask(task);
        return taskAssignmentRepository.save(taskAssignment);
    }

    public TaskAssignment createWithModelMapper(TaskAssignmentRequest taskAssignmentRequest) {
        TaskAssignment taskAssignment = modelMapper.map(taskAssignmentRequest, TaskAssignment.class);
        taskAssignment.setKelas(kelasService.getById(taskAssignmentRequest.getClassId()));
        taskAssignment.setTask(taskService.getById(taskAssignmentRequest.getTaskId()));

        return taskAssignmentRepository.save(taskAssignment);

    }

    public TaskAssignment update(Integer id, TaskAssignment taskAssignment) {
        getById(id);
        taskAssignment.setId(id);
        return taskAssignmentRepository.save(taskAssignment);
    }

    public TaskAssignment delete(Integer id) {
        TaskAssignment taskAssignment = getById(id);
        taskAssignmentRepository.delete(taskAssignment);
        return taskAssignment;
    }
}
