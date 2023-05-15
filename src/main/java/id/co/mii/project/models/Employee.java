package id.co.mii.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String nik;
    private boolean statusActive = true;
    private User user;
}
