# Documentación API con Swagger

## 📚 Descripción
Este proyecto incluye documentación automatizada de la API usando **SpringDoc OpenAPI 3** (Swagger) que permite explorar y probar todos los endpoints de manera interactiva.

## 🚀 Acceso a la Documentación

### URLs de acceso:
Una vez que el proyecto esté ejecutándose en el puerto **8084**, podrás acceder a:

- **Swagger UI (Interfaz interactiva)**: http://localhost:8084/swagger-ui.html
- **Documentación JSON**: http://localhost:8084/api-docs
- **Documentación YAML**: http://localhost:8084/api-docs.yaml

### 🔧 Configuración
La configuración de Swagger se encuentra en:
- `SwaggerConfig.java` - Configuración principal de OpenAPI
- `application.properties` - Propiedades adicionales

```properties
# Configuración Swagger
app.openapi.dev-url=http://localhost:8084
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.enabled=true
springdoc.packages-to-scan=com.example.demo2.infrastructure.controller
springdoc.paths-to-match=/inventory-products/**
```

## 📋 Endpoints Documentados

### 🏷️ Inventario de Productos (`/inventory-products`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/inventory-products` | Crear un nuevo producto |
| `GET` | `/inventory-products` | Obtener todos los productos |
| `GET` | `/inventory-products/{id}` | Obtener producto por ID |
| `PUT` | `/inventory-products/{id}` | Actualizar producto completo |
| `DELETE` | `/inventory-products/{id}` | Eliminar producto |
| `PATCH` | `/inventory-products/{id}/add-stock` | Agregar stock |
| `PATCH` | `/inventory-products/{id}/remove-stock` | Remover stock |
| `GET` | `/inventory-products/internal-code/{code}` | Buscar por código interno |

## 📊 Modelos Documentados

### DTOs de Entrada (Request)
- **ProductInventoryRequestDto**: Para crear/actualizar productos
- **StockUpdateRequestDto**: Para modificar cantidades de stock

### DTOs de Salida (Response)
- **ProductInventoryResponseDto**: Información completa del producto
- **InventoryStockResponseDto**: Información básica de stock
- **ErrorResponseDto**: Respuestas de error estandarizadas

## 🎯 Características de la Documentación

### ✅ Incluye:
- ✨ Descripciones detalladas de cada endpoint
- 📝 Ejemplos de requests y responses
- 🔍 Esquemas de todos los modelos de datos
- ⚠️ Códigos de respuesta HTTP documentados
- 🛠️ Interfaz interactiva para probar endpoints
- 📊 Validaciones y restricciones de campos

### 🚀 Cómo usar Swagger UI:
1. Ejecuta el proyecto: `./gradlew bootRun`
2. Abre tu navegador en: http://localhost:8084/swagger-ui.html
3. Explora los endpoints disponibles
4. Haz clic en "Try it out" para probar cualquier endpoint
5. Completa los parámetros requeridos
6. Ejecuta y ve las respuestas en tiempo real

## 🔧 Personalización

### Modificar información de la API:
Edita `SwaggerConfig.java` para cambiar:
- Título y descripción de la API
- Información de contacto
- Licencia
- Servidores disponibles

### Agregar nuevos endpoints:
1. Crea tu controller con anotaciones `@RestController`
2. Usa anotaciones de documentación:
   - `@Tag` - Para agrupar endpoints
   - `@Operation` - Para describir operaciones
   - `@ApiResponse` - Para documentar respuestas
   - `@Parameter` - Para documentar parámetros
   - `@Schema` - Para documentar modelos

## 📋 Ejemplo de Uso

```bash
# Crear un nuevo producto
curl -X POST "http://localhost:8084/inventory-products" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Monitor LED 24 pulgadas",
    "category": "Electrónicos",
    "technicalDescription": "Monitor LED Full HD 1920x1080",
    "images": ["https://example.com/image1.jpg"],
    "stock": 50
  }'
```

## 🛠️ Dependencias Agregadas

```gradle
// SpringDoc OpenAPI para Swagger
implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0'
```

---
*Esta documentación se genera automáticamente y se mantiene sincronizada con el código fuente.*
