package com.mccserverapp.project.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mccserverapp.project.Model.Kelas;
import com.mccserverapp.project.Model.Program;
import com.mccserverapp.project.Model.User;
import com.mccserverapp.project.Model.UserClass;
import com.mccserverapp.project.Model.dto.request.KelasRequest;
import com.mccserverapp.project.Repository.KelasRepository;

@Service
public class KelasService {

    private ProgramService programService;
    private KelasRepository kelasRepository;

    public List<Kelas> getAll() {
        return kelasRepository.findAll();
    }

    public Kelas getById(Integer id) {
        return kelasRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data class not found"));
    }

    public Kelas create(Kelas kelas) {
        return kelasRepository.save(kelas);
    }

    // membuat kelas dari program
    public Kelas createWithDTO(KelasRequest kelasRequest) {
        Kelas kelas1 = new Kelas();
        kelas1.setName(kelasRequest.getName());
        kelas1.setQuota(kelasRequest.getQuota());
        // kelas1.setStatusActive(kelasRequest.getStatusActive());

        Program program = programService.getById(kelasRequest.getProgramId());
        kelas1.setProgram(program);
        return kelasRepository.save(kelas1);
    }

    public Kelas update(Integer id, Kelas kelas) {
        getById(id);
        kelas.setId(id);
        return kelasRepository.save(kelas);
    }

    public Kelas delete(Integer id) {
        Kelas kelas = getById(id);
        kelasRepository.delete(kelas);
        return kelas;
    }

}
