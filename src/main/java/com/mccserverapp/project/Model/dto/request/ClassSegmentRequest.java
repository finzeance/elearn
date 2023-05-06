package com.mccserverapp.project.Model.dto.request;

import lombok.Data;

@Data
public class ClassSegmentRequest {

    private Integer userId;
    private Integer classId;
    private Integer segmentId;

}
