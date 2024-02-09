# Prueba-Tecnica-Tizo

# Guía para ejecutar la aplicación Spring Boot con Docker

Esta guía te ayudará a configurar y ejecutar tu aplicación Spring Boot con Java 17 y Gradle, junto con una base de datos MySQL en Docker.

## Requisitos previos

- Docker instalado en tu máquina
- Java 17 instalado
- Gradle instalado

## Pasos

### 1. Clona el repositorio


- git clone <https://github.com/Bymatt10/Prueba-Tecnica-Tizo.git>


## Construye la aplicación
./gradlew build

## Crea la imagen Docker para la aplicación
Comando: docker build -t prueba-tecnica-tizo.

## 4. Configura el archivo docker-compose.yml
   Asegúrate de tener un archivo docker-compose.yml en la raíz de tu proyecto con la siguiente estructura:
## Docker-compose.yml
version: '3.8'

services:
db:
image: mysql:8.0
cap_add:
- SYS_NICE
restart: always
environment:
- MYSQL_DATABASE=reserve
- MYSQL_ROOT_PASSWORD=mauFsd
ports:
- '3306:3306'
volumes:
- test_vol:/var/lib/mysql
- ./db/script:/docker-entrypoint-initdb.d

volumes:
test_vol:
driver: local

## 5.  Ejecuta la base de datos

- docker-compose up

## Link del Swagger
http://localhost:4000/swagger-ui/index.html#/
