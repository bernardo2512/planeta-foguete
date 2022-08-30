package com.planeta.foguete.contratos;

import java.util.Map;

public abstract class EntityDeCriacao<T> implements Entity<T>{

    protected Map<String,Object> body;

    protected Adapter adapter;

    protected EntityDeCriacao(Map<String,Object> body,Adapter adapter){
        this.body = body;
        this.adapter = adapter;
    }

    @Override
    public T geraSaida() {
        return (T) this.adapter.cria(this.body);
    }
}
