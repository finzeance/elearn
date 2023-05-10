package com.mccserverapp.project.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "segment")
public class Segment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "segment_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "segment")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ClassSegment> classSegment;

    @OneToMany(mappedBy = "segment")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Course> course;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    // @ManyToMany(mappedBy = "segment")
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    // private List<Class> class1;

}
