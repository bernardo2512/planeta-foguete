package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.Adapter;
import com.planeta.foguete.contratos.Entity;
import com.planeta.foguete.domain.SondaDomain;

public class MoveSondaDireitaEntity implements Entity<SondaDomain> {

    private SondaDomain entrada;

    private MoveSondaDireitaEntity(SondaDomain entrada){
        this.entrada = entrada;
    }
    public static MoveSondaDireitaEntity inicia(SondaDomain entrada){
        return new MoveSondaDireitaEntity(entrada);
    }
    @Override
    public SondaDomain geraSaida() {
        this.entrada.moveDireita();
        return this.entrada;
    }
}
