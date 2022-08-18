package com.planeta.foguete.repository;

import com.planeta.foguete.domain.PlanetaDomain;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;
public interface PlanetaDomainRepository  extends CrudRepository<PlanetaDomain,UUID> {
}
