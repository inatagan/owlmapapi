package io.inatagan.owlmap_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.inatagan.owlmap_api.entity.User;
import io.inatagan.owlmap_api.service.UserService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/owlmap")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }
    
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getOneUser(
            @PathVariable Long id) {
        User user = userService.findById(id);
        if (user != null)
            return ResponseEntity.ok().body(user); // Status 200
        return ResponseEntity.notFound().build(); // Status 404
    }
    
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);
        if (savedUser != null) {
            return ResponseEntity.ok().body(savedUser); // Status 200
        }
        return ResponseEntity.badRequest().build(); // Status 400
    }
    
    
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(
        @PathVariable Long id,
        @RequestParam String email,
        @RequestParam String password) {
            User user = userService.findById(id);
            if (user != null) {
                userService.updateById(user);
                return ResponseEntity.ok().body(user); // Status 200
            }
            return ResponseEntity.notFound().build(); // Status 404
        }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(
            @PathVariable Long id) {
        User user = userService.findById(id);
        if (user != null) {
            userService.deleteById(user);
            return ResponseEntity.ok().body(user); // Status 200
        }
        return ResponseEntity.notFound().build(); // Status 404
    }

}
