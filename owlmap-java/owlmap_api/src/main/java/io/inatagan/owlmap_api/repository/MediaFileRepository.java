package io.inatagan.owlmap_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.inatagan.owlmap_api.entity.MediaFile;

@Repository
public interface MediaFileRepository extends JpaRepository<MediaFile, Long> {

}
