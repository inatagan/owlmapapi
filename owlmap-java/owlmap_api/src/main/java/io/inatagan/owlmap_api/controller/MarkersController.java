package io.inatagan.owlmap_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.inatagan.owlmap_api.entity.Marker;
import io.inatagan.owlmap_api.service.MarkerService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/owlmap")
public class MarkersController {

    @Autowired
    private MarkerService markerService;

    
    @GetMapping("markers")
    public ResponseEntity<List<Marker>> getAllUsers() {
        List<Marker> markers = markerService.findAll();
        return ResponseEntity.ok().body(markers);
    }
    
    @GetMapping("/markers/{id}")
    public ResponseEntity<Marker> getOneUser(
            @PathVariable Long id) {
        Marker user = markerService.findById(id);
        if (user != null)
            return ResponseEntity.ok().body(user); // Status 200
        return ResponseEntity.notFound().build(); // Status 404
    }
    
    @PostMapping("/markers")
    public ResponseEntity<Marker> createUser(@Valid @RequestBody Marker user) {
        Marker savedUser = markerService.save(user);
        if (savedUser != null) {
            return ResponseEntity.ok().body(savedUser); // Status 200
        }
        return ResponseEntity.badRequest().build(); // Status 400
    }
    
    
    @PutMapping("/markers/{id}")
    public ResponseEntity<Marker> updateUser(
        @PathVariable Long id,
        @RequestParam String email,
        @RequestParam String password) {
            Marker user = markerService.findById(id);
            if (user != null) {
                markerService.updateById(user);
                return ResponseEntity.ok().body(user); // Status 200
            }
            return ResponseEntity.notFound().build(); // Status 404
        }

    @DeleteMapping("/markers/{id}")
    public ResponseEntity<Marker> deleteUser(
            @PathVariable Long id) {
        Marker user = markerService.findById(id);
        if (user != null) {
            markerService.deleteById(user);
            return ResponseEntity.ok().body(user); // Status 200
        }
        return ResponseEntity.notFound().build(); // Status 404
    }
}
