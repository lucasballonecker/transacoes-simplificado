package com.lucasballonecker.transacoes_simplificado.services;

import com.lucasballonecker.transacoes_simplificado.infrastructure.clients.AutorizacaoClient;
import com.lucasballonecker.transacoes_simplificado.infrastructure.clients.NotificacaoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final NotificacaoClient client;

    public void enviarNotificacao(){
        client.enviarNotificacao();
    }
}
