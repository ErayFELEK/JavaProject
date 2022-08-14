package com.example.galaxydot.main.requests;

import com.example.galaxydot.main.models.Galaxy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SolarSystemRequest {

    private String name;

    private Galaxy galaxy;

}
