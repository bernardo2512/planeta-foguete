package com.planeta.foguete.service.sonda;

import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.entity.PousaSondaNoPlanetaEntity;
import com.planeta.foguete.service.planeta.SalvaPlanetaDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PousaSondaNoPlanetaService {

    @Autowired
    private SalvaSondaDomainService salvaSondaDomainService;

    @Autowired
    private SalvaPlanetaDomainService salvaPlanetaDomainService;

    public SondaDomain execute(SondaDomain sondaDomainCriada, PlanetaDomain planetaDomain) throws Exception {
        SondaDomain sondaDomain = this.salvaSondaDomainService.execute(sondaDomainCriada);
        PlanetaDomain planetaDomainMovido = PousaSondaNoPlanetaEntity.inicia(sondaDomain,planetaDomain).geraSaida();
        this.salvaPlanetaDomainService.execute(planetaDomainMovido);
        return sondaDomain;
    }
}
