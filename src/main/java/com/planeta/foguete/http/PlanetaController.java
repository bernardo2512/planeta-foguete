package com.planeta.foguete.http;

import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.service.planeta.ConsultaPlanetaService;
import com.planeta.foguete.service.planeta.ConsultaTodosPlanetasService;
import com.planeta.foguete.service.planeta.CriaPlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController()
public class PlanetaController {

    @Autowired
    private CriaPlanetaService criaPlanetaService;

    @Autowired
    private ConsultaTodosPlanetasService consultaTodosPlanetasService;

    @Autowired
    private ConsultaPlanetaService consultaPlanetaService;

    @PostMapping("/planeta")
    public ResponseEntity<PlanetaDomain>  criaPlaneta(@RequestBody Map<String,Object> body){
        PlanetaDomain response = criaPlanetaService.execute(body);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @GetMapping("/planeta")
    public ResponseEntity<List<PlanetaDomain>>  consultaTodosPlanetas(){
        List<PlanetaDomain> response = consultaTodosPlanetasService.execute();
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @GetMapping("/planeta/{id}")
    public ResponseEntity<PlanetaDomain> consultaPlanetas(@PathVariable String id) throws Exception {
        PlanetaDomain response = consultaPlanetaService.execute(UUID.fromString(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
