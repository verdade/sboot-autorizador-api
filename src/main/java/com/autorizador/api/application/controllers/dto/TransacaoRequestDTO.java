package com.autorizador.api.application.controllers.dto;

import lombok.Data;

@Data
public class TransacaoRequestDTO {
    private String numeroCartao;
    private String senhaCartao;
    private Double valor;
}