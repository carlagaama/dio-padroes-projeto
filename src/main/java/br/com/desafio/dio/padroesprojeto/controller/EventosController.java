package br.com.desafio.dio.padroesprojeto.controller;

import br.com.desafio.dio.padroesprojeto.model.domain.Evento;
import br.com.desafio.dio.padroesprojeto.model.dto.request.EventoRequest;
import br.com.desafio.dio.padroesprojeto.model.mappers.EventoMapper;
import br.com.desafio.dio.padroesprojeto.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventos-dio")
public class EventosController {

    @Autowired
    private EventoService service;

    @PostMapping
    public ResponseEntity<Evento> cadastrarEvento(@RequestBody EventoRequest request) {

        Evento eventoCadastrado = service.cadastrarEvento(EventoMapper.INSTANCE.mapFrom(request));
        return ResponseEntity.ok(eventoCadastrado);
    }
}
