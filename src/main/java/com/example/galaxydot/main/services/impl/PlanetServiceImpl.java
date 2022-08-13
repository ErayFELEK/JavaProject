package com.example.galaxydot.main.services.impl;

import com.example.galaxydot.main.exception.ErrorException;
import com.example.galaxydot.main.mappers.PlanetMapper;
import com.example.galaxydot.main.models.Planet;
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
    public boolean insertPlanet(PlanetRequest planetRequest) {
        var planet = Planet.builder()
                .name(planetRequest.getName())
                .build();

        var entity = mapper.convertToEntity(planet);

        planetRepository.save(entity);

        return true;
    }

    @Override
    public boolean updatePlanet(Planet planet) {
        if(Objects.isNull(planet.getId())) {
            throw new ErrorException("Id is null");
        }

        var optionalEntity = planetRepository.findById(planet.getId());

        if(optionalEntity.isEmpty()) {
            throw new ErrorException("Entity does not exist");
        }

        var entity = optionalEntity.get();
        entity.setName(planet.getName());
        planetRepository.save(entity);

        return true;
    }

    @Override
    public boolean deletePlanet(Long id) {
        planetRepository.deleteById(id);

        return false;
    }
}
