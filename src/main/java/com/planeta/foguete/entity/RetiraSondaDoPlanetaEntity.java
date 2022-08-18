package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.Entity;
import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;

public class RetiraSondaDoPlanetaEntity implements Entity<PlanetaDomain> {

    private SondaDomain sondaDomain;
    private PlanetaDomain planetaDomain;

    private RetiraSondaDoPlanetaEntity(SondaDomain sondaDomain,PlanetaDomain planetaDomain){
        this.planetaDomain = planetaDomain;
        this.sondaDomain = sondaDomain;
    }

    public static RetiraSondaDoPlanetaEntity inicia(SondaDomain sondaDomain,PlanetaDomain planetaDomain){
        return new RetiraSondaDoPlanetaEntity(sondaDomain,planetaDomain);
    }

    @Override
    public PlanetaDomain geraSaida() {
        this.planetaDomain.getArea()[this.sondaDomain.getPosx()][this.sondaDomain.getPosy()] = null;
        return this.planetaDomain;
    }
}
