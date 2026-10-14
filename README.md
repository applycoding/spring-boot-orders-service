# Spring Boot Orders Service

A small REST microservice built with Spring Boot 3 and Java 21.

## Endpoints
- `GET /api/orders` lists orders
- `GET /api/orders/{id}` fetches one order (404 if missing)
- `POST /api/orders` creates an order (validated: non-blank item, quantity >= 1)
- `DELETE /api/orders/{id}` deletes an order
- `GET /actuator/health` health check

## Run
```bash
mvn spring-boot:run
# or
docker build -t orders-service . && docker run -p 8080:8080 orders-service
```

## Test
```bash
mvn test
```

## CI
- `Jenkinsfile`: build, test (JUnit reports) and archive the jar in a Maven Docker agent
- Build locally with `mvn verify` (3 MockMvc tests)
