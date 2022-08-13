package com.example.galaxydot.main.controllers;

import com.example.galaxydot.main.models.SolarSystem;
import com.example.galaxydot.main.requests.SolarSystemRequest;
import com.example.galaxydot.main.responses.AbstractResponse;
import com.example.galaxydot.main.services.SolarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solar-systems")
public class SolarSystemController {

    @Autowired
    private SolarSystemService solarSystemService;

    @GetMapping
    public AbstractResponse retrieveSolarSystems() {
        return AbstractResponse.builder()
                .status(HttpStatus.OK)
                .data(solarSystemService.getSolarSystems())
                .build();
    }

    @PostMapping
    public AbstractResponse insertSolarSystem(@RequestBody SolarSystemRequest planet) {
        return AbstractResponse.builder()
                .status(HttpStatus.OK)
                .data(solarSystemService.insertSolarSystem(planet))
                .build();
    }

    @PutMapping
    public AbstractResponse updateSolarSystem(@RequestBody SolarSystem planet) {
        return AbstractResponse.builder()
                .status(HttpStatus.OK)
                .data(solarSystemService.updateSolarSystem(planet))
                .build();
    }

    @DeleteMapping("/{id}")
    public AbstractResponse deleteSolarSystem(@PathVariable Long id) {
        return AbstractResponse.builder()
                .status(HttpStatus.OK)
                .data(solarSystemService.deleteSolarSystem(id))
                .build();
    }

}
