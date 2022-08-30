package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.EntityDeCriacao;
import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.entity.adapter.MapToSondaDomainAdapter;

import java.util.Map;

public class CriaSondaEntity extends EntityDeCriacao<SondaDomain> {

    private CriaSondaEntity(Map<String,Object> body) {
        super(body,new MapToSondaDomainAdapter());
    }

    public static CriaSondaEntity inicia(Map<String,Object> body){
        return new CriaSondaEntity(body);
    }
}
