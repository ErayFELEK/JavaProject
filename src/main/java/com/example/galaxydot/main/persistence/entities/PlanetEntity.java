package com.example.galaxydot.main.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import static com.example.galaxydot.main.persistence.constants.Tables.PLANET_TABLE;

@Entity
@Table(name = PLANET_TABLE)
@Getter
@Setter
@SQLDelete(sql = "UPDATE planets SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class PlanetEntity extends AbstractEntity {

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solar_system_id")
    private SolarSystemEntity solarSystem;

}
