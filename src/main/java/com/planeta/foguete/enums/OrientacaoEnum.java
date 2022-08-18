package com.planeta.foguete.enums;

import java.util.Objects;

public enum OrientacaoEnum {
    NORTE(0),
    LESTE(1),
    SUL(2),
    OESTE(3);

    private Integer valor;

    OrientacaoEnum(Integer valor){
        this.valor = valor;
    }

    public Integer getValor(){
        return this.valor;
    }

    public static OrientacaoEnum fromString(String orientacaoString){
        for (OrientacaoEnum orientacao : OrientacaoEnum.values()) {
            if(orientacao.toString().equalsIgnoreCase(orientacaoString)){
                return orientacao;
            }
        }
        return OrientacaoEnum.LESTE;
    }
    public static OrientacaoEnum fromValor(Integer valor){
        for (OrientacaoEnum orientacao : OrientacaoEnum.values()) {
            if(Objects.equals(orientacao.getValor(),valor)){
                return orientacao;
            }
        }
        return OrientacaoEnum.LESTE;
    }
    public static OrientacaoEnum proximo(OrientacaoEnum orientacao){
       if(Objects.equals(orientacao.getValor(),3)){
           return OrientacaoEnum.NORTE;
       }
       return OrientacaoEnum.fromValor(orientacao.getValor()+1);
    }
    public static OrientacaoEnum anterior(OrientacaoEnum orientacao){
        if(Objects.equals(orientacao.getValor(),0)){
            return OrientacaoEnum.OESTE;
        }
        return OrientacaoEnum.fromValor(orientacao.getValor()-1);
    }
}
