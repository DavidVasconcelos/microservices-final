# Api Transaction - Microservices-final

## Documentation:
http://localhost:8081/swagger-ui.html

## Salvar transaction:

Url: http://localhost:8080/transactions -> POST

### Exemplo de Body: 

{
  "amount": 259,
  "timestamp": 1556579338000
}

## Obter as estatítiscas:

Url: http://localhost:8081/statistics -> GET

{
  "sum": 259,
  "avg": 259,
  "max": 259,
  "min": 259,
  "count": 1
}

# Docker Build
```sh
docker build -f Dockerfile -t microservices-final
```

## Executar duas instancias 

```sh
docker run -p 8081:8081 -t microservices-final
docker run -p 8082:8081 -t microservices-final
```



