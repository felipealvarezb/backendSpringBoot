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

```bash
git clone https://github.com/felipealvarezb/backendSpringBoot.git
cd backend
```
### 2. Crear y ejecutar el contenedor de PostgreSQL
Descargar e iniciar un contenedor de PostgreSQL en el puerto 5432.

Credenciales por defecto: Usuario: admin - Contraseña: admin

```bash
docker-compose up -d
docker ps 
```
### 3. Compilar el proyecto

Para compilar el proyecto, ejecuta:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

## 4. Endpoints disponibles

La aplicación expone alguno de los siguientes endpoints principales:

### **Franchise**
#### Crear una franquicia
- **Método:** `POST`
- **URL:** `http://localhost:8080/api/v1/franchise`
- **Body (JSON):**
  ```json
  {
    "name": "Subway"
  }
  ```

### **Franchise**
#### Actualiza una franquicia
- **Método:** `PUT`
- **URL:** `http://localhost:8080/api/v1/franchise`
- **Body (JSON):**
  ```json
  {
    "id": 4
    "name": "Subway"
  }
  ```

  ### **Branch**
#### Crear una sucursal
- **Método:** `POST`
- **URL:** `http://localhost:8080/api/v1/branch`
- **Body (JSON):**
  ```json
   {
    "name": "Medellin",
    "franchiseId": 4,
   }
  ```

### **Branch**
#### Actualiza una sucursal 
- **Método:** `PUT`
- **URL:** `http://localhost:8080/api/v1/branch`
- **Body (JSON):**
  ```json
  {
    "id": 1,
    "name": "Bogota",
  }
  ```

### **Product**
#### Crear una Producto
- **Método:** `POST`
- **URL:** `http://localhost:8080/api/v1/product`
- **Body (JSON):**
  ```json
   {
     "name": "italianisimo",
     "stock": 200,
     "branchId": 1
   }
  ```

### **Product**
#### Actualizar un Producto 
- **Método:** `PUT`
- **URL:** `http://localhost:8080/api/v1/product`
- **Body (JSON):**
  ```json
  {
    "id": 1,
    "name": "italianoBMT",
  }
  ```

### **Product**
#### Encontrar el Producto que mas stock tiene
- **Método:** `PUT`
- **URL:** `http://localhost:8080/api/v1/product/top-products/{franchiseId}`
- **Body (JSON):**
  ```json
  {
    "id": 1,
    "name": "italianoBMT",
  }
  ```





  



