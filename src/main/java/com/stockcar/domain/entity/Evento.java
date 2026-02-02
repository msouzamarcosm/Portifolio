package com.stockcar.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evento {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column (nullable = false)
    private String nome;

    @Column (nullable = false)
    private String local;

    @Column (nullable = false)
    private LocalDateTime dataEvento;
}
