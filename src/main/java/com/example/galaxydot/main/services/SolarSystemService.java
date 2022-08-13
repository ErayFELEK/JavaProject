package com.example.galaxydot.main.services;

import com.example.galaxydot.main.models.SolarSystem;
import com.example.galaxydot.main.requests.SolarSystemRequest;

import java.util.List;

public interface SolarSystemService {

    public List<SolarSystem> getSolarSystems();

    public SolarSystem insertSolarSystem(SolarSystemRequest planet);

    public SolarSystem updateSolarSystem(SolarSystem planetRequest);

    public boolean deleteSolarSystem(Long id);

}
