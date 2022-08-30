package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.EntitySondaComPlaneta;
import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;

public class VinculaPlanetaNaSondaEntity extends EntitySondaComPlaneta<SondaDomain> {

    private VinculaPlanetaNaSondaEntity(SondaDomain sonda,PlanetaDomain planeta){
        super(sonda,planeta);
    }

    public static VinculaPlanetaNaSondaEntity inicia(SondaDomain sonda,PlanetaDomain planeta){
        return new VinculaPlanetaNaSondaEntity(sonda,planeta);
    }
    @Override
    public SondaDomain geraSaida() {
        this.sonda.setPlanetaId(this.planeta.getId());
        return sonda;
    }
}
