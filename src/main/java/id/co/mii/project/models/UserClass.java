package id.co.mii.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserClass {
    private Integer id;
    private User user;
    private Kelas kelas;
}
