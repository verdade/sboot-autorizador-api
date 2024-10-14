# Usar uma imagem base do JDK 21
FROM eclipse-temurin:21-jdk

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo jar da aplicação para o container
COPY ../target/sboot-autorizador-api-0.0.1-SNAPSHOT.jar /app/app.jar

# Expor a porta em que a aplicação vai rodar (geralmente 8080 para Spring Boot)
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
CMD ["java", "-jar", "/app/app.jar"]
