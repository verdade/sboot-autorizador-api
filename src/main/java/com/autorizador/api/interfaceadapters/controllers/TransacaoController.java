package com.autorizador.api.interfaceadapters.controllers;

import com.autorizador.api.application.services.CartaoService;
import com.autorizador.api.interfaceadapters.dto.TransacaoRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private CartaoService cartaoService;

    @Operation(summary = "Realizar uma transação")
    @PostMapping
    public ResponseEntity<?> realizarTransacao(@RequestBody TransacaoRequestDTO transacaoDTO) {
        log.info("::.. Iniciando Transação de Cartão ..::");
        cartaoService.realizarTransacao(transacaoDTO.getNumeroCartao(), transacaoDTO.getSenhaCartao(), transacaoDTO.getValor());
        return new ResponseEntity<>("OK", HttpStatus.CREATED);

    }
}