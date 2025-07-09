package io.inatagan.owlmap_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.inatagan.owlmap_api.model.MapRoutes;

@Repository
public interface MapRoutesRepository extends JpaRepository<MapRoutes, Long> {

}
