package com.planeta.foguete.service.sonda;

import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.entity.AndarSondaEntity;
import com.planeta.foguete.service.planeta.ConsultaPlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AndaDentroPlanetaService {
    @Autowired
    private ConsultaPlanetaService consultaPlanetaService;

    public SondaDomain execute(SondaDomain sondaDomain) throws Exception {
        PlanetaDomain planetaDomain = consultaPlanetaService.execute(sondaDomain.getPlanetaId());
        return AndarSondaEntity.inicia(sondaDomain,planetaDomain).geraSaida();
    }
}
