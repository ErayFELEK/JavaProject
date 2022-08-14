package com.example.galaxydot.main.persistence.repositories;

import com.example.galaxydot.main.persistence.entities.GalaxyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalaxyRepository extends JpaRepository<GalaxyEntity, Long> {
}
