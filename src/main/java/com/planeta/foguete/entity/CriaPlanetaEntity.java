package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.Adapter;
import com.planeta.foguete.contratos.Entity;
import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.entity.adapter.MapToPlanetaDomainAdapter;

import java.util.Map;

public class CriaPlanetaEntity implements Entity<PlanetaDomain> {

    private Map<String,Object> entrada;

    private Adapter adapter;

    private CriaPlanetaEntity(Map<String,Object> entrada){
        this.entrada = entrada;
        this.adapter = new MapToPlanetaDomainAdapter();
    }

    public static CriaPlanetaEntity inicia(Map<String,Object> entrada){
        return new CriaPlanetaEntity(entrada);
    }

    @Override
    public PlanetaDomain geraSaida() {
        return (PlanetaDomain) this.adapter.cria(this.entrada);
    }
}
