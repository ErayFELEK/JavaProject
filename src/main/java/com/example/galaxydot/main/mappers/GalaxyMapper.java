package com.example.galaxydot.main.mappers;

import com.example.galaxydot.main.models.Galaxy;
import com.example.galaxydot.main.persistence.entities.GalaxyEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GalaxyMapper {

    Galaxy convertToModel(GalaxyEntity source);

    List<Galaxy> convertToModelList(List<GalaxyEntity> source);

    GalaxyEntity convertToEntity(Galaxy planet);

    List<GalaxyEntity> convertToEntitylList(List<Galaxy> source);

}
