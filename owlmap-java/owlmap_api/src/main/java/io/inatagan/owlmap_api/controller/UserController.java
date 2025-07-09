package io.inatagan.owlmap_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import io.inatagan.owlmap_api.model.Users;
import io.inatagan.owlmap_api.repository.UserRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    List<Users> getAllUsers() {
        return userRepository.findAll();
    }
    
    @GetMapping("/users/{id}")
    public Optional<Users> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }
    
    @PostMapping("/users")
    public Users postNewUser(@Valid @RequestBody Users entity) {
        return userRepository.save(entity);
    }
    
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @PutMapping("/users/{id}")
    public Users putUser(@PathVariable Long id, @RequestBody Users entity) {
        return userRepository.findById(id).map(user -> {
            user.setName(entity.getName());
            return userRepository.save(user);
        }).orElseGet(() -> {
            entity.setId(id);
            return userRepository.save(entity);
        });
    }

}
