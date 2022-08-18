package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.Entity;
import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;

import java.util.Objects;

public class PousaSondaNoPlanetaEntity implements Entity<PlanetaDomain> {

    private SondaDomain sondaDomain;
    private PlanetaDomain planetaDomain;

    private PousaSondaNoPlanetaEntity(SondaDomain sondaDomain,PlanetaDomain planetaDomain) throws Exception {
        this.planetaDomain = planetaDomain;
        this.sondaDomain = sondaDomain;
        this.valida();
    }

    public static PousaSondaNoPlanetaEntity inicia(SondaDomain sondaDomain,PlanetaDomain planetaDomain) throws Exception {
        return new PousaSondaNoPlanetaEntity(sondaDomain,planetaDomain);
    }

    @Override
    public PlanetaDomain geraSaida() {
        this.planetaDomain.getArea()[this.sondaDomain.getPosx()][this.sondaDomain.getPosy()] = this.sondaDomain.getId();
        return this.planetaDomain;
    }

    private void valida() throws Exception {
        if(!isPousoLivre() && !isSondaDentroPlaneta()){
            throw new Exception("Impossivel Pousar");
        }
    }

    private Boolean isPousoLivre(){
        return Objects.isNull(this.planetaDomain.getArea()[this.sondaDomain.getPosx()][this.sondaDomain.getPosy()]);
    }
    private Boolean isSondaDentroPlaneta(){
        return this.isSondaAlturaPlaneta() && this.isSondaLarguraPlaneta();
    }
    private Boolean isSondaAlturaPlaneta(){
        return this.sondaDomain.getPosx() <= this.planetaDomain.getArea()[0].length -1 && this.sondaDomain.getPosx() >= 0;
    }
    private Boolean isSondaLarguraPlaneta(){
        return this.sondaDomain.getPosy() <= this.planetaDomain.getArea().length -1 && this.sondaDomain.getPosy() >= 0;
    }
}
