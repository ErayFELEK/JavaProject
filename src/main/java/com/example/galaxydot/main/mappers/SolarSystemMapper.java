package com.example.galaxydot.main.mappers;

import com.example.galaxydot.main.models.SolarSystem;
import com.example.galaxydot.main.persistence.entities.SolarSystemEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SolarSystemMapper {

    SolarSystem convertToModel(SolarSystemEntity source);

    List<SolarSystem> convertToModelList(List<SolarSystemEntity> source);

    SolarSystemEntity convertToEntity(SolarSystem source);

    List<SolarSystemEntity> convertToEntitylList(List<SolarSystem> source);

}
