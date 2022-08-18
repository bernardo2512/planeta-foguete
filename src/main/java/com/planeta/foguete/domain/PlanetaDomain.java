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
    private Integer[][] area;

    public UUID getId() {
        return id;
    }

    public Integer[][] getArea() {
        return area;
    }

    public void setArea(Integer[][] area) {
        this.area = area;
    }
}
