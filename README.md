# Microservicio Cloud-Native

Proyecto de ejemplo del artículo [Tu primer microservicio cloud-native con Quarkus](https://quarkiverso.io/arquitectura/microservicio-cloud-native-quarkus/).


## Características

- **MicroProfile Config**: Configuración externalizada
- **MicroProfile Health**: Liveness y Readiness probes
- **MicroProfile Metrics**: Métricas para Prometheus
- **MicroProfile OpenAPI**: Documentación automática

## Ejecutar

```bash
quarkus dev
```

## Probar

### Endpoint principal
```bash
curl "http://localhost:8080/saludo?nombre=Quarkiverso"
```

### Health Checks
```bash
# Liveness
curl http://localhost:8080/q/health/live

# Readiness
curl http://localhost:8080/q/health/ready

# Ambos
curl http://localhost:8080/q/health
```

### Métricas
```bash
curl http://localhost:8080/q/metrics
```

### OpenAPI / Swagger UI
```
http://localhost:8080/q/swagger-ui
```

## Configuración con variables de entorno

```bash
SALUDO_MENSAJE="Hola desde K8s" SALUDO_VERSION="2.0" quarkus dev
```
