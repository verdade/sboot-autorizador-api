package com.autorizador.api.application.services;

import com.autorizador.api.application.exception.AuthenticationLogicException;
import com.autorizador.api.application.exception.BusinessLogicException;
import com.autorizador.api.application.exception.CartaoNotFoundException;
import com.autorizador.api.domain.Cartao;
import com.autorizador.api.infrastructure.adapters.mongo.CartaoRepositoryMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepositoryMongo cartaoRepository;

    public Optional<Cartao> buscarPorNumero(String numeroCartao) {
        return cartaoRepository.findByNumeroCartao(numeroCartao);
    }

    public Cartao criarCartao(Cartao cartao) {
        return (Cartao) cartaoRepository.findByNumeroCartao(cartao.getNumeroCartao())
                .map(c -> {
                    throw new BusinessLogicException("Cartão já existe");
                })
                .orElseGet(() -> cartaoRepository.save(cartao));
    }

    public void realizarTransacao(String numeroCartao, String senha, Double valor) {
        cartaoRepository.findByNumeroCartao(numeroCartao)
                .filter(c -> c.getSenha().equals(senha)) // Verifica a senha
                .orElseThrow(() -> new AuthenticationLogicException("SENHA_INVALIDA")); // Lança exceção se a senha for inválida

        cartaoRepository.findByNumeroCartao(numeroCartao)
                .filter(c -> c.getSaldo() >= valor) // Verifica se o saldo é suficiente
                .map(c -> {
                    c.setSaldo(c.getSaldo() - valor); // Atualiza o saldo
                    return cartaoRepository.save(c); // Salva o cartão atualizado
                })
                .orElseThrow(() -> new BusinessLogicException("SALDO_INSUFICIENTE")); // Lança exceção se o saldo for insuficiente
    }

}