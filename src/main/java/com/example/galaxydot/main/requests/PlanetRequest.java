package com.example.galaxydot.main.requests;

import com.example.galaxydot.main.models.BasicSolarSystem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PlanetRequest {

    private String name;

    private BasicSolarSystem solarSystem;

}
