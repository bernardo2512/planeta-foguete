package com.planeta.foguete.contratos;

import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;

public abstract class EntitySondaComPlaneta<T> implements Entity<T>{
    protected SondaDomain sonda;
    protected PlanetaDomain planeta;

    protected EntitySondaComPlaneta(SondaDomain sonda, PlanetaDomain planeta){
        this.sonda = sonda;
        this.planeta = planeta;
    }

}
