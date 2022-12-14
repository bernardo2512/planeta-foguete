package com.planeta.foguete.http;

import com.planeta.foguete.domain.SondaDomain;
import com.planeta.foguete.service.sonda.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @Autowired
    private ConsultaSondaService consultaSondaService;

    @Autowired
    private PousaSondaPlanetaService pousaSondaPlanetaService;

    @Autowired
    private RetiraSondaDoPlanetaService retiraSondaDoPlanetaService;

    @PostMapping("/sonda")
    public ResponseEntity<SondaDomain> criaSonda(@RequestBody Map<String,Object> body) {
        SondaDomain response = criaSondaService.execute(body);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/sonda/{id}/direita")
    public ResponseEntity<SondaDomain> moveSondaDireita(@PathVariable String id) throws Exception {
        SondaDomain response = moveSondaDireitaService.execute(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/sonda/{id}/esquerda")
    public ResponseEntity<SondaDomain> moveSondaEsquerda(@PathVariable String id) throws Exception {
        SondaDomain response = moveSondaEsquerdaService.execute(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/sonda/{id}/andar")
    public ResponseEntity<SondaDomain> andarSonda(@PathVariable String id) throws Exception {
        SondaDomain response = andarSondaService.execute(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/sonda/{sondaId}/planeta/{planetaId}")
    public ResponseEntity<String> pousaSondaNoPlaneta(@PathVariable String sondaId,@PathVariable String planetaId) throws Exception {
        pousaSondaPlanetaService.execute(sondaId,planetaId);
        return new ResponseEntity<>("Sonda pousou no planeta: " + planetaId, HttpStatus.OK);
    }
    @PutMapping("/sonda/{sondaId}/retirar")
    public ResponseEntity<String> retiraSondaDoPlaneta(@PathVariable String sondaId) throws Exception {
        retiraSondaDoPlanetaService.execute(sondaId);
        return new ResponseEntity<>("Sonda decolou", HttpStatus.OK);
    }

    @GetMapping("/sonda")
    public ResponseEntity<List<SondaDomain>> consultaTodasSondas(){
        List<SondaDomain> response = consultaTodasSondasService.execute();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/sonda/{id}")
    public ResponseEntity<SondaDomain> consultaSondas(@PathVariable String id) throws Exception {
        SondaDomain response = consultaSondaService.execute(UUID.fromString(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
