package com.lucasballonecker.transacoes_simplificado.services;

import com.lucasballonecker.transacoes_simplificado.infrastructure.entity.Usuario;
import com.lucasballonecker.transacoes_simplificado.infrastructure.exceptions.UserNotFound;
import com.lucasballonecker.transacoes_simplificado.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario buscarUsuario(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFound("Usuário não encontrado"));
    }
}
