package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.Adapter;
import com.planeta.foguete.contratos.Entity;
import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.entity.adapter.MapToSondaDomainAdapter;

import java.util.Map;

public class CriaSondaEntity implements Entity<SondaDomain> {
    private Map<String,Object> entrada;

    private Adapter adapter;

    private CriaSondaEntity(Map<String,Object> entrada){
        this.entrada = entrada;
        this.adapter = new MapToSondaDomainAdapter();
    }

    public static CriaSondaEntity inicia(Map<String,Object> entrada){
        return new CriaSondaEntity(entrada);
    }
    @Override
    public SondaDomain geraSaida() {
        return (SondaDomain) this.adapter.cria(this.entrada);
    }
}
