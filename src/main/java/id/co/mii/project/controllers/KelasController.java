package id.co.mii.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import id.co.mii.project.models.Kelas;
import id.co.mii.project.services.KelasService;
import java.util.List;

@Controller
// @RequestMapping("/kelas")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class KelasController {
    private KelasService kelasService;

    @GetMapping("/kelas")
    public String index(Model model) {
        return "Class/kelas";
    }

    @GetMapping("/kelastrainer")
    public String indexTrain(Model model) {
        return "Class/kelasTrainer";
    }

    @GetMapping("/kelasmanager")
    public String indexManager(Model model) {
        return "Class/kelasManager";
    }

    @GetMapping("/kelascreate")
    public String createView(Kelas kelas, Model model) {
        return "Kelas/create-form";
    }

    @PostMapping("/kelas")
    public String create(Kelas kelas) {
        kelasService.create(kelas);
        return "redirect:/Kelas";
    }

    @GetMapping("/kelasupdate/{id}")
    public String updateView(@PathVariable int id, Model model) {
        model.addAttribute("Kelas", kelasService.getById(id));
        return "Kelas/update-form";
    }

    @PutMapping("/kelas/{id}")
    public String update(@PathVariable int id, Kelas kelas) {
        kelasService.update(id, kelas);
        return "redirect:/Kelas";
    }

    @DeleteMapping("/kelas/{id}")
    public String delete(@PathVariable int id) {
        kelasService.delete(id);
        return "redirect:/Kelas";
    }
}
