# willca-product-api

## Running the application native

```bash script
./gradlew build \
  -Dquarkus.native.enabled=true \
  -Dquarkus.package.jar.enabled=false \
  -Dquarkus.native.container-build=true
```

## Ejecutar native file en mac con docker

```Run docker
docker run --rm \
-p 8081:8081 \
-v "$(pwd)/build/willca-product-api-1.0.0-SNAPSHOT-runner:/app/application" \
ubuntu:24.04 \
/app/application
```
```run docker con varaible mongodb
docker run --rm \
-p 8081:8081 \
-e QUARKUS_MONGODB_CONNECTION_STRING="mongodb://admin:12345@host.docker.internal:27017" \
-e QUARKUS_MONGODB_DATABASE="willca-product" \
-v "$(pwd)/build/willca-product-api-1.0.0-SNAPSHOT-runner:/app/application" \
ubuntu:24.04 \
/app/application
```
