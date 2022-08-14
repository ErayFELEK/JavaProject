package com.example.galaxydot.main.services;

import com.example.galaxydot.main.models.Galaxy;
import com.example.galaxydot.main.requests.GalaxyRequest;

import java.util.List;

public interface GalaxyService {

    public List<Galaxy> getGalaxies();

    public Galaxy insertGalaxy(GalaxyRequest galaxyRequest);

    public Galaxy updateGalaxy(Galaxy galaxy);

    public boolean deleteGalaxy(Long id);

}
