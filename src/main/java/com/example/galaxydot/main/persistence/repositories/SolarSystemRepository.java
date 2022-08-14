package com.example.galaxydot.main.persistence.repositories;

import com.example.galaxydot.main.persistence.entities.SolarSystemEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SolarSystemRepository extends JpaRepository<SolarSystemEntity, Long> {

    @EntityGraph(attributePaths = {"planets"})
    @Query("select sse from SolarSystemEntity sse where sse.deleted = false")
    public List<SolarSystemEntity> retrieveWithRelations();

}
