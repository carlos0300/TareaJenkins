# INSTRUCCIONES
## JHON STEWAR NUÑEZ CASTELLANOS - 2171066
## CARLOS EDUARDO BECERRA LIZARAZO - 2171844

SE REALIZARON LAS RESPECTIVAS PRUEBAS AUTOMATIZADAS EN JUNIT PARA CADA UNO DE LOS MÉTODOS

Para añadir motos con el método POST

por favor ejecutar con el método POST para tener registros en la memoria (puerto 8081)

localhost:8081/addMoto?id=01&marca=Honda&nombre=Cb 110&year=2021&color=Negra
localhost:8081/addMoto?id=02&marca=Honda&nombre=Cb 160&year=2021&color=Naranja
localhost:8081/addMoto?id=03&marca=Honda&nombre=Cb 190&year=2020&color=Negra
localhost:8081/addMoto?id=04&marca=Yamaha&nombre=Fz&year=2020&color=Azul
localhost:8081/addMoto?id=05&marca=Yamaha&nombre=Ybr&year=2019&color=Rojo

Para consultas con el método GET

por defecto en esta ejecución se muestran todas las motos que se encuentran registradas

localhost:8081/getMoto

Adicionalmente podemos pasarle el parámetro id para filtrar las motos por su id

localhost:8081/getMoto?id=01

Para editar con el método PUT

Para editar la información de una moto se debe pasar el id y los demás atributos

localhost:8081/editMoto?id=02&marca=Honda&nombre=Cb 115&year=2021&color=R

Para eliminar con el método DELETE

Al eliminar es necesario pasar como parámetro el id de la moto a eliminar

localhost:8081/deleteMoto?id=01
