package com.lucasballonecker.transacoes_simplificado.infrastructure.repository;

import com.lucasballonecker.transacoes_simplificado.infrastructure.entity.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacoesRepository extends JpaRepository<Transacoes, Long> {
}
