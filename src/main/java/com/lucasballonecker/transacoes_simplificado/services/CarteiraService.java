package com.lucasballonecker.transacoes_simplificado.services;

import com.lucasballonecker.transacoes_simplificado.controller.TransacaoDTO;
import com.lucasballonecker.transacoes_simplificado.infrastructure.entity.Carteira;
import com.lucasballonecker.transacoes_simplificado.infrastructure.entity.Usuario;
import com.lucasballonecker.transacoes_simplificado.infrastructure.repository.CarteiraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarteiraService {

    private final CarteiraRepository repository;

    public void adicionarSaldo(Usuario usuario, TransacaoDTO transacao){
        usuario.getCarteira()
                .setSaldo(usuario.getCarteira().getSaldo().add(transacao.value()));
    }

    public void subtrairSaldo(Usuario usuario, TransacaoDTO transacao){
        usuario.getCarteira()
                .setSaldo(usuario.getCarteira().getSaldo().subtract(transacao.value()));
    }

    public void salvar(Carteira carteira){
        repository.save(carteira);
    }
}
