# Planeta Foguete

Para subir o projeto é necessario ter o Java 11,maven, Docker e Docker Compose.

Suba primeiro o docker compose com o seguinde comando no terminal:

```shell
docker compose up
```

Apos subir os containers é necessario criar um Banco de dados chamado **db_planeta**.

Por fim, para subir a aplicação basta executar o seguinte comando:

```
mvn clean install && mvn spring-boot:run
```

## Requisições:

Todas as requisições são feita na seguinte url base: http://localhost:8088/api .

### Planeta

Os seguintes topicos mostrarão como manipular planetas.

O caminho base para manipular os planetas é **/planeta** .

### Criar

Para criar um planeta é necessário enviar o seguinte json com o metodo POST:

```json
{
	"areax": 3,
	"areay": 3
}
```

Sendo *areax* a largura da area e a *areay* a altura da area.

Exemplo de url: POST http://localhost:8088/api/planeta .



### Consultar 

Para consultar um planeta é necessario passar como parametro o ID do planeta existente.

Exemplo de url: GET http://localhost:8088/api/planeta/1cd77f94-c313-44ff-aac7-2b8867e13982 .



### Consultar Todos

Para consultar todos os planetas é necessario realizar a seguinte requisição:

Exemplo de url: GET http://localhost:8088/api/planeta .



## Sonda

Os seguintes topicos mostrarão como manipular sondas.

O caminho base para manipular as sondas é **/sonda** .

### Criar

Para criar uma sonda é necessário enviar o seguinte json com o metodo POST:

```
{
	"posx": 1,
	"posy": 1,
	"planetaId": "1cd77f94-c313-44ff-aac7-2b8867e13982",
	"orientacao": "oeste"
}
```

Os campos *posx* e *posy* são referentes a posição dentro do planeta que a sonda ira sera criada.

O campo *planetaId* é o id do planeta que anteriormente foi gerado.

O campo *orientacao* indica qual orientação a sonda vai ser posicionada, sendo os possiveis valores: norte, sul, leste e oeste



### Virar para Direita

Para mudar a orientação de uma sonda para a direita é necessário passar o id da sonda na requição:

Exemplo de url: PUT http://localhost:8088/api/sonda/2ef0f7eb-a477-4213-972d-5efdfa1911d9/direita .



### Virar para Esquerda

Para mudar a orientação uma sonda para a esquerda é necessário passar o id da sonda na requição:

Exemplo de url: PUT http://localhost:8088/api/sonda/2ef0f7eb-a477-4213-972d-5efdfa1911d9/esquerda .



### Andar

Para andar com a sonda no sentido em que ela esta orientada é necessário passar o id da sonda na requição:

Exemplo de url: PUT http://localhost:8088/api/sonda/2ef0f7eb-a477-4213-972d-5efdfa1911d9/andar .

### Consultar 

Para consultar uma sonda é necessario passar como parametro o ID da sonda existente.

Exemplo de url: GET http://localhost:8088/api/sonda/2ef0f7eb-a477-4213-972d-5efdfa1911d9 .



### Consultar Todas

Para consultar todas as sondas é necessario realizar a seguinte requisição:

Exemplo de url: GET http://localhost:8088/api/sonda .