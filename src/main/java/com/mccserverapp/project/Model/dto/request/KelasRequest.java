package com.mccserverapp.project.Model.dto.request;

// import java.sql.Date;

import lombok.Data;

@Data
public class KelasRequest {

    private String name;
    private Integer quota;
    // private Date startDate;
    // private Date endDate;
    // private Boolean statusActive;
    private Integer programId;

}
