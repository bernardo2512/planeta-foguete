package com.planeta.foguete.service.planeta;

import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.repository.PlanetaDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsultaPlanetaService {
    @Autowired
    private PlanetaDomainRepository planetaDomainRepository;

    public PlanetaDomain execute(UUID id) throws Exception {
        Optional<PlanetaDomain> planetaDomainOptional= planetaDomainRepository.findById(id);
        if(planetaDomainOptional.isPresent()){
            return planetaDomainOptional.get();
        }
        throw new Exception("Planeta Inexistente");
    }
}
