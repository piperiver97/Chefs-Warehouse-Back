# CHEF-WAREHOUSE Backend

Este es el backend de la aplicación **CHEF-WAREHOUSE**, una plataforma diseñada para la gestión de almacenes en cocinas profesionales. El backend está desarrollado con **Spring Boot**, proporcionando APIs REST para gestionar ingredientes, proveedores y recetas.

## Tecnologías Utilizadas

- **Java 11**: Lenguaje principal utilizado en el proyecto.
- **Spring Boot**: Framework para crear el backend de la aplicación.
- **Maven**: Para la gestión de dependencias.
- **MySQL**: Base de datos relacional utilizada para almacenar los datos.
- **JPA/Hibernate**: Para el mapeo objeto-relacional.
- **Postman**: Herramienta para probar las APIs.

## Requisitos Previos

Antes de ejecutar este proyecto, asegúrate de tener lo siguiente instalado:

- [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [MySQL](https://dev.mysql.com/downloads/installer/)

## Configuración del Proyecto

1. Clona este repositorio en tu máquina local:

    ```bash
    git clone https://github.com/tu-usuario/chef-warehouse-backend.git
    ```

2. Configura las credenciales de la base de datos en el archivo `src/main/resources/application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/chef_warehouse
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3. Crea la base de datos MySQL:

    ```sql
    CREATE DATABASE chef_warehouse;
    ```

4. Ejecuta el proyecto:

    ```bash
    mvn spring-boot:run
    ```

## Endpoints de la API

Los principales endpoints disponibles en la API son:

- **Ingredientes:**
  - `GET /api/ingredients`: Listar todos los ingredientes.
  - `POST /api/ingredients`: Crear un nuevo ingrediente.
  - `GET /api/ingredients/{id}`: Obtener los detalles de un ingrediente específico.
  - `PUT /api/ingredients/{id}`: Actualizar un ingrediente.
  - `DELETE /api/ingredients/{id}`: Eliminar un ingrediente.

- **Proveedores:**
  - `GET /api/suppliers`: Listar todos los proveedores.
  - `POST /api/suppliers`: Crear un nuevo proveedor.
  - `GET /api/suppliers/{id}`: Obtener los detalles de un proveedor específico.
  - `PUT /api/suppliers/{id}`: Actualizar un proveedor.
  - `DELETE /api/suppliers/{id}`: Eliminar un proveedor.

- **Recetas:**
  - `GET /api/recipes`: Listar todas las recetas.
  - `POST /api/recipes`: Crear una nueva receta.
  - `GET /api/recipes/{id}`: Obtener los detalles de una receta específica.
  - `PUT /api/recipes/{id}`: Actualizar una receta.
  - `DELETE /api/recipes/{id}`: Eliminar una receta.

## Pruebas

Para probar los endpoints, puedes usar **Postman** o cualquier otra herramienta para probar APIs REST. 

También puedes ejecutar las pruebas unitarias y de integración incluidas con **JUnit** ejecutando:

```bash
mvn test
