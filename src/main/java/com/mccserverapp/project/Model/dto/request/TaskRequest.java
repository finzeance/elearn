package com.mccserverapp.project.Model.dto.request;

import lombok.Data;

@Data
public class TaskRequest {

    private String name;
    private String description;
    private String file;
    private Integer courseId;

}
