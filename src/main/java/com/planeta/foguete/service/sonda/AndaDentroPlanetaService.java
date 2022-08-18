package com.planeta.foguete.service.sonda;

import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.entity.AndaNoPlanetaEntity;
import com.planeta.foguete.entity.AndarSondaEntity;
import com.planeta.foguete.service.planeta.ConsultaPlanetaService;
import com.planeta.foguete.service.planeta.SalvaPlanetaDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AndaDentroPlanetaService {

    @Autowired
    private SalvaSondaDomainService salvaSondaDomainService;

    @Autowired
    private SalvaPlanetaDomainService salvaPlanetaDomainService;

    public SondaDomain execute(SondaDomain sondaDomain,PlanetaDomain planetaDomain) throws Exception {
        SondaDomain sondaMovida = AndarSondaEntity.inicia(sondaDomain,planetaDomain).geraSaida();
        PlanetaDomain planetaDomainMovido = AndaNoPlanetaEntity.inicia(sondaDomain,planetaDomain).geraSaida();
        this.salvaPlanetaDomainService.execute(planetaDomainMovido);
        return this.salvaSondaDomainService.execute(sondaMovida);

    }
}
