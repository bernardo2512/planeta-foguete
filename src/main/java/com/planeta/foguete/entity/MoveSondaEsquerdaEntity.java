package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.Entity;
import com.planeta.foguete.domain.SondaDomain;

public class MoveSondaEsquerdaEntity implements Entity<SondaDomain> {

    private SondaDomain entrada;

    private MoveSondaEsquerdaEntity(SondaDomain entrada){
        this.entrada = entrada;
    }
    public static MoveSondaEsquerdaEntity inicia(SondaDomain entrada){
        return new MoveSondaEsquerdaEntity(entrada);
    }
    @Override
    public SondaDomain geraSaida() {
        this.entrada.moveEsquerda();
        return this.entrada;
    }
}
