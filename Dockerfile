FROM ubuntu
##instalar nginx
RUN apt-get update
RUN apt-get install -y nginx
EXPOSE 80

FROM openjdk:17.0.2-jdk
##Copiar el paquete jar file dentro de nuestra imagen
COPY target/app.jar /api.jar


##Definir los valores de las variables de entorno
#ENV $MONGO_URI="mongodb+srv://libreria:libreria@cluster0.luvjnen.mongodb.net/librosdb"
#ENV $MONGO_AUTH=admin
#ENV $MONGO_PORT=27017
#ENV $TOMCAT_PORT=8084

##Ejecutar el comando del compilado para su deploy
CMD ["java", "-jar", "/api.jar"]
