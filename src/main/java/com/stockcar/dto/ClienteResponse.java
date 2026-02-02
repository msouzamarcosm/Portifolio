package com.stockcar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ClienteResponse {

    private Long id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;

}
