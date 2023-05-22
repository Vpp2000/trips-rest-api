# DOCUMENTACIÓN GENERAL DEL PROYECTO

## ESTRUCTURA DE CARPETAS
La estructura de carpetas puede apreciarse en la siguiente imagen:
![Estructura de carpetas](/home/victor/Escritorio/workspace/java stuff/trips-rest-api/docs/files/folders.png)
- **api**: esta carpeta contiene los controladores, repositorios y servicios que dan vida a la API. Estos se explicarán luego con más detalle.
- **config**: esta carpeta contiene clases que sirven para configurar nuestra API.
- **documents**: esta carpeta viena a contener las clases que representan las colecciones de MongoDb
- **dtos**: esta carpeta contiene clases de propósito general que nos sirven para empaquetar diversos objetos.
- **exceptions**: esta carpeta nos permite definir excepciones más personalisadas
- **utils**: esta carpeta nos permite definir clases con métodos para resolver determinadas tareas. En este caso solo contiene una clase para el manejo de GeoJsons.

## FUNCIONAMIENTO GENERAL DE LA API
### COMPONENTES GENERALES DE LA API
![Diagrama de la API](/home/victor/Escritorio/workspace/java stuff/trips-rest-api/docs/files/backend-api.drawio.png)
### MANEJO DE ERRORES DE LA API
![Reaccion de la api ante errores](/home/victor/Escritorio/workspace/java stuff/trips-rest-api/docs/files/backend_exceptions_handler.drawio.png)
