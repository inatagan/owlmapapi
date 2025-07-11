package io.inatagan.owlmap_api.controller;

import io.inatagan.owlmap_api.repository.OwlRepository;
import io.inatagan.owlmap_api.controller.OwlController; // Changed import
import io.inatagan.owlmap_api.entity.Owl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/owlmap")
public class OwlController {

    @Autowired
    OwlRepository owlRepository;

    @GetMapping("/owls")
    public List<Owl> getAllOwls() {
        return owlRepository.findAll();
    }

    @GetMapping("/owls/{id}")
    public Optional<Owl> getOwlById(@PathVariable Long id) {
        return owlRepository.findById(id);
    }

    @PostMapping
    public Owl createOwl(@RequestBody Owl owl) {
        return owlRepository.save(owl);
    }

    @PutMapping("/owls/{id}")
    public Owl updateOwl(@PathVariable Long id, @RequestBody Owl entity) {
        return owlRepository.findById(id).map(owls -> {
            owls.setName(entity.getName());
            return owlRepository.save(owls);
        }).orElseGet(() -> {
            entity.setId(id);
            return owlRepository.save(entity);
        });    }

    @DeleteMapping("/owls/{id}")
    public void deleteOwl(@PathVariable Long id) {
        owlRepository.deleteById(id);
    }
}
