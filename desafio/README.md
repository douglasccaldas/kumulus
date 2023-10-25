Aplicação de Desafio com JSF, PrimeFaces e Spring Boot

Descrição:

Este é um projeto de exemplo que demonstra uma aplicação web desenvolvida usando a tecnologia JavaServer Faces (JSF) em conjunto com o framework de componentes PrimeFaces e o framework Spring Boot. A aplicação ilustra uma arquitetura robusta e escalável para o desenvolvimento de aplicações web empresariais.

Configuração do Ambiente de Desenvolvimento:

JDK: Versão Mais Recente
IDE: Eclipse com Spring Tools Plugin
Banco de Dados: PostgreSQL (Certifique-se de ter o PostgreSQL instalado e configure as propriedades de conexão no arquivo application.properties)
Importando o Projeto:

Faça o download do projeto como um arquivo ZIP e descompacte no diretório de preferência.
Importe o projeto no Eclipse como um projeto Maven existente.
Certifique-se de que o arquivo application.properties está configurado corretamente para o seu banco de dados PostgreSQL.
Configuração do Banco de Dados:

Certifique-se de ter o PostgreSQL instalado localmente.
Execute os scripts SQL fornecidos no diretório src/main/resources/database/scripts para criar as tabelas necessárias no banco de dados.
Executando a Aplicação:

Inicie a aplicação a partir do Eclipse ou execute mvn spring-boot:run no terminal dentro do diretório do projeto.
Se estiver utilizando o plugin, basta clicar com o botão direito no projeto e selecionar Run As > Spring Boot App (Alt + Shift + X, B).
A aplicação estará disponível em http://localhost:8080/pessoa.xhtml.
Recursos e Tecnologias Utilizadas:

JavaServer Faces (JSF)
PrimeFaces (Componentes para JSF)
Spring Boot (Framework de Inicialização Rápida)
Spring Data (Facilita a Integração com Bancos de Dados)
JPA e Hibernate (Mapeamento Objeto-Relacional)
PostgreSQL (Banco de Dados Relacional)
REST Template (Para Consultar API de CEP)
JPQL (Java Persistence Query Language)
Lombok (Reduz a Necessidade de Códigos Repetitivos)
