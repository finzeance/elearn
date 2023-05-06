package com.mccserverapp.project.Model.dto.request;

import lombok.Data;

@Data
public class CourseRequest {

    private String name;
    private String description;
    private String file; // belom pasti datatypenya
    private Integer segmentId;

}
