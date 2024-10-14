package com.autorizador.api.infrastructure.mapper;

import com.autorizador.api.domain.Cartao;
import com.autorizador.api.application.controllers.dto.CartaoRequestDTO;

public final class CartaoMapper {

    private CartaoMapper() {}

    public static Cartao from(CartaoRequestDTO dto) {
        return Cartao.builder()
                .numeroCartao(dto.getNumeroCartao())
                .senha(dto.getSenha())
                .saldo(500d)
                .build();
    }
}
