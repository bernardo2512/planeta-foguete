package com.planeta.foguete.entity.adapter;

import com.planeta.foguete.contratos.Adapter;
import com.planeta.foguete.domain.PlanetaDomain;

import java.util.Map;
import java.util.UUID;

public class MapToPlanetaDomainAdapter implements Adapter<Map<String,Object>, PlanetaDomain> {
    @Override
    public PlanetaDomain cria(Map<String,Object> entrada) {
        PlanetaDomain planetaDomain = new PlanetaDomain();
        String x = entrada.get("areax").toString();
        String y = entrada.get("areay").toString();

        planetaDomain.setArea(new UUID[Integer.parseInt(x)][Integer.parseInt(y)]);
        return planetaDomain;
    }
}
