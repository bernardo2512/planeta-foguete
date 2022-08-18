package com.planeta.foguete.service.sonda;

import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.repository.SondaDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;
import java.util.UUID;

@Service
public class ConsultaSondaService {

    @Autowired
    private SondaDomainRepository sondaDomainRepository;

    public SondaDomain execute(UUID sondaId) throws Exception {
        Optional<SondaDomain> optionalSondaDomain =  sondaDomainRepository.findById(sondaId);
        if(optionalSondaDomain.isPresent()){
            return optionalSondaDomain.get();
        }
        throw new Exception("Sonda inexistente");
    }
}
