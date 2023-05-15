package id.co.mii.project.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kelas {
    private Integer id;
    private String name;
    private Integer quota;
    private Boolean statusActive = true;
    private List<UserClass> userClass;
    private List<ClassSegment> classSegment;
    private List<TaskAssignment> taskAssignment;
    private Program program;
}
