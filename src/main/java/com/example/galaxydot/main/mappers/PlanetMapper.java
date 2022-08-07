package com.example.galaxydot.main.mappers;

import com.example.galaxydot.main.models.Planet;
import com.example.galaxydot.main.persistence.entities.PlanetEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlanetMapper {

    Planet convertToModel(PlanetEntity source);

    List<Planet> convertToModelList(List<PlanetEntity> source);

    PlanetEntity convertToEntity(Planet planet);

    List<PlanetEntity> convertToEntitylList(List<Planet> source);

}
