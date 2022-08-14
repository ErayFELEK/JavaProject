package com.example.galaxydot.main.services.impl;

import com.example.galaxydot.main.exception.ErrorException;
import com.example.galaxydot.main.mappers.GalaxyMapper;
import com.example.galaxydot.main.models.Galaxy;
import com.example.galaxydot.main.persistence.repositories.GalaxyRepository;
import com.example.galaxydot.main.requests.GalaxyRequest;
import com.example.galaxydot.main.services.GalaxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GalaxyServiceImpl implements GalaxyService {

    @Autowired
    private GalaxyRepository galaxyRepository;

    @Autowired
    private GalaxyMapper mapper;

    @Override
    public List<Galaxy> getGalaxies() {
        var planets = galaxyRepository.findAll();

        return mapper.convertToModelList(planets);
    }

    @Override
    public Galaxy insertGalaxy(GalaxyRequest planetRequest) {
        var planet = Galaxy.builder()
                .name(planetRequest.getName())
                .type(planetRequest.getType())
                .build();

        var entity = mapper.convertToEntity(planet);

        return mapper.convertToModel(galaxyRepository.save(entity));
    }

    @Override
    public Galaxy updateGalaxy(Galaxy galaxy) {
        if (Objects.isNull(galaxy.getId())) {
            throw new ErrorException("Id is null");
        }

        var optionalEntity = galaxyRepository.findById(galaxy.getId());

        if (optionalEntity.isEmpty()) {
            throw new ErrorException("Entity does not exist");
        }

        var entity = optionalEntity.get();
        entity.setName(galaxy.getName());

        return mapper.convertToModel(galaxyRepository.save(entity));
    }


    @Override
    public boolean deleteGalaxy(Long id) {
        galaxyRepository.deleteById(id);

        return true;
    }

}
