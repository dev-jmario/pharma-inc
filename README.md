# Pharma-Inc
O projeto é resultado de um desafio, composto por uma API REST, para realizar operações de Crud e uma importação através de uma integração com a API "randomUser", usando um Cron com um horário definido em configuração para execução.

# Tecnologias/ Frameworks

* JAVA 11
* Spring Boot
* Spring Data JPA
* Spring Web
* Hibernate
* Postgresql
* Lombok
* Mockito
* Docker
 
# Configurações

Deve ser configurado no arquivo "application.yml" a hora e minuto a ser executado o Cron para importação dos dados por meio da API "randomUser".
Os respectivos campos se encontram no nó: spring, exec, hour e minute.

# Arquivos adicionais

* Dockerfile
* docker-compose.yml
