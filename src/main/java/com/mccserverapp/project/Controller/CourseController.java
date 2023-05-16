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

import com.mccserverapp.project.Model.Course;
import com.mccserverapp.project.Model.dto.request.CourseRequest;
import com.mccserverapp.project.Service.CourseService;
import com.mccserverapp.project.Service.FileStorageService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/course")
@PreAuthorize("hasRole('STUDENT', 'MANAGER', 'TRAINER')")
public class CourseController {

    private FileStorageService fileStorageService;
    private CourseService courseService;
    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @PreAuthorize("hasAuthority('READ_STUDENT', 'READ_MANAGER', 'READ_TRAINER')")
    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @PreAuthorize("hasAuthority('READ_STUDENT', 'READ_MANAGER', 'READ_TRAINER')")
    @GetMapping("/{id}")
    public Course getById(@PathVariable Integer id) {
        return courseService.getById(id);
    }

    @PreAuthorize("hasAuthority('CREATE_MANAGER', 'CREATE_TRAINER')")
    @PostMapping
    public Course create(@RequestBody Course course) {
        return courseService.create(course);
    }

    @PreAuthorize("hasAuthority('CREATE_MANAGER', 'CREATE_TRAINER')")
    @PostMapping("/dto")
    public Course createWithDTO(@RequestBody CourseRequest courseRequest) {
        return courseService.createWithDTO(courseRequest);
    }

    @PreAuthorize("hasAuthority('CREATE_MANAGER', 'CREATE_TRAINER')")
    @PostMapping("/modelmapper/file")
    public Course createWithModelMapper(CourseRequest courseRequest, @RequestParam MultipartFile file) {
        return courseService.createWithModelMapperWithMultifile(courseRequest, file);
    }
    
    @PreAuthorize("hasAuthority('CREATE_MANAGER', 'CREATE_TRAINER')")
    @PostMapping("/modelmapper")
    public Course createWithModelMapper(@RequestBody CourseRequest courseRequest) {
        return courseService.createWithModelMapper(courseRequest);
    }

    @PreAuthorize("hasAuthority('UPDATE_MANAGER', 'UPDATE_TRAINER')")
    @PutMapping("/{id}")
    public Course update(@PathVariable Integer id, @RequestBody Course course) {
        return courseService.update(id, course);
    }

    @PreAuthorize("hasAuthority('DELETE_MANAGER', 'DELETE_TRAINER')")
    @DeleteMapping("/{id}")
    public Course delete(@PathVariable Integer id) {
        return courseService.delete(id);
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
