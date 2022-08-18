package com.planeta.foguete.service.planeta;

import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.repository.PlanetaDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalvaPlanetaDomainService {

    @Autowired
    private PlanetaDomainRepository planetaDomainRepository;

    public PlanetaDomain execute(PlanetaDomain planeta){
        return this.planetaDomainRepository.save(planeta);
    }

}
