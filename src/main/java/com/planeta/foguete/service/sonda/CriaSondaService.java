package com.planeta.foguete.service.sonda;

import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.entity.CriaSondaEntity;
import com.planeta.foguete.service.planeta.ConsultaPlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class CriaSondaService {

    @Autowired
    private ConsultaPlanetaService consultaPlanetaService;

    @Autowired
    private PousaSondaNoPlanetaService pousaSondaNoPlanetaService;
    public SondaDomain execute(Map<String,Object> body) throws Exception {
        PlanetaDomain planetaDomain = consultaPlanetaService.execute(UUID.fromString(body.get("planetaId").toString()));
        SondaDomain sondaDomainCriada = CriaSondaEntity.inicia(body,planetaDomain).geraSaida();
        return pousaSondaNoPlanetaService.execute(sondaDomainCriada,planetaDomain);
    }
}
