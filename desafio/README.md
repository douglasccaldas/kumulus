<h2>Aplicação de Desafio com JSF, PrimeFaces e Spring Boot</h2>

<h3>Descrição:</h3>

<p>Este é um projeto de exemplo que demonstra uma aplicação web desenvolvida usando a tecnologia <strong>JavaServer Faces (JSF)</strong> em conjunto com o framework de componentes <strong>PrimeFaces</strong> e o framework <strong>Spring Boot</strong>. A aplicação ilustra uma arquitetura robusta e escalável para o desenvolvimento de aplicações web empresariais.</p>

<h3>Configuração do Ambiente de Desenvolvimento:</h3>

<ul>
  <li><strong>JDK:</strong> Versão Mais Recente</li>
  <li><strong>IDE:</strong> Eclipse com Spring Tools Plugin</li>
  <li><strong>Banco de Dados:</strong> PostgreSQL (Certifique-se de ter o PostgreSQL instalado e configure as propriedades de conexão no arquivo <code>application.properties</code>)</li>
</ul>

<h3>Importando o Projeto:</h3>

<ol>
  <li>Faça o download do projeto como um arquivo ZIP e descompacte no diretório de preferência.</li>
  <li>Importe o projeto no Eclipse como um projeto Maven existente.</li>
  <li>Certifique-se de que o arquivo <code>application.properties</code> está configurado corretamente para o seu banco de dados PostgreSQL.</li>
</ol>

<h3>Configuração do Banco de Dados:</h3>

<ul>
  <li>Certifique-se de ter o PostgreSQL instalado localmente.</li>
  <li>Execute os scripts SQL fornecidos no diretório <code>src/main/resources/database/scripts</code> para criar as tabelas necessárias no banco de dados.</li>
</ul>

<h3>Executando a Aplicação:</h3>

<p>
  Inicie a aplicação a partir do Eclipse ou execute <code>mvn spring-boot:run</code> no terminal dentro do diretório do projeto. Se estiver utilizando o plugin, basta clicar com o botão direito no projeto e selecionar <strong>Run As > Spring Boot App</strong> (Alt + Shift + X, B). A aplicação estará disponível em <a href="http://localhost:8080/pessoa.xhtml">http://localhost:8080/pessoa.xhtml</a>.
</p>

<h3>Recursos e Tecnologias Utilizadas:</h3>

<ul>
  <li>JavaServer Faces (JSF)</li>
  <li>PrimeFaces (Componentes para JSF)</li>
  <li>Spring Boot (Framework de Inicialização Rápida)</li>
  <li>Spring Data (Facilita a Integração com Bancos de Dados)</li>
  <li>JPA e Hibernate (Mapeamento Objeto-Relacional)</li>
  <li>PostgreSQL (Banco de Dados Relacional)</li>
  <li>REST Template (Para Consultar API de CEP)</li>
  <li>JPQL (Java Persistence Query Language)</li>
  <li>Lombok (Reduz a Necessidade de Códigos Repetitivos)</li>
</ul>
