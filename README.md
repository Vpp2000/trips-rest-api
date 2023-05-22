# GUÍA DE EJECUCIÓN

## EJECUCIÓN LOCAL

### Generar ejecutable JAR
- **ES IMPORTANTE CONTAR CON JAVA 17 PARA EJECUTAR EL PROYECTO LOCALMENTE** 
- Ejecutar el siguiente comando en una terminal desde la carpeta raiz del proyecto para generar el JAR:
```shell
./mvnw clean package spring-boot:repackage
```
- El JAR generado se puede ejecutar con el siguiente comando:
```shell
java -jar target/trips-rest-api-0.0.1-SNAPSHOT.jar
```
- Ahora se podrá acceder a la documentación de la API desde el url **localhost:9999/swagger-ui.html**.

## APP DESPLEGADA
- La API está desplegada en el url **trips-rest-api-production.up.railway.app** y se puede acceder a la documentación desde el url **trips-rest-api-production.up.railway.app/swagger-ui.html**
