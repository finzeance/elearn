package com.mccserverapp.project.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mccserverapp.project.Model.Task;
import com.mccserverapp.project.Model.dto.request.TaskRequest;
import com.mccserverapp.project.Service.FileStorageService;
import com.mccserverapp.project.Service.TaskService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/task")
@PreAuthorize("hasRole('STUDENT', 'MANAGER', 'TRAINER')")
public class TaskController {

    private TaskService taskService;
    private FileStorageService fileStorageService;
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @PreAuthorize("hasAuthority('READ_STUDENT', 'READ_MANAGER', 'READ_TRAINER')")
    @GetMapping
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @PreAuthorize("hasAuthority('READ_STUDENT', 'READ_MANAGER', 'READ_TRAINER')")
    @GetMapping("/{id}")
    public Task getById(@PathVariable Integer id) {
        return taskService.getById(id);
    }

    @PreAuthorize("hasAuthority('CREATE_MANAGER', 'CREATE_TRAINER')")
    @PostMapping
    public Task create(@RequestBody Task task) {
        return taskService.create(task);
    }

    @PreAuthorize("hasAuthority('CREATE_MANAGER', 'CREATE_TRAINER')")
    @PostMapping("/dto")
    public Task createWithDTO(@RequestBody TaskRequest taskRequest) {
        return taskService.createWithDTO(taskRequest);
    }

    @PreAuthorize("hasAuthority('CREATE_MANAGER', 'CREATE_TRAINER')")
    @PostMapping("/modelmapper/multifile")
    public Task createWithModelMapperWithMultifile(TaskRequest taskRequest, @RequestParam MultipartFile file) {
        return taskService.createWithModelMapperWithMultifile(taskRequest, file);
    }
    
    @PreAuthorize("hasAuthority('CREATE_MANAGER', 'CREATE_TRAINER')")
    @PostMapping("/modelmapper")
    public Task createWithModelMapper(@RequestBody TaskRequest taskRequest) {
        return taskService.createWithModelMapper(taskRequest);
    }

    @PreAuthorize("hasAuthority('UPDATE_MANAGER', 'UPDATE_TRAINER')")
    @PutMapping("/{id}")
    public Task update(@PathVariable Integer id, @RequestBody Task task) {
        return taskService.update(id, task);
    }

    @PreAuthorize("hasAuthority('DELETE_MANAGER', 'DELETE_TRAINER')")
    @DeleteMapping("/{id}")
    public Task delete(@PathVariable Integer id) {
        return taskService.delete(id);
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // load file as resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // try to dertermine file's content type
        String contentType = null;

        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            logger.info("Could not determine file type.");
        }

        // fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
