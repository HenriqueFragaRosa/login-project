package com.henrique.primeiro_projeto.repositories;

import com.henrique.primeiro_projeto.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

// O primeiro parâmetro é a Entidade (User), o segundo é o tipo do ID (String)
public interface UserRepository extends JpaRepository<User, String> {

    // O Spring Security precisa buscar pelo login (email)
    UserDetails findByEmail(String email);
}