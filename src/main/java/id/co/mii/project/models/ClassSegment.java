package id.co.mii.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassSegment {
    private Integer id;
    private Kelas kelas;
    private Segment segment;
    private User user;
}
