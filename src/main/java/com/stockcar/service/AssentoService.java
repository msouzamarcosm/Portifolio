package com.stockcar.service;

import com.stockcar.domain.entity.Assento;
import com.stockcar.domain.entity.Evento;
import com.stockcar.domain.enums.StatusAssento;
import com.stockcar.repository.AssentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssentoService {

    private final AssentoRepository assentoRepository;

    public List<Assento> listarAssentosDisponiveis(Evento evento) {
        return assentoRepository.findByEventoAndStatus(evento, StatusAssento.DISPONIVEL);
    }

    public Assento buscarPorId(Long id) {
        return assentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assento não encontrado"));
    }
}
