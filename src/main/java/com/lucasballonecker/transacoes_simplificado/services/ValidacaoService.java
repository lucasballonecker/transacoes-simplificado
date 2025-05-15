package com.lucasballonecker.transacoes_simplificado.services;

import com.lucasballonecker.transacoes_simplificado.infrastructure.entity.TipoUsuario;
import com.lucasballonecker.transacoes_simplificado.infrastructure.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ValidacaoService {

    private final AutorizacaoService autorizacaoService;

    public void validarPagadorLojista(Usuario usuario) {
        try {
            if (usuario.getTipoUsuario().equals(TipoUsuario.LOJISTA)) {
                throw new IllegalArgumentException("Transação não autorizada para esse tipo de usuário");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void validarSaldoUsuario(Usuario usuario, BigDecimal valor) {
        try {
            if (usuario.getCarteira().getSaldo().compareTo(valor) < 0) {
                throw new IllegalArgumentException("Transação não autorizada : Saldo insuficiente");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void validarAutorizacaoTransferencia() {
        try {
            if (!autorizacaoService.AutorizarTransferencia()) {
                throw new IllegalArgumentException("Transação não autorizada : Api externa não validou");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
