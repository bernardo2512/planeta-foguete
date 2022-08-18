package com.planeta.foguete.entity.adapter;

import com.planeta.foguete.contratos.Adapter;
import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.enums.OrientacaoEnum;

import java.util.Map;
import java.util.UUID;

public class MapToSondaDomainAdapter implements Adapter<Map<String,Object>, SondaDomain> {
    @Override
    public SondaDomain cria(Map<String, Object> entrada) {
        SondaDomain sondaDomain = new SondaDomain();
        sondaDomain.setOrientacao(OrientacaoEnum.fromString(entrada.get("orientacao").toString()));
        sondaDomain.setPosx(Integer.valueOf(entrada.get("posx").toString()));
        sondaDomain.setPosy(Integer.valueOf(entrada.get("posy").toString()));
        return sondaDomain;
    }
}
