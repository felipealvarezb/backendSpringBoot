# Franchise Management System

## Descripción

El **Franchise Management System** es una aplicación de gestión de franquicias que permite crear, editar y gestionar franquicias, sucursales y productos. Este proyecto está desarrollado en **Spring Boot** para el backend y utiliza **PostgreSQL** como base de datos, la cual se ejecuta dentro de un contenedor Docker.

---

## Requisitos previos

Antes de desplegar la aplicación, asegúrate de tener instalado lo siguiente en tu sistema:

1. **Java Development Kit (JDK) 21 o superior**  
   [Descargar JDK](https://adoptium.net/)

2. **Maven** (para compilar y ejecutar el proyecto)  
   [Descargar Maven](https://maven.apache.org/download.cgi)

3. **Docker y Docker Compose** (para la base de datos)  
   [Instalar Docker](https://docs.docker.com/get-docker/)

4. **Postman o cURL** (opcional, para probar los endpoints)

---

## Configuración inicial

### 1. Clonar el repositorio
Clona este repositorio en tu máquina local:

`bash
git clone https://github.com/felipealvarezb/backendSpringBoot.git
cd backend

### 2. Crear y ejecutar el contenedor de PostgreSQL
Descargar e iniciar un contenedor de PostgreSQL en el puerto 5432.
docker-compose up -d

