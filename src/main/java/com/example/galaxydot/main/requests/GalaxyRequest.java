package com.example.galaxydot.main.requests;

import com.example.galaxydot.main.enums.GalaxyType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GalaxyRequest {

    private String name;

    private GalaxyType type;

}
