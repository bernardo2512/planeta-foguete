package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.Entity;
import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;

import java.util.Objects;

public class PousaSondaNoPlanetaEntity implements Entity<PlanetaDomain> {

    private SondaDomain sondaDomainCriada;
    private PlanetaDomain planetaDomain;

    private PousaSondaNoPlanetaEntity(SondaDomain sondaDomainCriada,PlanetaDomain planetaDomain) throws Exception {
        this.planetaDomain = planetaDomain;
        this.sondaDomainCriada = sondaDomainCriada;
        this.valida();
    }

    public static PousaSondaNoPlanetaEntity inicia(SondaDomain sondaDomainCriada,PlanetaDomain planetaDomain) throws Exception {
        return new PousaSondaNoPlanetaEntity(sondaDomainCriada,planetaDomain);
    }

    @Override
    public PlanetaDomain geraSaida() {
        this.planetaDomain.getArea()[this.sondaDomainCriada.getPosx()][this.sondaDomainCriada.getPosy()] = this.sondaDomainCriada.getId();
        return this.planetaDomain;
    }

    private void valida() throws Exception {
        if(!isPousoLivre()){
            throw new Exception("Local de pouso ocupado");
        }
    }

    private Boolean isPousoLivre(){
        return Objects.isNull(this.planetaDomain.getArea()[this.sondaDomainCriada.getPosx()][this.sondaDomainCriada.getPosy()]);
    }
}
