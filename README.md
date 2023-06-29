# Proyecto de Consulta de Precios - Documentación

Este proyecto es una aplicación/servicio desarrollado en SpringBoot que proporciona un endpoint REST para consultar los precios de productos en una base de datos de comercio electrónico.

## Cómo utilizar el proyecto

Sigue estos pasos para utilizar el proyecto en tu entorno de desarrollo:

1. Clonar el repositorio desde GitHub: [enlace al repositorio](https://github.com/alnav3/AlveaTest).

2. Iniciar el proyecto en tu entorno de desarrollo preferido.

3. Acceder a la URL [http://localhost:8080/swagger-ui/index.html#](http://localhost:8080/swagger-ui/index.html#) para ver la interfaz de Swagger. Desde allí, podrás probar fácilmente el endpoint y consultar los precios de los productos.

4. Para acceder a la base de datos en memoria H2, utiliza la siguiente URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console). Aquí encontrarás la consola de administración de H2, donde podrás consultar la base de datos. Los detalles de conexión son los siguientes:
   - JDBC URL: jdbc:h2:mem:pricesdb
   - Usuario: sa
   - Contraseña: vacía

## Ejemplo de consulta de precios

A continuación, se muestra un ejemplo de cómo realizar una consulta de precios utilizando el endpoint REST:

1. Realizar una solicitud POST a la siguiente URL: `http://localhost:8080/prices`.

2. Utilizar el siguiente cuerpo de solicitud como ejemplo:
   ```json
   {
     "applicationDate": "2020-06-29T10:00:00.000Z",
     "brandId": 1,
     "productId": 35455
   }
   ```
   - `applicationDate`: Fecha y hora de la solicitud en formato ISO 8601.
   - `brandId`: Identificador de la cadena de la marca.
   - `productId`: Identificador del producto.

3. Obtendrás como respuesta los siguientes datos:
   - Identificador del producto.
   - Identificador de la cadena.
   - Tarifa a aplicar.
   - Fechas de aplicación.
   - Precio final a aplicar.
