package com.planeta.foguete.service.sonda;

import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.entity.PousaSondaNoPlanetaEntity;
import com.planeta.foguete.entity.VinculaPlanetaNaSondaEntity;
import com.planeta.foguete.service.planeta.ConsultaPlanetaService;
import com.planeta.foguete.service.planeta.SalvaPlanetaDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PousaSondaPlanetaService {

    @Autowired
    private ConsultaSondaService consultaSondaService;

    @Autowired
    private ConsultaPlanetaService consultaPlanetaService;

    @Autowired
    private SalvaPlanetaDomainService salvaPlanetaDomainService;

    @Autowired
    private SalvaSondaDomainService salvaSondaDomainService;



    public void execute(String sondaId,String planetaId) throws Exception {
        SondaDomain sondaDomain = this.consultaSondaService.execute(UUID.fromString(sondaId));
        PlanetaDomain planetaDomain = this.consultaPlanetaService.execute(UUID.fromString(planetaId));
        PlanetaDomain planetaDomainMovido = PousaSondaNoPlanetaEntity.inicia(sondaDomain,planetaDomain).geraSaida();
        SondaDomain sondaDomainPlanetaVinculado = VinculaPlanetaNaSondaEntity.inicia(sondaDomain,planetaDomainMovido).geraSaida();
        this.salvaPlanetaDomainService.execute(planetaDomainMovido);
        this.salvaSondaDomainService.execute(sondaDomainPlanetaVinculado);

    }
}
