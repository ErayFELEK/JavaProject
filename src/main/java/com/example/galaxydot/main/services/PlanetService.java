package com.example.galaxydot.main.services;

import com.example.galaxydot.main.models.Planet;
import com.example.galaxydot.main.requests.PlanetRequest;

import java.util.List;

public interface PlanetService {

    public List<Planet> getPlanets();

    public boolean insertPlanet(PlanetRequest planet);

    public boolean updatePlanet(Planet planetRequest);

    public boolean deletePlanet(Long id);

}
