package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.Entity;
import com.planeta.foguete.domain.SondaDomain;

public class RetiraPlanetaDaSondaEntity implements Entity<SondaDomain> {

    private SondaDomain sonda;
    private RetiraPlanetaDaSondaEntity(SondaDomain sonda){
        this.sonda = sonda;
    }

    public static RetiraPlanetaDaSondaEntity inicia(SondaDomain sonda){
        return new RetiraPlanetaDaSondaEntity(sonda);
    }

    @Override
    public SondaDomain geraSaida() {
        this.sonda.setPlanetaId(null);
        return this.sonda;
    }
}
