package com.planeta.foguete.repository;

import com.planeta.foguete.domain.SondaDomain;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SondaDomainRepository extends CrudRepository<SondaDomain,UUID> {
}
