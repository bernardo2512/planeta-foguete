package com.planeta.foguete.http;

import com.planeta.foguete.domain.PlanetaDomain;
import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.service.sonda.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class SondaController {
    @Autowired
    private CriaSondaService criaSondaService;

    @Autowired
    private ConsultaTodasSondasService consultaTodasSondasService;

    @Autowired
    private MoveSondaDireitaService moveSondaDireitaService;

    @Autowired
    private MoveSondaEsquerdaService moveSondaEsquerdaService;

    @Autowired
    private AndarSondaService andarSondaService;

    @PostMapping("/sonda")
    public ResponseEntity criaSonda(@RequestBody Map<String,Object> body){
        SondaDomain response = criaSondaService.execute(body);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("/sonda/{id}/direita")
    public ResponseEntity moveSondaDireita(@PathVariable String id) throws Exception {
        SondaDomain response = moveSondaDireitaService.execute(id);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PutMapping("/sonda/{id}/esquerda")
    public ResponseEntity moveSondaEsquerda(@PathVariable String id) throws Exception {
        SondaDomain response = moveSondaEsquerdaService.execute(id);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PutMapping("/sonda/{id}/andar")
    public ResponseEntity andarSonda(@PathVariable String id) throws Exception {
        SondaDomain response = andarSondaService.execute(id);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/sonda")
    public ResponseEntity consultaTodasSondas(){
        List<SondaDomain> response = consultaTodasSondasService.execute();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
