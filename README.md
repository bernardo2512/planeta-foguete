# Planeta Foguete

Para subir o projeto é necessário ter o Java 11, Maven, Docker e Docker Compose.

Suba primeiro o Docker Compose com o seguinte comando no terminal:

```shell
docker compose up
```

Após subir os containers é necessário criar um Banco de Dados chamado **db_planeta**.

Por fim, para subir a aplicação basta executar o seguinte comando:

```
mvn clean install && mvn spring-boot:run
```

## Requisições:

Todas as requisições são feitas na seguinte URL base: http://localhost:8088/api .

### Planeta

Os seguintes tópicos mostrarão como manipular planetas.

O caminho base para manipular os planetas é **/planeta** .

### Criar

Para criar um planeta é necessário enviar o seguinte json com o método POST:

```json
{
	"areax": 3,
	"areay": 3
}
```

Sendo *areax* a largura da área e a *areay* a altura da área.

Exemplo de URL: POST http://localhost:8088/api/planeta .

### Consultar 

Para consultar um planeta é necessário passar como parâmetro o ID do planeta existente.

Exemplo de URL: GET http://localhost:8088/api/planeta/1cd77f94-c313-44ff-aac7-2b8867e13982 .

### Consultar Todos

Para consultar todos os planetas é necessário realizar a seguinte requisição:

Exemplo de URL: GET http://localhost:8088/api/planeta .

## Sonda

Os seguintes tópicos mostrarão como manipular sondas.

O caminho base para manipular as sondas é **/sonda** .

### Criar

Para criar uma sonda é necessário enviar o seguinte json com o método POST:

```json
{
	"posx": 1,
	"posy": 1,
	"orientacao": "oeste"
}
```

Os campos *posx* e *posy* são referentes à posição dentro do planeta que a sonda será criada.

O campo *orientacao* indica qual orientação a sonda vai ser posicionada, sendo os possíveis valores: norte, sul, leste e oeste.

### Virar para Direita

Para mudar a orientação de uma sonda para a direita é necessário passar o ID da sonda na requisição:

Exemplo de URL: PUT http://localhost:8088/api/sonda/2ef0f7eb-a477-4213-972d-5efdfa1911d9/direita .

### Virar para Esquerda

Para mudar a orientação uma sonda para a esquerda é necessário passar o ID da sonda na requisição:

Exemplo de URL: PUT http://localhost:8088/api/sonda/2ef0f7eb-a477-4213-972d-5efdfa1911d9/esquerda .

### Andar

Para andar com a sonda no sentido em que ela está orientada é necessário passar o ID da sonda na requisição:

Exemplo de URL: PUT http://localhost:8088/api/sonda/2ef0f7eb-a477-4213-972d-5efdfa1911d9/andar .

### Retirar

Para retirar a sonda do planeta onde ela está é necessário passar o ID da sonda na requisição:

Exemplo de URL: PUT http://localhost:8088/api/sonda/2ef0f7eb-a477-4213-972d-5efdfa1911d9/retirar .

### Pousar

Para pousar a sonda em um planeta é necessário passar o ID da sonda e o ID do planeta na requisição:

Exemplo de URL: PUT http://localhost:8088/api/sonda/e38445a7-417c-4cbb-a16b-7e62a30daa15/planeta/e8f1a1b8-d0ef-4efe-bb9a-a2d26d862b65 .

### Consultar 

Para consultar uma sonda é necessário passar como parâmetro o ID da sonda existente.

Exemplo de URL: GET http://localhost:8088/api/sonda/2ef0f7eb-a477-4213-972d-5efdfa1911d9 .

### Consultar Todas

Para consultar todas as sondas é necessário realizar a seguinte requisição:

Exemplo de URL: GET http://localhost:8088/api/sonda .