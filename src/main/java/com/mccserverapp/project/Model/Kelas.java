package com.mccserverapp.project.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "class")
public class Kelas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "quota", nullable = false)
    private Integer quota;

    private boolean statusActive = true;

    @OneToMany(mappedBy = "kelas")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<UserClass> userClass;

    @OneToMany(mappedBy = "kelas")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ClassSegment> classSegment;

    @OneToMany(mappedBy = "kelas")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<TaskAssignment> taskAssignment;

    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
    private Program program;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    // @ManyToMany(fetch = FetchType.EAGER)
    // @JoinTable(name = "class_segment", joinColumns = @JoinColumn(name =
    // "class_id"), inverseJoinColumns = @JoinColumn(name = "segment_id"))
    // private List<Segment> segment;

}
