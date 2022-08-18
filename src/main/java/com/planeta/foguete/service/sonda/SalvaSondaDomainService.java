package com.planeta.foguete.service.sonda;

import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.repository.SondaDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalvaSondaDomainService {

    @Autowired
    private SondaDomainRepository sondaDomainRepository;

    public SondaDomain execute(SondaDomain sondaDomain){
        return sondaDomainRepository.save(sondaDomain);
    }
}
