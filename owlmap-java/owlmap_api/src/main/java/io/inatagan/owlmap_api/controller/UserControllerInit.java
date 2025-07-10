package io.inatagan.owlmap_api.controller;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.inatagan.owlmap_api.entity.User;
import io.inatagan.owlmap_api.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



/*
 * This controller is used to initialize the database with users from a JSON file.
 */
@RestController
@RequestMapping("/owlmap")
public class UserControllerInit {

    @Autowired
    UserService userService;

       
    @PostMapping("/users/init")
    public ResponseEntity<Set<User>> createUser() {
        // Read JSON file containing users
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("user.json");
        Set<User> users;
        try {
            users = objectMapper.readValue(file, new TypeReference<Set<User>>() {});
            for (User u : users) {
                userService.save(u);
                System.out.println(u.getName() + " " + u.getEmail() + " " + u.getPassword());
            }
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
      
        return ResponseEntity.ok().body(users); // Status 200
    }
    

}
