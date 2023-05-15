package id.co.mii.project.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
   
    private Integer id;
    private String username;
    private String password;
    private Boolean isEnabled = true;
    private Boolean isAccountNonLocked = true;
    private Employee employee;
    private List<Role> role;
    private UserClass userClass;
    private List<ClassSegment> ClassSegment;
}
