package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.Entity;
import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.enums.OrientacaoEnum;

import java.util.Objects;

public class AndarSondaEntity implements Entity<SondaDomain> {

    private SondaDomain entrada;

    private AndarSondaEntity(SondaDomain entrada){
        this.entrada = entrada;
    }

    public static AndarSondaEntity inicia(SondaDomain entrada){
        return new AndarSondaEntity(entrada);
    }
    @Override
    public SondaDomain geraSaida() {
        if(this.entrada.getOrientacao() == OrientacaoEnum.LESTE){
            Integer posx =this.entrada.getPosx();
            this.entrada.setPosx(posx+1);
        }
        if(this.entrada.getOrientacao() == OrientacaoEnum.OESTE){
            Integer posx =this.entrada.getPosx();
            this.entrada.setPosx(posx-1);
        }
        if(this.entrada.getOrientacao() == OrientacaoEnum.NORTE){
            Integer posy =this.entrada.getPosy();
            this.entrada.setPosy(posy+1);
        }
        if(this.entrada.getOrientacao() == OrientacaoEnum.SUL){
            Integer posy = this.entrada.getPosy();
            this.entrada.setPosy(posy-1);
        }
        return this.entrada;
    }
}
