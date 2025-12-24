package com.henrique.primeiro_projeto.controllers;

import com.henrique.primeiro_projeto.domain.user.User;
import com.henrique.primeiro_projeto.dtos.RegisterDTO;
import com.henrique.primeiro_projeto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/create")
    public ResponseEntity<RegisterDTO> register(@RequestBody RegisterDTO data){
        if(this.repository.findByEmail(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.name());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        this.repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
