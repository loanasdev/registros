# API REST de Gestión de Usuarios
## Descripción
Este proyecto implementa una API RESTful para la gestión de usuarios utilizando Spring Boot, con persistencia en memoria mediante HSQLDB y manejo completo de errores en formato JSON.

## Arquitectura
    1. Project: Maven Project
    2. Language: Java 21
    3. Spring Boot.
    4. Project Metadata:
        Group: com.smartjob
        Artifact: user-registration
    5. Packaging: Jar    
    6. Dependencies:

        Spring Web
        Spring Security
        Spring Data JPA
        H2 Database
        Lombok
        
## Formato de Respuesta JSON

    1. Éxito
    {
        "id": "9555c0d3-a151-4758-840a-b43a1f084e14",
        "created": "2025-07-07T12:27:39.686174",
        "modified": "2025-07-07T12:27:39.686174",
        "last_login": "2025-07-07T12:27:39.686174",
        "token": null,
        "isactve": true
    }    

    2. Error
    {
        "mensaje": [
            "El nombre de usuario ya existe.",
            "El correo ya está registrado."
        ]
    }

## Instrucciones de Ejecución

    1. Clonar el repositorio

        https://github.com/loanasdev/registros.git

    2. Compilar y ejecutar
        
        Ejecute la aplicación desde su IDE navegando a la JwtDemoApplicationclase o use la línea de comando:

        mvn spring -boot : run

    3. Probar API
        Registrar un usuario.
        POST http://localhost:8080/api/auth/registrar
        Content-Type: application/json
        {
            "username": "usuario1",
            "email": "usuario1@demo.cl",
            "password": "@Usuario123-"
        }

        Login de usuario
        POST http://localhost:8080/api/auth/login
        Content-Type: application/json
        {
            "username": "usuario1",
            "password": "@Usuario123-"
        }   

## Características Implementadas

    1. Persistencia en memoria con HSQLDB
    2. Manejo completo de errores en JSON
    3. Validación de formato de correo electrónico
    4. Generación automática de UUID y timestamps
    5. Token de acceso por usuario
    6. Documentación Swagger integrada (/swagger-ui.html)
    
## Requisitos Técnicos
    1. Java 21
    2. Maven
    3. Spring Boot 3.5.3
    4. HSQLDB (incluido como dependencia)

## Notas Importantes
    1. La base de datos se reinicia al reiniciar la aplicación.
    2. Los tokens generados son UUIDs simples (opcional implementar JWT).
    3. Las pruebas unitarias están incluidas en el proyecto.
    4. Swagger proporciona documentación interactiva de la API.
