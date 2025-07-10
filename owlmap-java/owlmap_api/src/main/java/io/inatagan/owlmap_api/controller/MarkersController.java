package io.inatagan.owlmap_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import io.inatagan.owlmap_api.dto.MarkerRecordDto;
import io.inatagan.owlmap_api.entity.Marker;
import io.inatagan.owlmap_api.service.MarkerService;

@RestController
@RequestMapping("/owlmap")
public class MarkersController {

    @Autowired
    private MarkerService markerService;

    
    @GetMapping("markers")
    public ResponseEntity<List<Marker>> getAllMarkers() {
        List<Marker> markers = markerService.findAll();
        return ResponseEntity.ok().body(markers);
    }
    
    @GetMapping("/markers/{id}")
    public ResponseEntity<Marker> getMarkerById(
            @PathVariable Long id) {
        Marker marker = markerService.findById(id);
        if (marker != null)
            return ResponseEntity.ok().body(marker); // Status 200
        return ResponseEntity.notFound().build(); // Status 404
    }
    
    @PostMapping("/markers")
    public ResponseEntity<Marker> createMarker(@RequestBody MarkerRecordDto markerRecordDto) {
        Marker savedMarker = markerService.save(markerRecordDto);
        if (savedMarker != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMarker); // Status 200
        }
        return ResponseEntity.badRequest().build(); // Status 400
    }
    
    
    @PutMapping("/markers/{id}")
    public ResponseEntity<Marker> updateMarker(
        @PathVariable Long id,
        @RequestParam String email,
        @RequestParam String password) {
            Marker marker = markerService.findById(id);
            if (marker != null) {
                markerService.updateById(marker);
                return ResponseEntity.ok().body(marker); // Status 200
            }
            return ResponseEntity.notFound().build(); // Status 404
        }

    @DeleteMapping("/markers/{id}")
    public ResponseEntity<Marker> deleteMarker(
            @PathVariable Long id) {
        Marker marker = markerService.findById(id);
        if (marker != null) {
            markerService.deleteById(marker);
            return ResponseEntity.ok().body(marker); // Status 200
        }
        return ResponseEntity.notFound().build(); // Status 404
    }
}
