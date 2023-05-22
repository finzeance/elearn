package id.co.mii.project.models;

// import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Program {
    private Integer id;
    private String name;
    private String description;
    // private List<Program> program;
}
