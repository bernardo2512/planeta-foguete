package com.planeta.foguete.service.sonda;

import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.entity.RetiraPlanetaDaSondaEntity;
import com.planeta.foguete.entity.RetiraSondaDoPlanetaEntity;
import com.planeta.foguete.service.planeta.ConsultaPlanetaService;
import com.planeta.foguete.service.planeta.SalvaPlanetaDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RetiraSondaDoPlanetaService {

    @Autowired
    private ConsultaSondaService consultaSondaService;

    @Autowired
    private ConsultaPlanetaService consultaPlanetaService;

    @Autowired
    private SalvaSondaDomainService salvaSondaDomainService;

    @Autowired
    private SalvaPlanetaDomainService salvaPlanetaDomainService;

    public void execute(String id) throws Exception {
        SondaDomain sondaDomain = consultaSondaService.execute(UUID.fromString(id));
        PlanetaDomain planetaDomain = this.consultaPlanetaService.execute(sondaDomain.getPlanetaId());
        this.salvaPlanetaDomainService.execute(RetiraSondaDoPlanetaEntity.inicia(sondaDomain,planetaDomain).geraSaida());
        this.salvaSondaDomainService.execute(RetiraPlanetaDaSondaEntity.inicia(sondaDomain).geraSaida());
    }
}
