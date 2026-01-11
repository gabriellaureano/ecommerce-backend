🛒 E-commerce Backend – Spring Boot

Backend de um sistema de e-commerce, desenvolvido em Java com Spring Boot, utilizando H2 Database para desenvolvimento.

O projeto simula o fluxo principal de um e-commerce real, trabalhando com usuários, pedidos, itens de pedido e produtos, todos relacionados por ID.

🚀 Tecnologias Utilizadas

Java

Spring Boot

Spring Data JPA

H2 Database

Maven

Git

🧠 Visão Geral

O sistema segue um fluxo encadeado e bem definido, representando o funcionamento de um e-commerce backend real:

➡️ Usuário → Order → OrderItem → Product

O projeto é 100% backend, focado em regras de negócio, persistência de dados e relacionamentos entre entidades.

🔁 Fluxo Principal do E-commerce
Usuário
↓
Order
↓
OrderItem
↓
Product

📦 Funcionalidades

✅ Criar usuário
✅ Criar order (pedido)
✅ Criar order items
✅ Associar produtos aos itens do pedido
✅ Buscar order completo com itens, produtos e status

🚧 Funcionalidades futuras:

Finalizar pedido

Cancelar pedido

Validação de estoque

Persistência em banco relacional real

🗄️ Modelagem e Relacionamentos
Entidades Principais

User

Order

OrderItem

Product

Relacionamentos

Um User pode ter vários Orders

Um Order pertence a um User

Um Order possui vários OrderItems

Um OrderItem referencia um Product

Todos os relacionamentos são realizados por ID, simulando um cenário real de API REST.

▶️ Como Executar o Projeto

Clone o repositório:

git clone https://github.com/seu-usuario/seu-repositorio.git


Acesse o projeto:

cd seu-repositorio


Execute a aplicação:

./mvnw spring-boot:run


Acesse:

API: http://localhost:8080

H2 Console: http://localhost:8080/h2-console

🧪 Banco de Dados

O projeto utiliza o H2 Database, um banco em memória, ideal para estudos e testes locais.
A estrutura do banco é criada automaticamente via JPA/Hibernate.

🎯 Objetivo do Projeto

Projeto desenvolvido com foco em:

Prática de backend com Java e Spring Boot

Aplicação de relacionamentos entre entidades

Simulação de regras reais de um e-commerce

Uso como projeto de estudo e portfólio

👨‍💻 Autor

Gabriel Laureano
Backend Developer em formação
Java | Spring Boot | APIs REST