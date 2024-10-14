
# Mini Autorizador - README.md

## Introdução

Bem-vindo ao repositório Mini Autorizador, o Mini Autorizador processa todos os dias diversas transações de Vale Refeição e Vale Alimentação, entre outras.
De forma breve, as transações saem das maquininhas de cartão e chegam até uma de nossas aplicações, conhecida como *autorizador*, que realiza uma série de verificações e análises. Essas também são conhecidas como *regras de autorização*.

Ao final do processo, o autorizador toma uma decisão, aprovando ou não a transação:
* se aprovada, o valor da transação é debitado do saldo disponível do benefício, e informamos à maquininha que tudo ocorreu bem.
* senão, apenas informamos o que impede a transação de ser feita e o processo se encerra.


## Configuração

### Construindo a Imagem Docker

Para construir a imagem Docker do projeto, execute o seguinte comando:

```bash
make docker-build-image
```

Este comando irá construir uma imagem Docker com todas as dependências necessárias para executar a aplicação.

### Subindo o Projeto

Para subir o projeto, você tem duas opções:

1**Rodando Diretamente o Container:**

   ```bash
   make docker-run
   ```

### Modo Desenvolvimento

Para trabalhar no modo de desenvolvimento:

1. **Construa a imagem e suba o projeto:**

   Siga os comandos abaixo para construir a imagem e subir o projeto:

   ```bash
   make docker-build-image
   make docker-up
   ```

2. **Acessando o Bash do Container:**

   Após subir o projeto, você pode acessar o bash do container para executar a aplicação ou realizar outras atividades de desenvolvimento:

   ```bash
   make open-bash
   ```

   Dentro do bash, você terá um ambiente configurado onde pode executar a aplicação como desejar.

## Executando Testes

Para executar os testes da aplicação, utilize o comando:

```bash
make test
```

Para gerar a cobertura de código e um relatório em `coverage.html`, execute:

```bash
make test-coverage
```

Após a execução, o arquivo `coverage.html` será gerado na raiz do projeto, permitindo que você visualize detalhadamente a cobertura de testes.

## Teste no CLOUD RUN

Para utilizar, passe o CEP desejado via query params, por exemplo: `https://teste-stld6yh5tq-uc.a.run.app/temperature?cep=24230126.
