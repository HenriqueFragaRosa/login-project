package com.henrique.primeiro_projeto.repositories;

import com.henrique.primeiro_projeto.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);

    User findUserById(String id);
}