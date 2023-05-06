package com.mccserverapp.project.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mccserverapp.project.Model.Kelas;
import com.mccserverapp.project.Model.User;
import com.mccserverapp.project.Model.UserClass;
import com.mccserverapp.project.Model.dto.request.UserClassRequest;
import com.mccserverapp.project.Repository.UserClassRepository;

@Service
public class UserClassService {

    private UserService userService;
    private KelasService kelasService;
    private UserClassRepository userClassRepository;

    public List<UserClass> getAll() {
        return userClassRepository.findAll();

    }

    public UserClass getById(Integer id) {
        return userClassRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data user_class not found!!!"));

    }

    public UserClass create(UserClass userClass) {
        return userClassRepository.save(userClass);
    }

    public UserClass createWithDTO(UserClassRequest userClassRequest) {
        UserClass userClass = new UserClass();

        User user = userService.getById(userClassRequest.getUserId());
        userClass.setUser(user);
        Kelas kelas = kelasService.getById(userClassRequest.getClassId());
        userClass.setKelas(kelas);
        return userClassRepository.save(userClass);
    }

    public UserClass update(Integer id, UserClass userClass) {
        getById(id);
        userClass.setId(id);
        return userClassRepository.save(userClass);
    }

    public UserClass delete(Integer id) {
        UserClass userClass = getById(id);
        userClassRepository.delete(userClass);
        return userClass;
    }
}
