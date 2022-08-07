package com.example.galaxydot.main.persistence.repositories;

import com.example.galaxydot.main.persistence.entities.SolarSystemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolarSystemRepository extends JpaRepository<SolarSystemEntity, Long> {
}
