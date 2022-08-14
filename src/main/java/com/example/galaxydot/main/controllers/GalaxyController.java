package com.example.galaxydot.main.controllers;

import com.example.galaxydot.main.models.Galaxy;
import com.example.galaxydot.main.requests.GalaxyRequest;
import com.example.galaxydot.main.responses.AbstractResponse;
import com.example.galaxydot.main.services.GalaxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/galaxies")
public class GalaxyController {

    @Autowired
    private GalaxyService galaxyService;

    @GetMapping
    public AbstractResponse retrieveGalaxies() {
        return AbstractResponse.builder()
                .status(HttpStatus.OK)
                .data(galaxyService.getGalaxies())
                .build();
    }

    @PostMapping
    public AbstractResponse insertGalaxy(@RequestBody GalaxyRequest galaxy) {
        return AbstractResponse.builder()
                .status(HttpStatus.OK)
                .data(galaxyService.insertGalaxy(galaxy))
                .build();
    }

    @PutMapping
    public AbstractResponse updateGalaxy(@RequestBody Galaxy galaxy) {
        return AbstractResponse.builder()
                .status(HttpStatus.OK)
                .data(galaxyService.updateGalaxy(galaxy))
                .build();
    }

    @DeleteMapping("/{id}")
    public AbstractResponse deleteGalaxy(@PathVariable Long id) {
        return AbstractResponse.builder()
                .status(HttpStatus.OK)
                .data(galaxyService.deleteGalaxy(id))
                .build();
    }

}
