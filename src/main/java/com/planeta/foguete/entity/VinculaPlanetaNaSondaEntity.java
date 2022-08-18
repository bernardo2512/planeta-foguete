package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.Entity;
import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;

public class VinculaPlanetaNaSondaEntity implements Entity<SondaDomain> {

    private SondaDomain sondaDomain;
    private PlanetaDomain planetaDomain;

    private VinculaPlanetaNaSondaEntity(SondaDomain sondaDomain,PlanetaDomain planetaDomain){
        this.planetaDomain = planetaDomain;
        this.sondaDomain = sondaDomain;
    }

    public static VinculaPlanetaNaSondaEntity inicia(SondaDomain sondaDomain,PlanetaDomain planetaDomain){
        return new VinculaPlanetaNaSondaEntity(sondaDomain,planetaDomain);
    }
    @Override
    public SondaDomain geraSaida() {
        this.sondaDomain.setPlanetaId(this.planetaDomain.getId());
        return sondaDomain;
    }
}
