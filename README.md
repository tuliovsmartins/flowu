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

--

## 🚀 Execução local

- É necessário ter o Java 17 no seu JAVA_PATH e o Maven instalados.

Baixar as dependências do projeto e executar o comando abaixo para iniciar o servidor localmente:

```bash
 cd src
 mvn clean install
```

Após o download das dependencias, executar.

```bash
 mvn spring-boot:run
```
Após isso, o serviço estará disponível em `http://localhost:8080`.

---

## 🚀 Execução com Docker

```bash
 docker build -t flowu .
 docker run -p 8080:8080 flowu
```

---

## 🗂 Estrutura de diretórios
```
flowu/
├── src/
│   ├── main/
│   │   ├── java/com/flowu/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   └── service/
│   │   └── resources/
│   │       └── application.yml
├── Dockerfile
├── docker-compose.yml
└── README.md
```
---

## 📄 Licença

Este projeto está licenciado sob a MIT License.Este projeto está licenciado sob a [MIT License](https://opensource.org/licenses/MIT).

---

#### Desenvolvido com 💡 por Tulio Martins.

