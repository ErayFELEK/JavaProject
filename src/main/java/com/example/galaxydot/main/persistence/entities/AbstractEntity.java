package com.example.galaxydot.main.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    private String createdBy;

    @Column(name = "updated_at")
    private Instant updatedAt;

    private String updatedBy;

    private boolean deleted;

}
