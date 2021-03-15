<div align="center">

![](https://img.shields.io/badge/Status-Em%20Desenvolvimento-orange)
<a href="https://wesleyosantos91.medium.com/authentication-provider-com-jwt-micronaut-e-kotlin-e53632fc5351"><img src="https://img.shields.io/badge/-Artigo-%2312100E?style=flat&logo=medium&logoColor=white"/></a>
</div>

<div align="center">

# POC - Micronaut, Kotlin e JWT.
Trata-se de uma aplicação de prova de conceito para aplicar segurança utilizando arquitetura: Micronaut, Kotlin e JWT

![](https://img.shields.io/badge/Autor-Wesley%20Oliveira%20Santos-brightgreen)
![](https://img.shields.io/badge/Language-Kotlin-brightgreen)
![](https://img.shields.io/badge/Framework-Micronaut-brightgreen)
![](https://img.shields.io/badge/Security-JWT-brightgreen)

</div> 

## Fundamentos teóricos

> Micronaut: Microunaut é um framework baseado na JVM para criação de micros-serviços inspirado pelo Spring e Grails e permite a criação de aplicações utilizando Java, Kotlin ou Groovy.

> JWT: O JSON Web Token é um padrão da Internet para a criação de dados com assinatura opcional e/ou criptografia cujo payload contém o JSON que afirma algum número de declarações. Os tokens são assinados usando um segredo privado ou uma chave pública/privada.

> Kotlin: Kotlin é uma Linguagem de programação multiplataforma, orientada a objetos e funcional, concisa e estaticamente tipada, desenvolvida pela JetBrains em 2011, que compila para a Máquina virtual Java e que também pode ser traduzida para a linguagem JavaScript e compilada para código nativo.

## Tecnologias
- Kotlin 1.4.30
- Micronaut 2.4.0
    - micronaut-validation
    - micronaut-kotlin-runtime
    - micronaut-jdbc-hikari
    - micronaut-data-jdbc
    - micronaut-data-processor
    - micronaut-security-annotations
    - micronaut-security-jwt
- spring-security-crypto
- testcontainers
- Flywaydb
- Mysql
- GIT

## Execução

A execução das aplicações são feitas através do de um comando Gradle que envoca a inicialização do Micronaut.

- Scripts
  ### Executar docker-compose
    - 1° comando: ``` cd src/main/docker/```
    - 2° comando: ```docker-compose -f docker-compose.yml up```
  ### Executar a aplicação
    - 1° comando: ``` ./gradlew build```
    - 2° comando: ```./gradlew run```

## Utilização

-  Efetuar uma requisição REST temos duas alternativas:
   - 1º Client nativo da versão full do Intellij IDEIA ``` /client/client.http```
   - 2° Arquivo de configuração do Client Postman ``` /client/poc-micronaut-kotlin-jwt.postman_collection.json```
    