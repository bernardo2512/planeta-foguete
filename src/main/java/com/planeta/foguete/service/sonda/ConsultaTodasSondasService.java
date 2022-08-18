package com.planeta.foguete.service.sonda;

import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.repository.SondaDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaTodasSondasService {

    @Autowired
    private SondaDomainRepository sondaDomainRepository;

    public List<SondaDomain> execute(){
        return (List<SondaDomain>) this.sondaDomainRepository.findAll();
    }
}
