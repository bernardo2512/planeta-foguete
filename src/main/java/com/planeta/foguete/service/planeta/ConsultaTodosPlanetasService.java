package com.planeta.foguete.service.planeta;

import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.repository.PlanetaDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaTodosPlanetasService {

    @Autowired
    private PlanetaDomainRepository planetaDomainRepository;

    public List<PlanetaDomain> execute(){
        return (List<PlanetaDomain>) planetaDomainRepository.findAll();
    }
}
