# README - Pruebas unitarias e integración de la entidad Empleado

## Descripción general

En este proyecto se han desarrollado pruebas automáticas para verificar el correcto funcionamiento del sistema de gestión de empleados en una aplicación Spring Boot.

Se han implementado dos tipos de pruebas:

1. **Pruebas unitarias**

   * Validan individualmente la lógica del servicio `ServicioEmpleado`.
   * Comprueban operaciones CRUD básicas:

      * Alta de empleado
      * Modificación de datos
      * Eliminación de empleado

2. **Prueba de integración**

   * Verifica el funcionamiento conjunto de:

      * Controlador
      * Servicio
      * Repositorio
      * Base de datos
   * Simula peticiones HTTP reales sobre la API REST.

---

# 1. Pruebas unitarias

Las pruebas unitarias se realizan sobre la clase:

```java
ServicioEmpleado
```

Estas pruebas verifican que los métodos del servicio funcionen correctamente sobre la base de datos de prueba H2.

La clase de pruebas utilizada es:

```java
ServicioEmpleadoTest
```

---

## 1.1 Alta de un nuevo empleado

### Objetivo:

Comprobar que se puede registrar correctamente un nuevo empleado.

### Flujo:

1. Se crea un objeto `Empleado`.
2. Se llama al método:

```java
servicioEmpleado.crearEmpleado(empleado)
```

3. Se verifica que:

   * El empleado no sea nulo.
   * Se haya generado un ID.
   * Los datos coincidan.

### Resultado esperado:

El empleado queda almacenado correctamente.

---

## 1.2 Modificación de datos

### Objetivo:

Verificar que los datos de un empleado existente pueden actualizarse correctamente.

### Flujo:

1. Se crea un empleado.
2. Se genera un objeto con nuevos datos.
3. Se llama al método:

```java
servicioEmpleado.actualizar(id, nuevo)
```

4. Se comprueba que:

   * El nombre se actualiza.
   * El email se actualiza.
   * El rol se actualiza.

### Resultado esperado:

Los datos del empleado quedan modificados correctamente.

---

## 1.3 Eliminación de empleado

### Objetivo:

Comprobar que un empleado puede eliminarse correctamente.

### Flujo:

1. Se crea un empleado.
2. Se llama al método:

```java
servicioEmpleado.borrarEmpleadoPorID(id)
```

3. Se busca nuevamente el empleado.
4. Se verifica que el resultado sea `null`.

### Resultado esperado:

El empleado desaparece de la base de datos.

---

# 2. Prueba de integración

La prueba de integración valida la interacción real entre:

* `ControladorEmpleado`
* `ServicioEmpleado`
* `RepositorioEmpleado`
* Base de datos H2

La clase de prueba utilizada es:

```java
EmpleadoIntegracionTest
```

---

## 2.1 Crear y buscar empleado

### Objetivo:

Comprobar el flujo completo de creación y recuperación de un empleado a través de la API REST.

---

### Paso 1: Crear empleado

Se simula una petición HTTP:

```http
POST /empleados/crear
```

Con el cuerpo JSON:

```json
{
  "nombre": "Laura",
  "email": "laura@gmail.com",
  "rol": "Analista"
}
```

Se verifica que:

* La respuesta sea correcta (`200 OK`)
* Se genere un identificador
* Los datos coincidan

---

### Paso 2: Buscar empleado

Posteriormente se realiza:

```http
GET /empleados/buscar/{id}
```

Se comprueba que:

* El empleado existe
* Los datos coinciden con los insertados

---

### Resultado esperado:

Se valida correctamente la integración entre todas las capas.

---

# 3. Base de datos utilizada en pruebas

Para las pruebas se utiliza una base de datos en memoria **H2**, configurada en:

```properties
src/test/resources/application.properties
```

Configuración:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
```

### Ventajas:

* No afecta la base de datos real.
* Se crea automáticamente al iniciar las pruebas.
* Se elimina al finalizar.

---

# 4. Dependencias necesarias

En el archivo `pom.xml` deben incluirse:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>test</scope>
</dependency>
```

Estas dependencias permiten utilizar:

* JUnit 5
* Spring Test
* MockMvc
* Base de datos H2

---

# 5. Ejecución de pruebas

Las pruebas pueden ejecutarse de dos maneras:

---

## Desde el IDE

Ejecutar la clase de pruebas:

* `ServicioEmpleadoTest`
* `EmpleadoIntegracionTest`

Desde el menú:

```bash
Run Test
```

---

## Desde Maven

Ejecutar todas las pruebas:

```bash
mvn test
```

Ejecutar una prueba concreta:

```bash
mvn -Dtest=EmpleadoIntegracionTest test
```

---

# 6. Resultado esperado

Si todas las pruebas son correctas, Maven mostrará:

```bash
BUILD SUCCESS
```

Esto indica que:

* El alta de empleados funciona
* La modificación funciona
* La eliminación funciona
* La integración entre controlador, servicio y base de datos es correcta

---

# Conclusión

Con estas pruebas se ha validado tanto la lógica interna del servicio como el funcionamiento conjunto de toda la aplicación.

Las pruebas unitarias garantizan el correcto funcionamiento de las operaciones básicas sobre empleados, mientras que la prueba de integración confirma que la API REST, la lógica de negocio y la persistencia en base de datos trabajan correctamente de forma integrada.
