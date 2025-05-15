package com.lucasballonecker.transacoes_simplificado.services;

import com.lucasballonecker.transacoes_simplificado.infrastructure.clients.AutorizacaoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AutorizacaoService {

    private final AutorizacaoClient client;

    public boolean AutorizarTransferencia(){
        return Objects.equals(client.autorizacao().data().authorization(), "true");
    }
}
