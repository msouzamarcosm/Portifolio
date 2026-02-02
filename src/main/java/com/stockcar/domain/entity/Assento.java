package com.stockcar.domain.entity;

import com.stockcar.domain.enums.StatusAssento;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assento {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column (nullable = false)
    private String codigo;

    @Column (nullable = false)
    private String setor;

    @Column (nullable = false)
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAssento status;

    @ManyToOne
    @JoinColumn(name ="evento_id", nullable =false)
    private Evento evento;

}
