package io.inatagan.owlmap_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.inatagan.owlmap_api.model.Users;

/**
 * Repository interface for USER entity.
 * Provides CRUD operations and custom query methods through JpaRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {}
