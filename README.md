# API de Investimentos

API para gerenciar investimentos, desenvolvida com **Java + Spring Boot** e documentada com **Swagger**.

---

## Tecnologias Usadas
- **Java 21**
- **Spring Boot 3**
- **Maven**
- **PostgreSQL**
- **Docker**
- **Swagger (OpenAPI)**
- **JPA / Hibernate**

---

## Pré-requisitos
Antes de rodar a aplicação, certifique-se de ter instalado:

- **[Docker](https://www.docker.com/)**
- **[Java 21](https://www.oracle.com/java/technologies/downloads/#jdk21-windows)**
- **[Maven](https://maven.apache.org/download.cgi)**

>  **Dica:** Se estiver usando o Docker, não precisa instalar o PostgreSQL manualmente.

---

## Como Rodar a Aplicação

### Rodando com Docker (Recomendado)**
**Clone o repositório**:
```sh
git clone https://github.com/GabrielDBri/investimentos-backend.git
cd investimentos-backend
```
## Suba o container com PostgreSQL e a API:
```sh
docker-compose up -d
```

## Acesse a aplicação:

 - API: http://localhost:8080
 - Swagger UI: http://localhost:8080/swagger-ui.html
 - Banco de Dados: localhost:5432 (usuário: postgres, senha: postgres
  
 ## Para parar os containers, use:
```sh 
docker-compose down
```

## Configure o IntelliJ(Ou sua IDE) para Rodar o Back-End
 Agora, rode o projeto normalmente:

## Abra o IntelliJ IDEA
 Vá até a classe ServerApplication.java
 Clique no botão "Run" para iniciar o projeto

 OU, se quiser rodar pelo terminal:
```sh
mvn spring-boot:run

```

# Pronto O Servidor e API vai estar pronta para se comunicar com o Frontend





