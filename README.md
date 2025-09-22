# 🔐 Password Manager

Un sistema simple de **gestión de contraseñas** con backend en **Spring Boot** y frontend en **Angular**, que permite almacenar, listar, mostrar/ocultar y eliminar contraseñas de manera segura.  

---

## Características

- Crear y almacenar contraseñas asociadas a un servicio y usuario.
- Encriptación AES-256 con IV aleatorio para proteger las contraseñas en la base de datos.
- Listado de contraseñas con opción de **mostrar/ocultar** en el frontend.
- Eliminación de contraseñas guardadas.
- Arquitectura **Spring Boot (REST API)** + **Angular Standalone Components**.

---

## Dependencias principales

### Backend (Spring Boot)
- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA + H2 / PostgreSQL / MySQL
- Lombok

### Frontend (Angular)
- Angular 17+
- RxJS
- Angular Router
- Angular Forms
- HttpClient

### Base de datos (Mysql)
- Docker Desktop o Docker
- Docker compose
---

## Instalación y ejecución

### 1. Clonar el repositorio
```bash
git clone https://github.com/tu-usuario/password-manager.git

cd password-manager-backend
```
### 2. Backend (Spring Boot)

Verificar que tengas Java 17+ y Maven instalados:
```bash
java -version
gradle -v
```

Ejecutar la aplicación:
```bash
gradlew.bat bootRun     # Windows
```

La API estará disponible en:
http://localhost:8080/api/passwords

Por defecto la aplicación usa Mysql.
Que se debe hacer correr antes que el backend con el comando: 
```bash
docker-compose up
```
Esto levantara la base de datos en mysql para que pueda ser utilizada por el backend
### 3. Frontend (Angular)

Entrar en la carpeta del frontend:
```bash
cd password-manager-frontend
```

Instalar dependencias:
```bash
npm install
```

Ejecutar la aplicación:
```bash
ng serve
```

El frontend estará disponible en:
http://localhost:4200

### 4. Probar la aplicación

Abre el navegador en http://localhost:4200.

Agrega nuevas contraseñas con el formulario.

Lista, muestra/oculta y elimina contraseñas.

El frontend consume la API REST del backend en http://localhost:8080/api/passwords.