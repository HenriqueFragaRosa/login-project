package com.henrique.primeiro_projeto.services;

import com.henrique.primeiro_projeto.repositories.UserRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
class UserService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    @NonNull
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }

    @NonNull
    public UserDetails loadUserById(@NonNull String id) throws UsernameNotFoundException {
        return repository.findUserById(id);
    }
}
