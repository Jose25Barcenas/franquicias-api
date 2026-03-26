# API de Gestión de Franquicias

Este proyecto es una API REST desarrollada con Spring Boot que permite gestionar franquicias, sucursales y productos.

---

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Maven
- Lombok
- H2 Database
- IntelliJ IDEA

---

## Cómo ejecutar el proyecto en local

### 1. Clonar el repositorio

```bash
git clone https://github.com/Jose25Barcenas/franquicias-api.git
```

---

### 2. Abrir el proyecto en IntelliJ

- File
- Open
- Seleccionar la carpeta `franquicias-api`

---

### 3. Ejecutar la aplicación

Ejecuta la clase:

```bash
FranquiciasApiApplication.java
```

La aplicación se ejecutará en:

```
http://localhost:8080
```

---

## Endpoints principales

### Crear franquicia
```
POST http://localhost:8080/franquicias
```

### Crear sucursal
```
POST http://localhost:8080/franquicias/{id}/sucursales
```

### Crear producto
```
POST http://localhost:8080/franquicias/{id}/sucursales/{sid}/productos
```

### Eliminar producto
```
DELETE http://localhost:8080/franquicias/{id}/sucursales/{sid}/productos/{pid}
```

### Actualizar stock
```
PUT http://localhost:8080/franquicias/{id}/sucursales/{sid}/productos/{pid}/stock?stock=100
```

### Producto con mayor stock por sucursal
```
GET http://localhost:8080/franquicias/{id}/productos-mayor-stock
```

---

## Cómo probar la API

Se puede probar usando:

- IntelliJ HTTP Client (.http)
- Postman
- Navegador (solo para GET)

---

## Autor

José Bárcenas  
Estudiante de Ingeniería de Sistemas