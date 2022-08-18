package com.planeta.foguete.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "planeta")
public class PlanetaDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;

    @Column
    private UUID[][] area;

    public UUID getId() {
        return id;
    }

    public UUID[][] getArea() {
        return area;
    }

    public void setArea(UUID[][] area) {
        this.area = area;
    }
}
