# modulo2
Microservicio para agregar, mostrar por ID, borrar por ID, actualizar por ID  y mostrar una coleccion completa de libros

El microservicio agrega un documento a la colección "libros" y despliega la ista de todos los libros usando mongodb como base de datos NON-SQL y se utiliza el siguiente archivo para crear la base de datos librosdb
El microservicio sera del tipo REST, la api esta contruida en JAVA, usando SpringBoot, Loombok y MAVEN, esta aplicación esta guiada por el Diseño de aplicaciones nativas para la
nube (12 factores):

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

El archivo YAML es el siguiente:

      

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

# Documentacion de referencia
<a href="https://maven.apache.org/guides/index.html">Official Apache Maven documentation</a>

<a href="https://docs.spring.io/spring-boot/docs/2.7.15/maven-plugin/reference/htmlsingle/">Spring Boot Maven Plugin Reference Guide</a>

<a href="https://docs.spring.io/spring-boot/docs/2.7.15/maven-plugin/reference/htmlsingle/#build-image">Create an OCI image</a>

<a href="https://docs.spring.io/spring-boot/docs/2.7.15/reference/htmlsingle/index.html#web">Spring Web</a>

<a href="https://www.mongodb.com/compatibility/spring-boot">Spring Data MongoDB</a>
