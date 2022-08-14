package com.example.galaxydot.main.persistence.entities;

import com.example.galaxydot.main.enums.GalaxyType;
import com.example.galaxydot.main.exception.ErrorException;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

import static com.example.galaxydot.main.persistence.constants.Tables.GALAXY_TABLE;

@Entity
@Table(name = GALAXY_TABLE)
@Getter
@Setter
@SQLDelete(sql = "UPDATE galaxies SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class GalaxyEntity extends AbstractEntity {

    @Column
    private String name;

    @OneToMany(mappedBy = "galaxy", fetch = FetchType.LAZY)
    private Set<SolarSystemEntity> solarSystems;

    @Enumerated(EnumType.STRING)
    private GalaxyType type;

    @PreRemove
    public void checkRelation() {
        if (!solarSystems.isEmpty()) {
            throw new ErrorException(" Unable to delete. Given galaxy has solar system relations");
        }
    }

}
