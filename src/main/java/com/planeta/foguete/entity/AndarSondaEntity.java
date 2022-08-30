package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.Entity;
import com.planeta.foguete.contratos.EntitySondaComPlaneta;
import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.enums.OrientacaoEnum;

public class AndarSondaEntity extends EntitySondaComPlaneta<SondaDomain> {

    private AndarSondaEntity(SondaDomain sonda, PlanetaDomain planeta){
        super(sonda,planeta);
    }

    public static AndarSondaEntity inicia(SondaDomain sonda, PlanetaDomain planeta){
        return new AndarSondaEntity(sonda,planeta);
    }
    @Override
    public SondaDomain geraSaida() {
        if(this.sonda.getOrientacao() == OrientacaoEnum.LESTE){
            Integer posx =this.sonda.getPosx();
            if(posx < this.planeta.getArea().length-1){
                this.sonda.setPosx(posx+1);
            }
        }
        if(this.sonda.getOrientacao() == OrientacaoEnum.OESTE){
            Integer posx =this.sonda.getPosx();
            if(posx > 0) {
                this.sonda.setPosx(posx - 1);
            }
        }
        if(this.sonda.getOrientacao() == OrientacaoEnum.NORTE){
            Integer posy =this.sonda.getPosy();
            if(posy < this.planeta.getArea()[0].length-1) {
                this.sonda.setPosy(posy + 1);
            }
        }
        if(this.sonda.getOrientacao() == OrientacaoEnum.SUL){
            Integer posy = this.sonda.getPosy();
            if(posy > 0) {
                this.sonda.setPosy(posy - 1);
            }
        }
        return this.sonda;
    }
}
