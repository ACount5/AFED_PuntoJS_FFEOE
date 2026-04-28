# AFBD.PuntoJS

AFBD.PuntoJS es una aplicación backend desarrollada con **Spring Boot** para la gestión y administración orientada a campañas (CRM/Telemarketing). El sistema permite administrar de forma centralizada **Campañas, Clientes, Empleados, Tareas y Resultados**, siguiendo una arquitectura de software multicapa estándar.

## 🛠 Tecnologías Utilizadas

- **Java 21**
- **Spring Boot 3.x/4.x** (Módulos: Web MVC, Data JPA, Data REST)
- **MySQL** (Base de datos relacional)
- **Lombok** (Reducción de código repetitivo/Boilerplate)
- **Maven** (Gestión de dependencias y construcción)

## 📝 Requisitos Previos

Asegúrate de tener instalado lo siguiente en tu entorno de desarrollo antes de intentar arrancar la aplicación:

1. **Java Development Kit (JDK) 21**. Asegúrate de que la variable de entorno `JAVA_HOME` apunte a esta versión.
2. **Maven** (Opcional, el proyecto incluye Maven Wrapper `./mvnw` para facilitar el proceso).
3. **MySQL Server** actuando en el puerto `3306`.

## 🗄️ Configuración de la Base de Datos

El proyecto está configurado en el archivo `application.properties` para conectarse a una base de datos MySQL local (`PuntoJS_DB`) con credenciales específicas. Sigue estos pasos en tu servidor de base de datos MySQL:

1. Inicia sesión en MySQL usando un usuario administrador o `root`:
   ```bash
   mysql -u root -p
   ```

2. Crea la base de datos requerida para la aplicación:
   ```sql
   CREATE DATABASE PuntoJS_DB;
   ```

3. Crea el usuario y asígnale los privilegios necesarios:
   ```sql
   CREATE USER 'usuario'@'localhost' IDENTIFIED BY 'root123';
   GRANT ALL PRIVILEGES ON PuntoJS_DB.* TO 'usuario'@'localhost';
   FLUSH PRIVILEGES;
   ```

> **Nota:** La aplicación utiliza `spring.jpa.hibernate.ddl-auto=update`. Esto significa que Hibernate creará automáticamente las tablas y la estructura necesaria en la base de datos `PuntoJS_DB` la primera vez que se ejecute la aplicación.

## 🚀 Despliegue y Arranque del Proyecto

Puedes levantar la aplicación directamente en modo desarrollo o bien empaquetarla para un entorno de producción.

### Opción 1: Ejecutar usando Spring Boot Plugin (Modo Desarrollo)

Abre un terminal en la raíz del proyecto (donde se encuentra el archivo `pom.xml` o los archivos `mvnw`) y ejecuta el siguiente comando:

**En Linux / macOS:**
```bash
./mvnw spring-boot:run
```

**En Windows:**
```cmd
mvnw.cmd spring-boot:run
```

### Opción 2: Empaquetar y ejecutar como JAR (Modo Producción)

Si necesitas compilar la aplicación para generar un servidor empaquetado autónomo (archivo `.jar`):

1. Compila y empaqueta la aplicación excluyendo los tests si es necesario:
   ```bash
   ./mvnw clean package
   ```
   *(Recuerda usar `mvnw.cmd` en Windows)*

2. Se generará un artefacto JAR dentro del directorio `target/`. Inícialo usando el comando de Java:
   ```bash
   java -jar target/AFBD.PuntoJS-0.0.1-SNAPSHOT.jar
   ```

### 🎯 Verificación del Arranque

Una vez que la aplicación arranque, podrás ver los clásicos logs de inicio de **Spring Boot**. El servidor Tomcat embebido iniciará la API y quedará a la escucha en el puerto **6969**. 

Puedes verificar que la API está funcionando accediendo a:
- [http://localhost:6969/](http://localhost:6969/)

## 🏗️ Arquitectura y Estructura del Código

El proyecto fue diseñado aplicando buenas prácticas de una arquitectura monolítica modular en sus correspondientes paquetes, organizados en `src/main/java/AFBD/PuntoJS/AFBD/PuntoJS/`:

- **`/Dominio` (Modelos / Entidades):** Contiene las clases Java mapeadas como entidades JPA (`@Entity`). Representan las tablas principales del negocio como `Campania`, `Cliente`, `Empleado`, `Resultado` y `Tarea`.
- **`/Repositorio`:** Interfaces que extienden de Spring Data JPA (por ejemplo, `JpaRepository`). Abstraen el acceso y las consultas directas a la base de datos MySQL.
- **`/Servicio`:** Componentes (`@Service`) que orquestan toda la lógica de negocio y las reglas de integración antes de persistir los datos a través de los repositorios.
- **`/Controlador`:** Los controladores de API REST (`@RestController`). Definen las rutas de enlace y actúan como intermediarios entre las solicitudes web y los servicios de la aplicación.

## 💡 Notas Adicionales

1. Si utilizas un IDE como IntelliJ IDEA o Eclipse, recuerda habilitar el procesamiento de anotaciones (Annotation Processing) para que **Lombok** funcione correctamente.
2. Dado que el proyecto tiene la dependencia `spring-boot-devtools`, en modo de desarrollo puedes utilizar reinicio automático y la carga de clases en caliente al realizar cambios.
