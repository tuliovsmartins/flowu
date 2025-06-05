# FlowU

**FlowU** é um microserviço de orquestração de fluxos. Seu propósito é armazenar, gerenciar e orquestrar a execução de diversos tipos de fluxos e seus nós. Ele interage com um frontend em React e um banco de dados PostgreSQL, fornecendo uma base sólida e extensível para construção de sistemas orientados a fluxos.

---

## 🔧 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Docker**
- **Lombok**
- **MapStruct**
- **Arquitetura MVC**

---

## 📐 Arquitetura

FlowU segue o padrão MVC e é composto por:

- **Modelos** para definição dos fluxos, nós e execuções.
- **Controladores REST** para interação com o frontend.
- **Serviços** que contêm a lógica de orquestração dos fluxos.
- **Repositórios JPA** para persistência dos dados.

---

## 🧠 Funcionalidades

- Cadastro de tipos de fluxo e seus nós.
- Armazenamento e versionamento de fluxos.
- Execução orquestrada de fluxos.
- Integração com frontend React.
- Persistência em banco de dados PostgreSQL.
- Executável via Docker para facilitar o deploy.

---

## 🚀 Execução com Docker

```bash
docker build -t flowu .
docker run -p 8080:8080 flowu
