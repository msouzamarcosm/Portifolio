package com.stockcar.repository;


import com.stockcar.domain.entity.Assento;
import com.stockcar.domain.entity.Evento;
import com.stockcar.domain.enums.StatusAssento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssentoRepository extends JpaRepository <Assento, Long> {

    List<Assento> findByEvento(Evento evento);

    List<Assento> findByEventoAndStatus(Evento evento, StatusAssento status);
}
