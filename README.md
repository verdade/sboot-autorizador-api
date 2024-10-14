
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

