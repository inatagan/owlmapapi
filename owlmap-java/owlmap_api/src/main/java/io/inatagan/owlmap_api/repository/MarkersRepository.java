package io.inatagan.owlmap_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.inatagan.owlmap_api.entity.Marker;

@Repository
public interface MarkersRepository extends JpaRepository<Marker, Long> {

}
