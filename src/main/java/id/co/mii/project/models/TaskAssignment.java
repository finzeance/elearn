package id.co.mii.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskAssignment {
    private Integer id;
    private Task task;
    private Kelas kelas;
}
