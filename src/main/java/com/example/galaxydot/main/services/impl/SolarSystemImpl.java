package com.example.galaxydot.main.services.impl;

import com.example.galaxydot.main.exception.ErrorException;
import com.example.galaxydot.main.mappers.SolarSystemMapper;
import com.example.galaxydot.main.models.SolarSystem;
import com.example.galaxydot.main.persistence.repositories.SolarSystemRepository;
import com.example.galaxydot.main.requests.SolarSystemRequest;
import com.example.galaxydot.main.services.SolarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SolarSystemImpl implements SolarSystemService {

    @Autowired
    private SolarSystemRepository solarSystemRepository;

    @Autowired
    private SolarSystemMapper mapper;

    @Override
    public List<SolarSystem> getSolarSystems() {
        var solarSystems = solarSystemRepository.findAll();

        return mapper.convertToModelList(solarSystems);
    }

    @Override
    public SolarSystem insertSolarSystem(SolarSystemRequest solarSystemRequest) {
        var solarSystem = SolarSystem.builder()
                .name(solarSystemRequest.getName())
                .build();

        var entity = mapper.convertToEntity(solarSystem);

        return mapper.convertToModel(solarSystemRepository.save(entity));
    }

    @Override
    public SolarSystem updateSolarSystem(SolarSystem solarSystem) {
        if (Objects.isNull(solarSystem.getId())) {
            throw new ErrorException("Id is null");
        }


        var optionalEntity = solarSystemRepository.findById(solarSystem.getId());

        if (optionalEntity.isEmpty()) {
            throw new ErrorException("Entity does not exist");
        }

        var entity = optionalEntity.get();
        entity.setName(solarSystem.getName());


        return mapper.convertToModel(solarSystemRepository.save(entity));
    }

    @Override
    public boolean deleteSolarSystem(Long id) {
        var solarSystem = solarSystemRepository.findById(id);

        if (solarSystem.isPresent()) {
            solarSystemRepository.deleteById(id);

            return true;
        }

        throw new ErrorException(String.format("Solar system is not found with the given id: %d", id));
    }

}
