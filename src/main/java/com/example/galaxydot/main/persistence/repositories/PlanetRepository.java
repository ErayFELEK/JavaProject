package com.example.galaxydot.main.persistence.repositories;

import com.example.galaxydot.main.persistence.entities.PlanetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<PlanetEntity, Long> {
}
