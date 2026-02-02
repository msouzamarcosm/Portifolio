package com.stockcar.controller;

import com.stockcar.domain.entity.Assento;
import com.stockcar.domain.entity.Evento;
import com.stockcar.service.AssentoService;
import com.stockcar.service.EventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor
public class AssentoController {

    private final AssentoService assentoService;
    private final EventoService eventoService;

    @GetMapping("/{eventoId}/assentos/disponiveis")
    public List<Assento> listarAssentosDisponiveis(@PathVariable Long eventoId) {

        Evento evento = eventoService.buscarPorId(eventoId);

        return assentoService.listarAssentosDisponiveis(evento);
    }
}
