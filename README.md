# API de una libreria, proyecto Diplomado UNAM<br>
<h3>Proyecto de un microservicio REST, corriendo de forma local, usando Docker y Kubernetes - v1.0</h3><br>
Microservicio para agregar, mostrar por ID, borrar por ID, actualizar por ID  y mostrar una coleccion completa de libros

El microservicio agrega un documento a la colección "libros" y despliega los metodos PUT, GET, DELETE y UPDATE de los libros usando mongodb como base de datos NON-SQL y se utiliza un archivo para crear la base de datos librosdb, el cual se ejecuta desde un MONGO en ATLAS.<br>
El microservicio sera del tipo REST, la api esta contruida en JAVA, usando SpringBoot, Loombok y MAVEN, esta aplicación esta guiada por el Diseño de aplicaciones nativas para la
nube (12 factores). Ademas se hace uso de swagger para documentar su funcionamiento.

LA API hace lo siguiente:

* Insertar un libro
* Buscar un libro por su ID (el ID lo crea la BD de Mongo al agregar un libro)
* Buscar todos los libros de la BD
* Borrar un libro por su ID
* Actualizar algun campo del documento "Libro"

Antes de empezar se deberá  crear la BD en Mongo ATLAS por lo que deberemos crear una cuenta en el sitio web https://www.mongodb.com/es , deberemos crear
la base de datos "librosdb", ademas debemos asegurarnos que la IP de nuestro localhost puede acceder a MONGO ATLAS.<br>La base tendra los siguientes parametros:<br>
usuario: "libreria"<br>
password: "libreria"<br>

Para ejecutar el proyecto en un ambiente local, se debe hacer de la siguiente manera:

+ Clonar el codigo de este repositorio en una máquina local.<br>
+ Abrir el proyecto en el Framework de Eclipse.<br>
+ Revisar las dependencias necesarias que estan listadas en el archivo pom.xml (el archivo se encuentra en la raiz del proyecto).<br>
+ Ejecutar la aplicación dentro del Framework para verificar y corregir errores.<br>
+ Utilizar POSTMAN o un navegador para ejecutar las consultas de cada endpoint (mas abajo se pone los ejemplos):<br>
     
> [!IMPORTANT]
> Revisar en MONGO ATLAS los permisos de acceso a la BD
> Para nuestros entornos local, en Docker y en Kubernetes, en cada paso deberemos agregar la IP correspondiente para que se pueda accesar a la DB


# test
Ejecutar el siguiente curl para saber si la API esta "corriendo" correctamente.

```
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
```

 El resultado deberia ser el siguiente:
 
 { "_id" : ObjectId("651e241f2869ee605130113f"), "titulo" : "Doce cuentos peregrinos", "autores" : "Gabriel García Márquez", "editorial" : "Diana", "edicion" : 2022, "paginas" : 700, "precio" : 420, "existencia" : 10, "isbn" : "978-0140239409" }

# Ejemplos de ejecucion de los Endpoints
<ul>
     <li><strong>Buscar un libro por ID</strong></li>
<img src="https://github.com/OmarSanchezJ/modulo2/assets/82127842/f9439d76-bae0-42c2-8a38-eea15dd35303">
     <li><strong>Buscar todos los libros</strong></li>
     <img src="https://github.com/OmarSanchezJ/modulo2/assets/82127842/7415b56e-473d-4038-89b3-bc74480bd991">
     <li><strong>Agregar un libro</strong></li>
<img src="https://github.com/OmarSanchezJ/modulo2/assets/82127842/709ff815-cfd7-43dc-ae63-1072a6e0d93d">
     <li><strong>Borrar un libro</strong></li>
<img src="https://github.com/OmarSanchezJ/modulo2/assets/82127842/45e02aaa-6638-4d44-94aa-2083e166108f">
     <li><strong>Actualizar un libro</strong></li>
     <img src="https://github.com/OmarSanchezJ/modulo2/assets/82127842/b9326cbb-94f1-4e1f-b630-8bfbb86ec444">
</ul>

# Archivo YAML

<a href="api-docs.yaml">archivo YAML</a>

# Pasos para crear el Docker de la API
Se deberá compilar el codigo del proyecto en la misma maquina local siguiendo las siguientes instrucciones (se utilizó UBUNTU para este ejemplo):<br>
     <strong>Desde el shell instalar la siguiente version de JAVA</strong><br>
     + apt install openjdk-17-jdk openjdk-17-jre<br>
     <strong>Copiar de forma manual MAVEN 3.9.5</strong><br>
     + Bajar la version desde  https://maven.apache.org/download.cgi<br>
       <strong>Descomprimir y mover el contenido</strong> <br>
     +  tar -xzf apache-maven-3.9.5-bin.tar.gz<br>
     + sudo mv apache-maven-3.9.5 /opt/maven<br><br>
     <strong>Configurar las variables de entorno para MAVEN</strong>
     
     export JAVA_HOME=/usr/lib/jvm/default-java
     export M3_HOME=/opt/maven
     export MAVEN_HOME=/opt/maven
     export PATH=${M3_HOME}/bin:${PATH}
    
   <strong>Crear las variables de entorno  para conectarnos a MONGO ATLAS y compilar</strong>
     
     export MONGO_URI="mongodb+srv://libreria:libreria@cluster0.luvjnen.mongodb.net/librosdb"
     export MONGO_AUTH=admin
     export MONGO_PORT=27017
     export TOMCAT_PORT=8084
     
   <strong>Una vez compilada nuestra app, se crea el siguiente Dockerfile</strong><br><br>
   
```
FROM ubuntu
##instalar nginx 
RUN apt-get update
RUN apt-get install -y nginx
EXPOSE 80

FROM openjdk:17.0.2-jdk
##Copiar el paquete jar file dentro de nuestra imagen
COPY target/app.jar /api.jar

##Ejecutar el comando del compilado para su deploy
CMD ["java", "-jar", "/api.jar"]
```
<strong>Construir la imagen</strong><br>
docker build -t cloud-libros-service:spring-docker .<br><br>
     
     
# Correr nuestra API en  DOCKER con las variables de entorno

```
     docker run -d -p 8084:8084 -e MONGO_URI="mongodb+srv://libreria:libreria@cluster0.luvjnen.mongodb.net/librosdb" -e MONGO_AUTH=admin -e MONGO_PORT=27017 -e TOMCAT_PORT=8084 cloud-libros-service:spring-docker
```

* Poner en DOCKER HUB nuestro contenedor<br><br>
     <strong>Logearnos y crear un TAG de nuestro imagen</strong>
     <br>docker login<br>
     docker tag cloud-libros-service:spring-docker arkhamax/cloud-libros-service:v1.0<br><br>
     <strong>Subir nuestra imagen a Docker HUB</strong><br>
     docker push arkhamax/cloud-libros-service:v1.01<br><br>
          la imagen de este proyecto se encuentra en el siguiente repositorio:<br>
          https://hub.docker.com/repository/docker/arkhamax/cloud-libros-service/general<br>
     

# Correr nuestra API en KUBERNETES con las variables de entorno

Primero deberemos de hacer nuestros Manifiestos de los siguientes archivos (utilizamos nano para crear los archivos):

* libros-deployment.yaml
* libros-services.yaml
* libros-ingress.yaml
* configmap.yaml


<strong>libros-deployment</strong>

```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: libros-deployment
spec:
  replicas: 1
  selector:
    matchLabels:
      app: libros-rest
  template:
    metadata:
      labels:
        app: libros-rest
    spec:
      containers:
        - name: libros-dockercontainer
          image: arkhamax/cloud-libros-service:v1.0
          ports:
            - containerPort: 80
          env:
            - name: MONGO_URI
              valueFrom:
                configMapKeyRef:
                  name: libros-configmap
                  key: mongo_uri
            - name: MONGO_AUTH
              valueFrom:
                configMapKeyRef:
                  name: libros-configmap
                  key: mongo_auth
            - name: MONGO_PORT
              valueFrom:
                configMapKeyRef:
                  name: libros-configmap
                  key: mongo_port
            - name: TOMCAT_PORT
              valueFrom:
                configMapKeyRef:
                  name: libros-configmap
                  key: tomcat_port
```
<strong>libros-service.yaml</strong>

```
apiVersion: v1
kind: Service
metadata:
  name: libros-service
spec:
  selector:
    app: libros-rest
  ports:
    - name: http
      protocol: TCP
      port: 80
      targetPort: 80
    - name: portapp
      protocol: TCP
      port: 8084
      targetPort: 8084
    - name: mongoatlas
      protocol: TCP
      port: 27017
      targetPort: 27017
```
<strong>libros-ingress.yaml</strong>        

```
apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: libros-ingress
spec:
  ingressClassName: nginx
  rules:
    - host: localhost
      http:
        paths:
          - path: /api/libros
            pathType: Prefix
            backend:
              service:
                name: web80
                port:
                  number: 80
            backend:
              service:
                name: libros-service
                port:
                  number: 8084
```
<strong>configmap.yaml</strong>

```
apiVersion: v1
kind: ConfigMap
metadata:
  name: libros-configmap
data:
  MONGO_URI: "mongodb+srv://libreria:libreria@cluster0.luvjnen.mongodb.net/librosdb"
  MONGO_AUTH: admin
  MONGO_PORT: "27017"
  TOMCAT_PORT: "8084"
```
<strong>Creación de los apply de deployment, service, ingress y configmap</strong><br>
kubectl apply -f libros-deployment.yaml<br>
kubectl apply -f libros-service.yaml<br>
kubectl apply -f libros-ingress.yaml<br>
kubectl apply -f libros-configmap.yaml<br>

<strong> Ejecutamos nuestro pod de forma interactiva </strong><br>
 kubectl exec -it libros-deployment-75f7b65c8b-7wh48 -- /bin/bash<br><br>
Nos metemos al bash y ejecutamos la misma estructura del CURL anterior (con diferentes datos):

```
curl -X 'POST' \
  'http://localhost:8084/api/libros' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
    "titulo":"El amor en tiempos de colera",
    "autores":"Gabriel García Márquez",
    "editorial":"Diana",
    "edicion":2023,
    "paginas":546,
    "precio":399,
    "existencia":18,
    "isbn":"911-01568409"
}'    
```
# Automatizar los updates de nuestra API usando TEKTON
 
 Deberemos de poner nuestros archivos de configuracion (puertos, usuarios,etc.) en formato secret de tekton
 * Los archivos de configuracion de este paso estan en la carpeta <strong>tekton</strong>
 
 kubectl create -f https://raw.githubusercontent.com/OmarSanchezJ/modulo2/main/manifest/tekton/libreria-secret.yaml


# Documentacion de referencia
<a href="https://maven.apache.org/guides/index.html">Official Apache Maven documentation</a>

<a href="https://docs.spring.io/spring-boot/docs/2.7.15/maven-plugin/reference/htmlsingle/">Spring Boot Maven Plugin Reference Guide</a>

<a href="https://docs.spring.io/spring-boot/docs/2.7.15/maven-plugin/reference/htmlsingle/#build-image">Create an OCI image</a>

<a href="https://docs.spring.io/spring-boot/docs/2.7.15/reference/htmlsingle/index.html#web">Spring Web</a>

<a href="https://www.mongodb.com/compatibility/spring-boot">Spring Data MongoDB</a>
