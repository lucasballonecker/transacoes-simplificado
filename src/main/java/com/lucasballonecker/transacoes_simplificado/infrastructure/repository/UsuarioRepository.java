package com.lucasballonecker.transacoes_simplificado.infrastructure.repository;

import com.lucasballonecker.transacoes_simplificado.infrastructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
