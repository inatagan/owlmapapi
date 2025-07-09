package io.inatagan.owlmap_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.inatagan.owlmap_api.model.MapRoutes;
import io.inatagan.owlmap_api.repository.MapRoutesRepository;
import jakarta.validation.Valid;

@RestController
public class MapRoutesController {

    @Autowired
    MapRoutesRepository mapRoutesRepository;

    @GetMapping("/maps")
    List<MapRoutes> getAllMapRoutes() {
        return mapRoutesRepository.findAll();
    }
    
    @GetMapping("/maps/{id}")
    public Optional<MapRoutes> getMapRouteById(@PathVariable Long id) {
        return mapRoutesRepository.findById(id);
    }
    
    @PostMapping("/maps")
    public MapRoutes postNewMapRoute(@Valid @RequestBody MapRoutes entity) {
        return mapRoutesRepository.save(entity);
    }
    
    @DeleteMapping("/maps/{id}")
    public void deleteMapRoute(@PathVariable Long id) {
        mapRoutesRepository.deleteById(id);
    }

    @PutMapping("/maps/{id}")
    public MapRoutes putMapRoute(@PathVariable Long id, @RequestBody MapRoutes entity) {
        return mapRoutesRepository.findById(id).map(mapRoutes -> {
            mapRoutes.setName(entity.getName());
            return mapRoutesRepository.save(mapRoutes);
        }).orElseGet(() -> {
            entity.setId(id);
            return mapRoutesRepository.save(entity);
        });
    }
}
