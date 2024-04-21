package com.inventory.yasser.smartStash.services;

import com.inventory.yasser.smartStash.repositories.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserRepo repo;

    public UserDetailsServiceImp(UserRepo repo) {
        this.repo = repo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User is not found"));
    }
}
    