package com.autorizador.api.infrastructure.adapters.mongo;

import com.autorizador.api.domain.Cartao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface CartaoRepositoryMongo extends MongoRepository<Cartao, String> {
    Optional<Cartao> findByNumeroCartao(String numeroCartao);
}