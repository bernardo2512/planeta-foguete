package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.EntitySondaComPlaneta;
import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;

public class RetiraSondaDoPlanetaEntity extends EntitySondaComPlaneta<PlanetaDomain> {

    private RetiraSondaDoPlanetaEntity(SondaDomain sonda,PlanetaDomain planeta){
        super(sonda,planeta);
    }

    public static RetiraSondaDoPlanetaEntity inicia(SondaDomain sonda,PlanetaDomain planeta){
        return new RetiraSondaDoPlanetaEntity(sonda,planeta);
    }

    @Override
    public PlanetaDomain geraSaida() {
        this.planeta.getArea()[this.sonda.getPosx()][this.sonda.getPosy()] = null;
        return this.planeta;
    }
}
