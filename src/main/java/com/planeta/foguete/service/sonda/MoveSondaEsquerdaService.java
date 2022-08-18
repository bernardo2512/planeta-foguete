package com.planeta.foguete.service.sonda;

import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.entity.MoveSondaEsquerdaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MoveSondaEsquerdaService {
    @Autowired
    private ConsultaSondaService consultaSondaService;

    @Autowired
    private SalvaSondaDomainService salvaSondaDomainService;

    public SondaDomain execute(String id) throws Exception {
        UUID sondaId = UUID.fromString(id);
        SondaDomain sondaDomain = consultaSondaService.execute(sondaId);
        SondaDomain sondaMovida = MoveSondaEsquerdaEntity.inicia(sondaDomain).geraSaida();
        return this.salvaSondaDomainService.execute(sondaMovida);
    }
}
