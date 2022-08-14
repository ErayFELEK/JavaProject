package com.example.galaxydot.main.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Planet {

    private Long id;

    private String name;

    private BasicSolarSystem solarSystem;

}
