package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.Adapter;
import com.planeta.foguete.contratos.Entity;
import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.entity.adapter.MapToSondaDomainAdapter;

import java.util.Map;

public class CriaSondaEntity implements Entity<SondaDomain> {
    private Map<String,Object> body;

    private Adapter adapter;

    private CriaSondaEntity(Map<String,Object> body) {
        this.body = body;
        this.adapter = new MapToSondaDomainAdapter();
    }

    public static CriaSondaEntity inicia(Map<String,Object> body){
        return new CriaSondaEntity(body);
    }
    @Override
    public SondaDomain geraSaida() {
        return (SondaDomain) this.adapter.cria(this.body);
    }



}
