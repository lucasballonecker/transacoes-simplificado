package com.lucasballonecker.transacoes_simplificado.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transacoes")
@Table
@Builder
public class Transacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    @JoinColumn(name = "pagador_id")
    @ManyToOne
    private Usuario pagador;

    @JoinColumn(name = "recebedor_id")
    @ManyToOne
    private Usuario recebedor;
    private LocalDateTime dataHoraTransacao;

    @PrePersist
    void prePersist() {
        dataHoraTransacao = LocalDateTime.now();
    }

}
