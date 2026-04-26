package com.ims.service;

import com.ims.config.CustomUserDetails;
import com.ims.model.SysAdmin;
import com.ims.repository.SysAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SysAdminService implements UserDetailsService {

    @Autowired
    private SysAdminRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysAdmin admin = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        
        return new CustomUserDetails(admin);
    }
}