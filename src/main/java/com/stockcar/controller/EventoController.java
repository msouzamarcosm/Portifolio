package com.stockcar.controller;

import com.stockcar.domain.entity.Assento;
import com.stockcar.domain.entity.Evento;
import com.stockcar.domain.entity.Reserva;
import com.stockcar.service.AssentoService;
import com.stockcar.service.EventoService;
import com.stockcar.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@RestController
@RequestMapping("/eventos")
@RequiredArgsConstructor
public class EventoController {

    private final AssentoService assentoService;
    private final EventoService eventoService;
    private final ReservaService reservaService;

    @GetMapping("/{eventoId}/assentos/disponiveis")
    public List<Assento> listarAssentosDisponiveis(
            @PathVariable Long eventoId) {

        Evento evento = eventoService.buscarPorId(eventoId);
        return assentoService.listarAssentosDisponiveis(evento);
    }

    @PostMapping("/{eventoId}/assentos/{assentoId}/reservar")
    public Reserva reservarAssento(
            @PathVariable Long eventoId,
            @PathVariable Long assentoId
    ) {
        Evento evento = eventoService.buscarPorId(eventoId);
        Assento assento = assentoService.buscarPorId(assentoId);

        return reservaService.reservarAssento(evento, assento);
    }
}

