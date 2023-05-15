package id.co.mii.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import id.co.mii.project.models.Program;
import id.co.mii.project.services.ProgramService;
import java.util.List;

@Controller
// @RequestMapping("/program")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class ProgramController {
    private ProgramService programService;

    @GetMapping("/program")
    public String index(Model model) {
        // List<Program> programs = programService.getAll();
        // model.addAttribute("Program", programs);
        return "Program/addProgram";
    }

    @GetMapping("/programcreate")
    public String createView(Program program, Model model) {
        return "Program/create-form";
    }

    @PostMapping("/program")
    public String create(Program program) {
        programService.create(program);
        return "redirect:/Program";
    }

    @GetMapping("/programupdate/{id}")
    public String updateView(@PathVariable int id, Model model) {
        model.addAttribute("Program", programService.getById(id));
        return "Program/update-form";
    }

    @PutMapping("/program/{id}")
    public String update(@PathVariable int id, Program program) {
        programService.update(id, program);
        return "redirect:/Program";
    }

    @DeleteMapping("/program/{id}")
    public String delete(@PathVariable int id) {
        programService.delete(id);
        return "redirect:/Program";
    }
}
