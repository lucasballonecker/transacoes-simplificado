package com.lucasballonecker.transacoes_simplificado.infrastructure.repository;

import com.lucasballonecker.transacoes_simplificado.infrastructure.entity.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}
