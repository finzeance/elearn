package com.mccserverapp.project.Model.dto.request;

import java.time.LocalDate;

// import java.sql.Date;

import lombok.Data;

@Data
public class KelasRequest {

    private String name;
    private Integer quota;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private Integer programId;

}
