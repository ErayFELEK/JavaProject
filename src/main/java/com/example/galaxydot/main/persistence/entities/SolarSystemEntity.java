package com.example.galaxydot.main.persistence.entities;

import javax.persistence.*;

import java.time.Instant;
import java.util.Set;

import static com.example.galaxydot.main.persistence.constants.Tables.SOLAR_SYSTEM_TABLE;

@Entity
@Table(name = SOLAR_SYSTEM_TABLE)
public class SolarSystemEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy="solarSystem", fetch = FetchType.LAZY)
    private Set<PlanetEntity> planets;

    private Instant createdAt;

    private String createdBy;

    private Instant updatedAt;

    private String updatedBy;

}
