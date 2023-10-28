# API de una libreria, proyecto Diplomado UNAM<br>
<h3>Omar Jesús Sánchez Jiménez</h3><br>
Microservicio para agregar, mostrar por ID, borrar por ID, actualizar por ID  y mostrar una coleccion completa de libros

El microservicio agrega un documento a la colección "libros" y despliega los metodos PUT, GET, DELETE y UPDATE de los libros usando mongodb como base de datos NON-SQL y se utiliza un archivo para crear la base de datos librosdb, el cual se ejecuta desde un MONGO en localhost.<br>
El microservicio sera del tipo REST, la api esta contruida en JAVA, usando SpringBoot, Loombok y MAVEN, esta aplicación esta guiada por el Diseño de aplicaciones nativas para la
nube (12 factores). Ademas se hace uso de swagger para documentar su funcionamiento.

LA API hace lo siguiente:

- Insertar un libro
- Buscar un libro por su ID (el ID lo crea la BD de Mongo al agregar un libro)
- Buscar todos los libros de la BD
- Borrar un libro por su ID
- Actualizar algun campo del documento "Libro"

Antes de empezar deberemos de crear la BD en Mongo ayudandonos del siguiente script, la base es local, el puerto es 27017 (default):

en el shell de mondoDB:

use admin
db.createUser(
{
user: "libreria",
pwd: "libreria",
roles: [ { role: "userAdmin", db: "librosdb" }]
})

Para ejecutar el proyecto en un ambiente local, se debe hacer de la siguiente manera:

Clonar el codigo de este repositorio en una máquina local.<br>
Abrir el proyecto en el Framework de Eclipse.<br>
Revisar las dependencias necesarias que estan listadas en el archivo pom.xml (el archivo se encuentra en la raiz del proyecto).<br>
Ejecutar la aplicación dentro del Framework para verificar y corregir errores.<br>
Utilizar POSTMAN o un navegador para ejecutar las consultas del archivo YAML siguiente (mas abajo se pone un ejemplo):<br>
     

# test
Ejecutar el siguiente curl

curl -X 'POST' \
  'http://localhost:8084/api/libros' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
    "titulo":"Doce cuentos peregrinos",
    "autores":"Gabriel García Márquez",
    "editorial":"Diana",
    "edicion":2022,
    "paginas":700,
    "precio":420,
    "existencia":10,
    "isbn":"978-0140239409"
}' 

 El resultado deberia ser el siguiente:
 
 { "_id" : ObjectId("651e241f2869ee605130113f"), "titulo" : "Doce cuentos peregrinos", "autores" : "Gabriel García Márquez", "editorial" : "Diana", "edicion" : 2022, "paginas" : 700, "precio" : 420, "existencia" : 10, "isbn" : "978-0140239409" }

# Ejemplos de ejecucion de los Endpoints
<ul>
     <li>Buscar un libro por ID</li>
![GETbuscarporID](https://github.com/OmarSanchezJ/modulo2/assets/82127842/f9439d76-bae0-42c2-8a38-eea15dd35303)
     <li>Buscar todos los libros</li>
     ![GETtodoslibros](https://github.com/OmarSanchezJ/modulo2/assets/82127842/7415b56e-473d-4038-89b3-bc74480bd991)
     <li>Agregar un libro</li>
![POSTagregar](https://github.com/OmarSanchezJ/modulo2/assets/82127842/709ff815-cfd7-43dc-ae63-1072a6e0d93d)
     <li>Borrar un libro</li>
     ![DELETEborrarporID](https://github.com/OmarSanchezJ/modulo2/assets/82127842/45e02aaa-6638-4d44-94aa-2083e166108f)
     <li>Actualizar un libro</li>
     ![PUTactualizarlibro](https://github.com/OmarSanchezJ/modulo2/assets/82127842/b9326cbb-94f1-4e1f-b630-8bfbb86ec444)
</ul>

# Archivo YAML

<a href="api-docs.yaml">archivo YAML</a>

# Documentacion de referencia
<a href="https://maven.apache.org/guides/index.html">Official Apache Maven documentation</a>

<a href="https://docs.spring.io/spring-boot/docs/2.7.15/maven-plugin/reference/htmlsingle/">Spring Boot Maven Plugin Reference Guide</a>

<a href="https://docs.spring.io/spring-boot/docs/2.7.15/maven-plugin/reference/htmlsingle/#build-image">Create an OCI image</a>

<a href="https://docs.spring.io/spring-boot/docs/2.7.15/reference/htmlsingle/index.html#web">Spring Web</a>

<a href="https://www.mongodb.com/compatibility/spring-boot">Spring Data MongoDB</a>
