package com.planeta.foguete.contratos;

public interface Adapter<T,R> {
    public R cria (T entrada);

}
