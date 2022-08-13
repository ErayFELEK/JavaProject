package com.example.galaxydot.main.persistence.entities;

import com.example.galaxydot.main.exception.ErrorException;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

import static com.example.galaxydot.main.persistence.constants.Tables.SOLAR_SYSTEM_TABLE;

@Entity
@Table(name = SOLAR_SYSTEM_TABLE)
@Getter
@Setter
@SQLDelete(sql = "UPDATE solar_systems SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class SolarSystemEntity extends AbstractEntity {

    @Column
    private String name;

    @OneToMany(mappedBy = "solarSystem", fetch = FetchType.LAZY)
    private Set<PlanetEntity> planets;

    @PreRemove
    public void checkRelation() {
        if(!planets.isEmpty()) {
            throw new ErrorException(" Unable to delete. Given solar system has planet relations");
        }
    }

}
