package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.Entity;
import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;

public class RetiraPlanetaDaSondaEntity implements Entity<SondaDomain> {

    private SondaDomain sondaDomain;
    private PlanetaDomain planetaDomain;

    private RetiraPlanetaDaSondaEntity(SondaDomain sondaDomain,PlanetaDomain planetaDomain){
        this.planetaDomain = planetaDomain;
        this.sondaDomain = sondaDomain;
    }

    public static RetiraPlanetaDaSondaEntity inicia(SondaDomain sondaDomain,PlanetaDomain planetaDomain){
        return new RetiraPlanetaDaSondaEntity(sondaDomain,planetaDomain);
    }

    @Override
    public SondaDomain geraSaida() {
        this.sondaDomain.setPlanetaId(null);
        return this.sondaDomain;
    }
}
