<hr>
<p align="center">
   <img src="https://github.com/renatof4rias/spring-project-delivery/assets/123312837/4b2a10ab-f166-4d5a-9b0a-b3fcb5d2de9d" #vitrinedev/>
</p>
<hr>
<h1 align="center"> UPLOAD </h1>

## Descrição do projeto 

<p align="justify">
Upload é uma aplicação backend de uma API REST.

Aplicação consiste em um sistema que faz a leitura de arquivos com a extensão em .txt e .log e faz a inserção de logs em massa no banco de dados.

</p>

## Obetivos
- Leitura de Arquivos e Inserção de Logs em massa no Banco de Dados.
- Serviço de Inserção manual de Logs.
- Pesquisas com Filtros.
- <strong> Estudo de leitura em arquivos e manipulação de banco sem JPA.</strong>

## Sobre
- <strong>O que é um Log ?</strong>
- Respondendo de forma simples, um Log é "histórico" de acesso alguma página.
- Exemplo, Toda vez que acesso meu email é registrado quem/quando/onde acessou o email.
- Logs são utilizados como uma forma de segurança.
- <strong>Como pode ser um Log ?</strong>
- 2021-01-01 00:00:11.763|192.168.234.82|"GET / HTTP/1.1"|200|"swcd (unknown version) CFNetwork/808.2.16 Darwin/15.6.0"
<h1 align="center"> Tecnologias Utilizadas </h1>

## Back end

- Java 
- Spring Boot
- JPA / Hibernate
- Maven
- MVC
- PostgreSQL
- Banco de Dados H2
- PostMan
<h1 align="center"> Como execurtar o projeto </h1>

## Back end  
Pré-requisitos: Java 17

```bash
# clonar repositório
git clone git@github.com:renatof4rias/spring-project-upload-file

# entrar na pasta do projeto back end
cd upload

# executar o projeto
./mvnw spring-boot:run
```

<h1 align="center"> Como testar o projeto </h1>

Pré-requisitos: Postman

```bash
#END POINTS
[POST] /upload #Faz a Leitura de cada linha contida no arquivo enviado via parâmetro.
[POST] /upload #Faz a Inserção de Log Manualmente.
[GET] /upload #Buscas com filtros retorna Logs específicos, Buscas sem filtro retorna a Lista completa de Logs.
```
Observações 
```bash
#Método
Para a inserção em Massa utilizar o [POST] /upload, juntamente com o arquivo de leitura (.txt)(.log).
Para a inserção Manualmente utilizar o [POST] /upload, juntamente com parâmetros.
Exemplo de inserção manual:
Via Postman -> [POST] localhost:8080/upload -> Aba "Params" -> Keys e Value
{
        KEY                                VALUE
        data                               2021-01-01 23:58:39.905
        ip                                 192.168.106.181
        request                            GET / HTTP/1.1
        status                             200
        userAgent                          UserAgent Inserido Manualmente Para Test
}

```
# Autor
Renato Gonçalves Farias

https://www.linkedin.com/in/renatof4rias/

renatof4rias@gmail.com
