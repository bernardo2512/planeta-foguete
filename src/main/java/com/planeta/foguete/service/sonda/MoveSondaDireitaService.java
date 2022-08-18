package com.planeta.foguete.service.sonda;

import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.entity.MoveSondaDireitaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MoveSondaDireitaService {

    @Autowired
    private ConsultaSondaService consultaSondaService;

    @Autowired
    private SalvaSondaDomainService salvaSondaDomainService;

    public SondaDomain execute(String id) throws Exception {
        UUID sondaId = UUID.fromString(id);
        SondaDomain sondaDomain = consultaSondaService.execute(sondaId);
        SondaDomain sondaMovida = MoveSondaDireitaEntity.inicia(sondaDomain).geraSaida();
        return this.salvaSondaDomainService.execute(sondaMovida);
    }
}
