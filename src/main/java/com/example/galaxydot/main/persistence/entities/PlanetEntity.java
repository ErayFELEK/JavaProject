package com.example.galaxydot.main.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.Instant;

import static com.example.galaxydot.main.persistence.constants.Tables.PLANET_TABLE;

@Entity
@Table(name = PLANET_TABLE)
@Getter
@Setter
public class PlanetEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private SolarSystemEntity solarSystem;

    private Instant createdAt;

    private String createdBy;

    private Instant updatedAt;

    private String updatedBy;

}
