package id.co.mii.project.controllers.rest;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import id.co.mii.project.models.Kelas;
import id.co.mii.project.services.KelasService;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/kelas")
@AllArgsConstructor
@PreAuthorize("hasRole('xxx')")
public class ApiKelasController {
    private KelasService kelasService;

    @GetMapping
    public List<Kelas> getAll() {
        return kelasService.getAll();
    }

    @GetMapping("/{id}")
    public Kelas getById(@PathVariable int id) {
        return kelasService.getById(id);
    }

    @PostMapping
    public Kelas create(@RequestBody @Valid Kelas kelas) {
        return kelasService.create(kelas);
    }

    @PutMapping("/{id}")
    public Kelas update(@PathVariable int id, @RequestBody @Valid Kelas kelas) {
        return kelasService.update(id, kelas);
    }

    @DeleteMapping("/{id}")
    public Kelas create(@PathVariable int id) {
        return kelasService.delete(id);
    }
}
