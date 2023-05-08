package com.mccserverapp.project.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mccserverapp.project.Model.AppUserDetail;
import com.mccserverapp.project.Model.User;
import com.mccserverapp.project.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetails loadByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findByUsernameOrEmployee_Email(username, username)
                .orElseThrow(() -> new UsernameNotFoundException("Username or email is incorrect!!!"));
        return new AppUserDetail(user);
    }
}