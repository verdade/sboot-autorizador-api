package com.autorizador.api.infrastructure.config;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableMongoRepositories(basePackages = "com.autorizador.api.infrastructure.adapters.mongo")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "miniautorizador";  // Nome do banco de dados MongoDB
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }

    @Override
    public com.mongodb.client.MongoClient mongoClient() {
        return MongoClients.create("mongodb://user:password@localhost:27017");  // Configuração da URI de conexão com o MongoDB
    }



    @Override
    public MongoCustomConversions customConversions() {
        List<Object> converters = new ArrayList<>();
        // Adicione conversores personalizados, se necessário
        return new MongoCustomConversions(converters);
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;  // Habilitar ou desabilitar a criação automática de índices
    }
}
