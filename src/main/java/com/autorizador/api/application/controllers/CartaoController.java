package com.autorizador.api.application.controllers;

import com.autorizador.api.application.services.CartaoService;
import com.autorizador.api.domain.Cartao;
import com.autorizador.api.infrastructure.mapper.CartaoMapper;
import com.autorizador.api.application.controllers.dto.CartaoRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @Operation(summary = "Criar um novo cartão")
    @PostMapping
    public ResponseEntity<?> criarCartao(@RequestBody CartaoRequestDTO cartaoDTO) {
        log.info("::.. Iniciando salvar um cartão ..::");
        Cartao novoCartao = cartaoService.criarCartao(CartaoMapper.from(cartaoDTO));
        return new ResponseEntity<>(novoCartao, HttpStatus.CREATED);
    }

    @Operation(summary = "Obter saldo do cartão")
    @GetMapping("/{numeroCartao}")
    public ResponseEntity<Double> obterSaldo(@PathVariable String numeroCartao) {
        log.info("::.. Iniciando consulta  saldo cartão ..::");
        Optional<Cartao> cartao = cartaoService.buscarPorNumero(numeroCartao);
        return cartao.map(value -> new ResponseEntity<>(value.getSaldo(), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}