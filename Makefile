# Variáveis
JAR_FILE=$(shell ls target/*.jar | head -n 1)
MONGO_CONTAINER_NAME=mongo-test
MONGO_PORT=27017

# Executa a aplicação localmente
run:
	./mvnw spring-boot:run

# Compila a aplicação e cria o JAR
build:
	./mvnw clean package

# Executa os testes
test:
	./mvnw test

# Executa os testes com relatório de cobertura
test-coverage:
	./mvnw test jacoco:reportricanalista/

# Construção da imagem Docker
docker-build-image: build
	docker build -t ricanalista/sboot-autorizador-api:latest -f Dockerfile .

# Executa a aplicação dentro de um container Docker
docker-run:
	docker run --rm -p 8080:8080 ricanalista/sboot-autorizador-api:latest

# Sobe um container MongoDB para testes
start-mongo-mock:
	docker-compose up -d mongo

# Para e remove o container MongoDB
stop-mongo-mock:
	docker stop $(MONGO_CONTAINER_NAME)
	docker rm $(MONGO_CONTAINER_NAME)

# Executa a aplicação no Docker com o MongoDB mock
docker-run-with-mongo: start-mongo-mock docker-build-image
	docker run --rm --name autorizador-app --link $(MONGO_CONTAINER_NAME):mongo -p 8080:8080 ricanalista/sboot-autorizador-api:latest

# Limpa containers e imagens Docker
clean-docker:
	docker rm -f $(MONGO_CONTAINER_NAME) || true
	docker rmi $(DOCKER_IMAGE) || true
