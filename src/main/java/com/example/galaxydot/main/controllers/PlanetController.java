package com.example.galaxydot.main.controllers;

import com.example.galaxydot.main.models.Planet;
import com.example.galaxydot.main.requests.PlanetRequest;
import com.example.galaxydot.main.responses.AbstractResponse;
import com.example.galaxydot.main.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @GetMapping
    public AbstractResponse retrievePlanets() {
        return AbstractResponse.builder()
                .status(HttpStatus.OK)
                .data(planetService.getPlanets())
                .build();
    }

    @PostMapping
    public AbstractResponse insertPlanet(@RequestBody PlanetRequest planet) {
        return AbstractResponse.builder()
                .status(HttpStatus.OK)
                .data(planetService.insertPlanet(planet))
                .build();
    }

    @PutMapping
    public AbstractResponse updatePlanet(@RequestBody Planet planet) {
        return AbstractResponse.builder()
                .status(HttpStatus.OK)
                .data(planetService.updatePlanet(planet))
                .build();
    }

    @DeleteMapping("/{id}")
    public AbstractResponse deletePlanet(@PathVariable Long id) {
        return AbstractResponse.builder()
                .status(HttpStatus.OK)
                .data(planetService.deletePlanet(id))
                .build();
    }

}
