package com.example.galaxydot.main.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class SolarSystem {

    private Long id;

    private String name;

    private List<BasicPlanet> planets;

    private Galaxy galaxy;

}
