package com.mccserverapp.project.Model.dto.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ClassSegmentRequest {

    private Integer userId;
    private Integer classId;
    private Integer segmentId;
    private LocalDate startDate;
    private LocalDate endDate;

}
