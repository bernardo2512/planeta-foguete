package com.planeta.foguete.service.planeta;

import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.entity.CriaPlanetaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CriaPlanetaService {
    @Autowired
    private SalvaPlanetaDomainService salvaPlanetaDomainService;
    public PlanetaDomain execute(Map<String,Object> body){
        CriaPlanetaEntity criaPlanetaEntity = CriaPlanetaEntity.inicia(body);
        PlanetaDomain planetaDomain = salvaPlanetaDomainService.execute(criaPlanetaEntity.geraSaida());
        return planetaDomain;
    }
}
