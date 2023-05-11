package com.mccserverapp.project.Model.dto.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TaskAssignmentRequest {

    private Integer classId;
    private Integer taskId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
