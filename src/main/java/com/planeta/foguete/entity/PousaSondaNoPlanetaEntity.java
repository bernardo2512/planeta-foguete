package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.EntitySondaComPlaneta;
import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;

import java.util.Objects;

public class PousaSondaNoPlanetaEntity extends EntitySondaComPlaneta<PlanetaDomain> {

    private PousaSondaNoPlanetaEntity(SondaDomain sondaDomain,PlanetaDomain planetaDomain) throws Exception {
        super(sondaDomain,planetaDomain);
        this.valida();
    }

    public static PousaSondaNoPlanetaEntity inicia(SondaDomain sondaDomain,PlanetaDomain planetaDomain) throws Exception {
        return new PousaSondaNoPlanetaEntity(sondaDomain,planetaDomain);
    }

    @Override
    public PlanetaDomain geraSaida() {
        this.planeta.getArea()[this.sonda.getPosx()][this.sonda.getPosy()] = this.sonda.getId();
        return this.planeta;
    }

    private void valida() throws Exception {
        if(!isPousoLivre() && !isSondaDentroPlaneta()){
            throw new Exception("Impossivel Pousar");
        }
    }

    private Boolean isPousoLivre(){
        return Objects.isNull(this.planeta.getArea()[this.sonda.getPosx()][this.sonda.getPosy()]);
    }
    private Boolean isSondaDentroPlaneta(){
        return this.isSondaAlturaPlaneta() && this.isSondaLarguraPlaneta();
    }
    private Boolean isSondaAlturaPlaneta(){
        return this.sonda.getPosx() <= this.planeta.getArea()[0].length -1 && this.sonda.getPosx() >= 0;
    }
    private Boolean isSondaLarguraPlaneta(){
        return this.sonda.getPosy() <= this.planeta.getArea().length -1 && this.sonda.getPosy() >= 0;
    }
}
