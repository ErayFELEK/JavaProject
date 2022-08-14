package com.example.galaxydot.main.services.impl;

import com.example.galaxydot.main.exception.ErrorException;
import com.example.galaxydot.main.mappers.PlanetMapper;
import com.example.galaxydot.main.models.Planet;
import com.example.galaxydot.main.persistence.entities.PlanetEntity;
import com.example.galaxydot.main.persistence.entities.SolarSystemEntity;
import com.example.galaxydot.main.persistence.repositories.PlanetRepository;
import com.example.galaxydot.main.requests.PlanetRequest;
import com.example.galaxydot.main.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PlanetServiceImpl implements PlanetService {
    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private PlanetMapper mapper;

    @Override
    public List<Planet> getPlanets() {
        var planets = planetRepository.findAll();

        return mapper.convertToModelList(planets);
    }

    @Override
    public Planet insertPlanet(PlanetRequest planetRequest) {
        var planet = Planet.builder()
                .name(planetRequest.getName())
                .solarSystem(planetRequest.getSolarSystem())
                .build();

        var entity = mapper.convertToEntity(planet);

        return mapper.convertToModel(planetRepository.save(entity));
    }

    @Override
    public Planet updatePlanet(Planet planet) {
        if (Objects.isNull(planet.getId())) {
            throw new ErrorException("Id is null");
        }

        var optionalEntity = planetRepository.findById(planet.getId());

        if (optionalEntity.isEmpty()) {
            throw new ErrorException("Entity does not exist");
        }

        var entity = optionalEntity.get();

        patchEntity(planet, entity);

        return mapper.convertToModel(planetRepository.save(entity));
    }

    @Override
    public boolean deletePlanet(Long id) {
        planetRepository.deleteById(id);

        return true;
    }

    private PlanetEntity patchEntity(Planet planet, PlanetEntity entity) {
        entity.setName(planet.getName());

        SolarSystemEntity solarSystem = new SolarSystemEntity();

        if (Objects.nonNull(planet.getSolarSystem()) && Objects.nonNull(planet.getSolarSystem().getId())) {
            solarSystem.setId(planet.getSolarSystem().getId());
        }

        entity.setSolarSystem(solarSystem);
        return entity;
    }
}
