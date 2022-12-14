package com.planeta.foguete.service.sonda;

import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.entity.CriaSondaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CriaSondaService {
    @Autowired
    private SalvaSondaDomainService salvaSondaDomainService;

    public SondaDomain execute(Map<String,Object> body){
        return this.salvaSondaDomainService.execute(CriaSondaEntity.inicia(body).geraSaida());
    }
}
