package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.EntityDeCriacao;
import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.entity.adapter.MapToPlanetaDomainAdapter;

import java.util.Map;

public class CriaPlanetaEntity extends EntityDeCriacao<PlanetaDomain> {

    private CriaPlanetaEntity(Map<String,Object> entrada){
        super(entrada,new MapToPlanetaDomainAdapter());
    }

    public static CriaPlanetaEntity inicia(Map<String,Object> entrada){
        return new CriaPlanetaEntity(entrada);
    }

}
