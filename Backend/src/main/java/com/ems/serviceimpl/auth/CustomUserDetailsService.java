package com.ems.serviceimpl.auth;

import com.ems.entities.User;
import com.ems.exceptions.ResourceNotFound;
import com.ems.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepo.findByEmployeeId(username)
                .orElseThrow(()-> new ResourceNotFound("User does not exist"));
        return user;
    }
}
