# AluraFood Payment Microservice

## Descrição
Este microserviço faz parte do projeto AluraFood, simulando o sistema de pagamentos de um serviço de delivery de comida. O microserviço é responsável por processar pagamentos, realizar validações de transações e integrar com gateways de pagamento.

Este projeto foi desenvolvido como parte do aprendizado sobre microserviços em Java 21, utilizando práticas recomendadas de arquitetura, como APIs RESTful, segurança e escalabilidade.

# Tecnologias Utilizadas
Java 21: versão mais recente do Java com recursos novos e aprimoramentos.
Spring Boot: framework para criação de microserviços com APIs RESTful.
Spring Security: para segurança da aplicação, incluindo autenticação e autorização.
Spring Data JPA: para persistência de dados em banco de dados relacional.
Docker: para containerização do microserviço.

# Estrutura do Projeto
O projeto possui a seguinte estrutura:

```
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/com/alura/food/payment/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       ├── config/
│   │   │       └── PaymentApplication.java
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   └── db/
├── Dockerfile
├── pom.xml
└── README.md
```

# Como Rodar o Projeto
## Requisitos
- Java 21 ou superior.
- Maven para construção do projeto.

# Endpoints da API
|Método	| Endpoint |	Descrição|
| ----- | -------- | --------- |
| POST | /payments |	Processar um pagamento |
| GET | /payments/{paymentId} |	Verificar o status do pagamento |
| POST |	/payments |	Incluir um pagamento |
