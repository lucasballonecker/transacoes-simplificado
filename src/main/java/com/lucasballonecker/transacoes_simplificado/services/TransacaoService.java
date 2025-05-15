package com.lucasballonecker.transacoes_simplificado.services;

import com.lucasballonecker.transacoes_simplificado.controller.TransacaoDTO;
import com.lucasballonecker.transacoes_simplificado.infrastructure.entity.Carteira;
import com.lucasballonecker.transacoes_simplificado.infrastructure.entity.Transacoes;
import com.lucasballonecker.transacoes_simplificado.infrastructure.entity.Usuario;
import com.lucasballonecker.transacoes_simplificado.infrastructure.exceptions.BadRequestException;
import com.lucasballonecker.transacoes_simplificado.infrastructure.repository.TransacoesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final UsuarioService usuarioService;
    private final CarteiraService carteiraService;
    private final ValidacaoService validacaoService;
    private final NotificacaoService notificacaoService;
    private final TransacoesRepository repository;

    @Transactional
    public void transferirValores(TransacaoDTO transacaoDTO) {
        Usuario pagador = usuarioService.buscarUsuario(transacaoDTO.payer());
        Usuario recebedor = usuarioService.buscarUsuario(transacaoDTO.payee());

        validacaoService.validarPagadorLojista(pagador);
        validacaoService.validarSaldoUsuario(pagador, transacaoDTO.value());
        validacaoService.validarAutorizacaoTransferencia();

        carteiraService.subtrairSaldo(pagador, transacaoDTO);
        carteiraService.adicionarSaldo(recebedor, transacaoDTO);

        atualizarSaldoCarteira(pagador.getCarteira());
        atualizarSaldoCarteira(recebedor.getCarteira());

       salvarTransacoes(pagador,recebedor,transacaoDTO);
       enviarNotificacao();
    }

    private void atualizarSaldoCarteira(Carteira carteira){
        carteiraService.salvar(carteira);
    }

    private void enviarNotificacao() {
        try{
            notificacaoService.enviarNotificacao();
        }catch (HttpClientErrorException e){
            throw new BadRequestException("Erro ao enviar notificacao");
        }
    }

    public void salvarTransacoes(Usuario pagador, Usuario recebedor, TransacaoDTO transacaoDTO) {
        Transacoes transacoes =  Transacoes.builder()
                .valor(transacaoDTO.value())
                .pagador(pagador)
                .recebedor(recebedor)
                .build();

        repository.save(transacoes);
    }

}
