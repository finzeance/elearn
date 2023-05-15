package id.co.mii.project.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Integer id;
    private String name;
    private String description;
    private List<TaskAssignment> taskAssignment;
    private Course course;
}
