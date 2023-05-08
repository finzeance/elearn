package com.mccserverapp.project.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AppUserDetail implements UserDetails {

    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        user
                .getRole()
                .forEach(role -> {
                    String roleName = "ROLE_" + role.getName().toUpperCase();
                    authorities.add(new SimpleGrantedAuthority(roleName));
                    role
                            .getPrivilege()
                            .forEach(privilege -> {
                                String privilegeName = privilege.getName().toUpperCase();
                                authorities.add(new SimpleGrantedAuthority(privilegeName));
                            });
                });
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getIsAccountNonLocked();
    }

    @Override
    public boolean isEnabled() {
        return user.getIsEnabled();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;

    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
