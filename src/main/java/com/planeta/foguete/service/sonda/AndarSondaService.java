package com.planeta.foguete.service.sonda;

import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.entity.AndarSondaEntity;
import com.planeta.foguete.service.planeta.ConsultaPlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AndarSondaService {

    @Autowired
    private ConsultaSondaService consultaSondaService;
    @Autowired
    private ConsultaPlanetaService consultaPlanetaService;
    @Autowired
    private AndaDentroPlanetaService andaDentroPlanetaService;

    public SondaDomain execute(String id) throws Exception {
        UUID sondaId = UUID.fromString(id);
        SondaDomain sondaDomain = consultaSondaService.execute(sondaId);
        PlanetaDomain planetaDomain = consultaPlanetaService.execute(sondaDomain.getPlanetaId());
        return andaDentroPlanetaService.execute(sondaDomain,planetaDomain);
    }

}
