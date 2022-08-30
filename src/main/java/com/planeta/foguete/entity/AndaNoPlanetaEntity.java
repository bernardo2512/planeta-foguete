package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.Entity;
import com.planeta.foguete.contratos.EntitySondaComPlaneta;
import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.enums.OrientacaoEnum;

import java.util.Objects;
import java.util.UUID;

public class AndaNoPlanetaEntity extends EntitySondaComPlaneta<PlanetaDomain> {

    private AndaNoPlanetaEntity(SondaDomain sonda, PlanetaDomain planeta) {
        super(sonda,planeta);
    }

    public static AndaNoPlanetaEntity inicia(SondaDomain sonda, PlanetaDomain planeta){
        return new AndaNoPlanetaEntity(sonda,planeta);
    }
    @Override
    public PlanetaDomain geraSaida() {
        if(this.sonda.getOrientacao() == OrientacaoEnum.LESTE){
            if(Objects.isNull(this.posicaoSondaNoPlaneta())){
                this.moveSondaNoPlaneta();
                this.planeta.getArea()[this.sonda.getPosx() - 1][this.sonda.getPosy()] = null;
            }
        }
        if(this.sonda.getOrientacao() == OrientacaoEnum.OESTE){
            if(Objects.isNull(this.posicaoSondaNoPlaneta())){
                this.moveSondaNoPlaneta();
                this.planeta.getArea()[this.sonda.getPosx() + 1][this.sonda.getPosy()] = null;
            }
        }
        if(this.sonda.getOrientacao() == OrientacaoEnum.NORTE){
            if(Objects.isNull(this.posicaoSondaNoPlaneta())){
                this.moveSondaNoPlaneta();
                this.planeta.getArea()[this.sonda.getPosx()][this.sonda.getPosy()-1] = null;
            }
        }
        if(this.sonda.getOrientacao() == OrientacaoEnum.SUL){
            if(Objects.isNull(this.posicaoSondaNoPlaneta())){
                this.moveSondaNoPlaneta();
                this.planeta.getArea()[this.sonda.getPosx()][this.sonda.getPosy()+1] = null;
            }
        }
        return this.planeta;
    }

    private UUID posicaoSondaNoPlaneta(){
        return this.planeta.getArea()[this.sonda.getPosx()][this.sonda.getPosy()];
    }

    private void moveSondaNoPlaneta(){
        this.planeta.getArea()[this.sonda.getPosx()][this.sonda.getPosy()] = this.sonda.getId();
    }
}
