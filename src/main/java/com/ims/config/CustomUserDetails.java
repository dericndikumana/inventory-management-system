package com.ims.config;

import com.ims.model.SysAdmin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final SysAdmin sysAdmin;

    public CustomUserDetails(SysAdmin sysAdmin) {
        this.sysAdmin = sysAdmin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(sysAdmin.getRole()));
    }

    @Override
    public String getPassword() {
        return sysAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return sysAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return sysAdmin.isEnabled();
    }

    // This is the custom method that will be accessible in Thymeleaf
    public String getFullName() {
        return sysAdmin.getFullName();
    }
}