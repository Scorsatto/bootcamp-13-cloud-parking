# Realizando Deploy na Nuvem de um Conjunto de API’s Desenvolvida em Spring Boot
## Desafio:
Desenvolver um conjunto de API’s utilizando Spring Boot para controlar um estacionamento de veículos. Serão controlados a entrada, saída e valor a ser cobrado do cliente. Iremos aplicar todas as boas práticas de desenvolvimento de API’s incluindo segurança com Spring Security e acesso a banco de dados PostgreSQL. Serão realizados testes e relatórios de cobertura de testes. Após finalizarmos a aplicação e termos enviado para o Github, vamos fazer o deploy na cloud do Heroku a fim de disponibilizar nossa API para a Internet.

Instrutor: Sandro Giacomozzi

## Alterações:

1- Adicione a dependência do Spring Boot devtools ao seu arquivo `pom.xml`.

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <version>your-desired-version</version>
    </dependency>

2- Reinicie o projeto.

3- No IntelliJ idea 2021+ em File->Setting->Build, Execution, Deployment->Compiler: marcar a opção `Build project automatically`.

4- No IntelliJ idea 2021+ em File->Setting->Advance Setting: marcar a opção `Allow auto-make to start even if developed application is currently running`.

## Adicionando Swagger ao projeto:

Adicionar anotação `@EnableWebMvc` a classe `SwaggerConfig.java`.

    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-boot-starter</artifactId>
        <version>3.0.0</version>
    </dependency>

Link para acesso do swagger: http://localhost:8080/swagger-ui/index.html