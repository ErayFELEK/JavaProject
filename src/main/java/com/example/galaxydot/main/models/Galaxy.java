package com.example.galaxydot.main.models;

import com.example.galaxydot.main.enums.GalaxyType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Galaxy {

    private Long id;

    private String name;

    private GalaxyType type;

}
