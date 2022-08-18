package com.planeta.foguete.entity;

import com.planeta.foguete.contratos.Adapter;
import com.planeta.foguete.contratos.Entity;
import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.entity.adapter.MapToSondaDomainAdapter;

import java.util.Map;

public class CriaSondaEntity implements Entity<SondaDomain> {
    private Map<String,Object> body;
    private PlanetaDomain planetaDomain;

    private Adapter adapter;

    private CriaSondaEntity(Map<String,Object> body, PlanetaDomain planetaDomain) throws Exception {
        this.body = body;
        this.planetaDomain = planetaDomain;
        this.adapter = new MapToSondaDomainAdapter();
        this.valida();
    }

    public static CriaSondaEntity inicia(Map<String,Object> body,PlanetaDomain planetaDomain) throws Exception {
        return new CriaSondaEntity(body,planetaDomain);
    }
    @Override
    public SondaDomain geraSaida() {
        return (SondaDomain) this.adapter.cria(this.body);
    }

    private void valida() throws Exception {
        if(!this.isSondaDentroPlaneta()){
            throw new Exception("Sonda fora do planeta");
        }
    }

    private Boolean isSondaDentroPlaneta(){
        return this.isSondaAlturaPlaneta() && this.isSondaLarguraPlaneta();
    }
    private Boolean isSondaAlturaPlaneta(){
        return Integer.parseInt(this.body.get("posy").toString()) <= this.planetaDomain.getArea()[0].length -1 && Integer.parseInt(this.body.get("posy").toString()) >= 0;
    }
    private Boolean isSondaLarguraPlaneta(){
        return Integer.parseInt(this.body.get("posx").toString()) <= this.planetaDomain.getArea().length -1 && Integer.parseInt(this.body.get("posx").toString()) >= 0;
    }
}
