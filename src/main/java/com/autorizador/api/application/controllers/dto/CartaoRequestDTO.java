package com.autorizador.api.application.controllers.dto;

import lombok.Data;

@Data
public class CartaoRequestDTO {
    private String numeroCartao;
    private String senha;
}