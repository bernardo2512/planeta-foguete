package com.planeta.foguete.domain;

import com.planeta.foguete.enums.OrientacaoEnum;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "sonda")
public class SondaDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;

    @Column
    private Integer posx;

    @Column
    private Integer posy;

    @Column
    @Enumerated(EnumType.STRING)
    private OrientacaoEnum orientacao;

    @Column
    private UUID planetaId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getPosx() {
        return posx;
    }

    public void setPosx(Integer posx) {
        this.posx = posx;
    }

    public Integer getPosy() {
        return posy;
    }

    public void setPosy(Integer posy) {
        this.posy = posy;
    }

    public OrientacaoEnum getOrientacao() {
        return orientacao;
    }

    public void setOrientacao(OrientacaoEnum orientacao) {
        this.orientacao = orientacao;
    }

    public UUID getPlanetaId() {
        return planetaId;
    }

    public void setPlanetaId(UUID planetaId) {
        this.planetaId = planetaId;
    }

    public void moveDireita(){
        OrientacaoEnum novaOrientacao = OrientacaoEnum.proximo(this.getOrientacao());
        this.setOrientacao(novaOrientacao);
    }
    public void moveEsquerda(){
        OrientacaoEnum novaOrientacao = OrientacaoEnum.anterior(this.getOrientacao());
        this.setOrientacao(novaOrientacao);
    }
}
