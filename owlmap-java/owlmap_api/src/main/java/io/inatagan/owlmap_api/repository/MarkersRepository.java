package io.inatagan.owlmap_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.inatagan.owlmap_api.model.Markers;

@Repository
public interface MarkersRepository extends JpaRepository<Markers, Long> {

}
