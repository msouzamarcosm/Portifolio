package com.stockcar.service;

import com.stockcar.domain.entity.Assento;
import com.stockcar.domain.entity.Evento;
import com.stockcar.domain.entity.Reserva;
import com.stockcar.domain.enums.StatusAssento;
import com.stockcar.repository.AssentoRepository;
import com.stockcar.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final AssentoRepository assentoRepository;

    @Transactional
    public Reserva reservarAssento(Evento evento, Assento assento) {

        if (!assento.getEvento().getId().equals(evento.getId())) {
            throw new RuntimeException("Assento não pertence a este evento");
        }

        if (assento.getStatus() != StatusAssento.DISPONIVEL) {
            throw new RuntimeException("Assento indisponível");
        }

        assento.setStatus(StatusAssento.RESERVADO);
        assentoRepository.save(assento);

        Reserva reserva = Reserva.builder()
                .evento(evento)
                .assento(assento)
                .build();

        return reservaRepository.save(reserva);
    }
}
