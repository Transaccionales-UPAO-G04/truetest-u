
#Usar una imagen base ligera de openjdk 21 para ejectuar aplicaciones java
FROM openjdk:21-jdk-slim

#defina la cariable del archivo jar
ARG JAR_FILE=target/truetest-u-0.0.1.jar

#copa el archivo jar en el contenedor
COPY ${JAR_FILE} truetest-u.jar


#expone el puerto 8080
EXPOSE 8080

#comando para ejecutar el archivo jar
ENTRYPOINT ["java", "-jar", "truetest-u.jar"]