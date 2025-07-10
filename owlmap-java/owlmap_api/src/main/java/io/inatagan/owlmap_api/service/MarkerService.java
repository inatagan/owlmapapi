package io.inatagan.owlmap_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.inatagan.owlmap_api.entity.Marker;
import io.inatagan.owlmap_api.repository.MarkersRepository;

@Service
public class MarkerService {
    @Autowired
    private MarkersRepository markersRepository;
    public List<Marker> findAll() {
        return markersRepository.findAll();
    }

    public Marker findById(Long id) {
        return markersRepository.findById(null == id ? 0L : id)
                .orElseThrow(() -> new IllegalArgumentException("Marker not found"));
    }

    public Marker save(Marker marker) {
        return markersRepository.save(marker);
    }

    public void updateById(Marker marker) {
        markersRepository.save(null == marker.getId() ? marker : markersRepository.findById(marker.getId()).orElseThrow(() -> new IllegalArgumentException("Marker not found")));
    }

    public void deleteById(Marker marker) {
        markersRepository.deleteById(null == marker.getId() ? marker.getId() : markersRepository.findById(marker.getId()).orElseThrow(() -> new IllegalArgumentException("Marker not found")).getId());
    }



}
