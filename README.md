# API REST de Gestión de Usuarios
## Índice
[Descripción](#descripcion)
[Estructura del Proyecto](#estructura-del-proyecto)
[Arquitectura](#arquitectura)
[Endpoints](#endpoints)
[Formato de Respuesta JSON](#formato-de-respuesta-json)
[Configuración](#configuracion)
[Instrucciones de Ejecución](#instrucciones-de-ejecucion)
[Características Implementadas](#caracteristicas-implementadas)
[Requisitos Técnicos](#requisitos-tecnicos)
[Notas Importantes](#notas-importantes)
## Descripción
Este proyecto implementa una API RESTful para la gestión de usuarios utilizando Spring Boot, con persistencia en memoria mediante HSQLDB y manejo completo de errores en formato JSON.

## Estructura del Proyecto

## Arquitectura

## Explicación del Diagrama
## Formato de Respuesta JSON

// Éxito
{
    "mensaje": "Operación exitosa",
    "data": {
        "id": "uuid-12345",
        "nombre": "Juan Rodriguez",
        "email": "juan@ejemplo.com",
        "phones": [...],
        "created": "2025-07-07T15:52:05Z",
        "modified": "2025-07-07T15:52:05Z",
        "last_login": "2025-07-07T15:52:05Z",
        "token": "jwt-token",
        "isActive": true
    }
}

// Error
{
    "mensaje": "El correo ya registrado"
}
## Configuración


## Instrucciones de Ejecución

1
Clonar el repositorio

git clone https://github.com/tu-usuario/repo-proyecto.git

2
Compilar y ejecutar

./gradlew bootRun

3
Probar la API

curl -X POST http://localhost:8080/api/v1/users/register \
-H "Content-Type: application/json" \
-d '{
    "name": "Juan Rodriguez",
    "email": "juan@ejemplo.com",
    "password": "contraseña123",
    "phones": [{
        "number": "1234567",
        "citycode": "1",
        "countrycode": "57"
    }]
}'
## Características Implementadas
Persistencia en memoria con HSQLDB
Manejo completo de errores en JSON
Validación de formato de correo electrónico
Generación automática de UUID y timestamps
Token de acceso por usuario
Documentación Swagger integrada (/swagger-ui.html)
## Requisitos Técnicos
Java 8+
Gradle/Maven
Spring Boot 2.x
HSQLDB (incluido como dependencia)
## Notas Importantes
La base de datos se reinicia al reiniciar la aplicación
Los tokens generados son UUIDs simples (opcional implementar JWT)
Las pruebas unitarias están incluidas en el proyecto
Swagger proporciona documentación interactiva de la API
