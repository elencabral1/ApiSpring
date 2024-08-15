# Spring WebServer

<p>API robusta e eficiente para o gerenciamento de hotéis. A API permite operações de criar e ler, os dados de hotéis, bem como consultas específicas usando um identificador exclusivo chamado messageId.</p>

<p>O projeto foi desenvolvido utilizando Java 17 com Spring Boot 3.3.0 e MySql como banco de dados. Utilizamos várias bibliotecas e ferramentas para garantir alta performance, segurança e facilidade de manutenção.
A segurança é uma prioridade, com autenticação e autorização gerenciadas pelo Spring Security. Tokens JWT são utilizados para autenticação, garantindo segurança e facilidade de uso.</p>

## Funcionalidades da API

## Salvar Hotéis:

<p>A API permite salvar novos registros de hotéis, capturando informações essenciais como hotelId, echoToken, receivableDate, sourceId e rateId. Além disso, cada hotel recebe um messageId exclusivo no formato UUID para identificação única e segura</p>

## Listar Hotéis:

<p>Os usuários podem listar todos os hotéis cadastrados na base de dados, facilitando a visualização e gestão dos registros existentes.</p>

## Buscar por messageId:

<p>Uma funcionalidade chave da API é a possibilidade de buscar um hotel específico pelo seu messageId. Essa consulta retorna se o hotel foi processado e salvo corretamente.</p>
