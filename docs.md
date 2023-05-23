# DOCUMENTACIÓN GENERAL DEL PROYECTO
## RUTAS DE LA API
- **/swagger-ui.html**: interfaz de la documentación de la API
- **/trip**:
  - Mediante una llamada GET lista de viajes paginados (puse 22 documentos en MongoDb Atlas). Los parámetros adicionales se pueden ver en la documentación swagger
  - Mediante POST Permite la creación de un nuevo viaje
- **/trip/{tripId}**:
  - Mediante llamada GET permite obtener uno de los viajes en MongoDb Atlas en base a su id
  - Mediante llamada PUT permite actualizar un viaje en base a su id.
-  **/trip/count**: 
   - Permite contar todos los documentos o cuenta en base a un país o una ciudad dependendo de los parámetros que se le pasen.
- **/trip/statistics**:
    - Permite obtener el total de paises y los paises por una ciudad determinada y por un pais determinado todos a la vez (usualmente estas estadísticas suelen pedirse todas al mismo tiempo, por eso hice este endpoint)
## ESTRUCTURA DE CARPETAS
La estructura de carpetas puede apreciarse en la siguiente imagen:
<br>
![Estructura de carpetas](https://github.com/Vpp2000/trips-rest-api/assets/48797063/35e5ae66-d6ad-4199-a1a9-46a864fe0ed0)
- **api**: esta carpeta contiene los controladores, repositorios y servicios que dan vida a la API. Estos se explicarán luego con más detalle.
- **config**: esta carpeta contiene clases que sirven para configurar nuestra API.
- **documents**: esta carpeta viena a contener las clases que representan las colecciones de MongoDb
- **dtos**: esta carpeta contiene clases de propósito general que nos sirven para empaquetar diversos objetos.
- **exceptions**: esta carpeta nos permite definir excepciones más personalisadas
- **utils**: esta carpeta nos permite definir clases con métodos para resolver determinadas tareas. En este caso solo contiene una clase para el manejo de GeoJsons.

## FUNCIONAMIENTO GENERAL DE LA API
### COMPONENTES GENERALES DE LA API
Las 3 principales capas de la API son:
- Controladores: reciben los HTTP requests de los clientes
- Services: manejan la lógica de negocio de la API
- Repositorios: interactúan con la base de datos
![Diagrama de la API](https://github.com/Vpp2000/trips-rest-api/assets/48797063/cae4ac9c-d4a8-4f75-9449-c92583ee1729)
### MANEJO DE ERRORES DE LA API
![Reaccion de la api ante errores](https://github.com/Vpp2000/trips-rest-api/assets/48797063/c091da8a-a423-4f34-9e79-b20b4e69f8b4)


## MANEJO DE RAMAS
### GITHUB FLOW
El siguiente diagrama ilustra el funcionamiento de Github Flow:
![Github Flow](https://github.com/Vpp2000/trips-rest-api/assets/48797063/be36ae19-61fb-47ca-92ec-bf1978f0ad9b)
Básicamente el funcionamiento es el siguiente:
- Tenemos solamente una rama **main**.
- Si se tiene una nueva funcionalidad o una reparación se crea una nueva rama.
- Se hacen los cambios y se suben.
- Se hace un Pull Request (PR).
- Revisión del PR.
- Despliegue
- Merge a **main**