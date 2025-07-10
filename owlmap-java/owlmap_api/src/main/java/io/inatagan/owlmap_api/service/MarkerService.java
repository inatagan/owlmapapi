package io.inatagan.owlmap_api.service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.inatagan.owlmap_api.dto.MarkerRecordDto;
import io.inatagan.owlmap_api.entity.Marker;
import io.inatagan.owlmap_api.repository.MarkersRepository;
import io.inatagan.owlmap_api.repository.UserRepository;
import jakarta.transaction.Transactional;


@Service
public class MarkerService {
    
    @Autowired
    private MarkersRepository markersRepository;
    @Autowired
    private UserRepository userRepository;

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
            marker.setUsers(userRepository.findAllById(markerRecordDto.userId()).stream().collect(Collectors.toSet()));
            marker.setName(markerRecordDto.name());
            marker.setLongitude(markerRecordDto.longitude());
            marker.setLatitude(markerRecordDto.latitude());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid user ID: " + markerRecordDto.userId(), e);
        }
        return markersRepository.save(marker);
    }
    @Transactional
    public Marker saveById(MarkerRecordDto markerRecordDto, Long marKerId) {
        Marker marker = markersRepository.findById(null == marKerId ? 0L : marKerId)
                .orElseThrow(() -> new IllegalArgumentException("Marker not found"));
        try {
            Set<Long> userIds = marker.getUsers().stream().map(user -> user.getId()).collect(Collectors.toSet());
            // Combine existing user IDs and new user IDs into a single set
            Set<Long> combinedUserIds = new java.util.HashSet<>(userIds);
            combinedUserIds.addAll(markerRecordDto.userId());
            marker.setUsers(userRepository.findAllById(combinedUserIds).stream().collect(Collectors.toSet()));
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
