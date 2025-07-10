package io.inatagan.owlmap_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.inatagan.owlmap_api.dto.MarkerRecordDto;
import io.inatagan.owlmap_api.entity.Marker;
import io.inatagan.owlmap_api.repository.MarkersRepository;
import jakarta.transaction.Transactional;

@Service
public class MarkerService {
    @Autowired
    private UserService userService;
    @Autowired
    private MarkersRepository markersRepository;
    public List<Marker> findAll() {
        return markersRepository.findAll();
    }

    public Marker findById(Long id) {
        return markersRepository.findById(null == id ? 0L : id)
                .orElseThrow(() -> new IllegalArgumentException("Marker not found"));
    }

    @Transactional
    public Marker save(MarkerRecordDto markerRecordDto) {
        Marker marker = new Marker();
        try {
            marker.setUser(userService.findById(markerRecordDto.userId()));
            marker.setName(markerRecordDto.name());
            marker.setLongitude(markerRecordDto.longitude());
            marker.setLatitude(markerRecordDto.latitude());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid user ID: " + markerRecordDto.userId(), e);
        }
        return markersRepository.save(marker);
    }

    public void updateById(Marker marker) {
        markersRepository.save(null == marker.getId() ? marker : markersRepository.findById(marker.getId()).orElseThrow(() -> new IllegalArgumentException("Marker not found")));
    }

    public void deleteById(Marker marker) {
        markersRepository.deleteById(null == marker.getId() ? marker.getId() : markersRepository.findById(marker.getId()).orElseThrow(() -> new IllegalArgumentException("Marker not found")).getId());
    }



}
