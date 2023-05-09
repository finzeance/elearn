package com.mccserverapp.project.Model.dto.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TaskRequest {

    private String name;
    private String description;
    private String file;
    private Integer courseId;
    // private LocalDateTime startTime;
    // private LocalDateTime endTime;

}
