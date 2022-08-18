package com.planeta.foguete.http;

import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.service.planeta.ConsultaTodosPlanetasService;
import com.planeta.foguete.service.planeta.CriaPlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController()
public class PlanetaController {

    @Autowired
    private CriaPlanetaService criaPlanetaService;

    @Autowired
    private ConsultaTodosPlanetasService consultaTodosPlanetasService;

    @PostMapping("/planeta")
    public ResponseEntity criaPlaneta(@RequestBody Map<String,Object> body){
        PlanetaDomain response = criaPlanetaService.execute(body);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @GetMapping("/planeta")
    public ResponseEntity consultaTodosPlanetas(){
        List<PlanetaDomain> response = consultaTodosPlanetasService.execute();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
