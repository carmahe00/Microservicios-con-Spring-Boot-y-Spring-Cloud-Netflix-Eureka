#Configuración Docker Comandos

Genera la imagen docker

```
sudo docker build -t servicio-usuarios:v1 .
```

Mostrar infrmación de la imagen creada
```
docker images
```

crea una red para comunicar los microservicios

```
sudo docker network create springcloud
```

corre docket (nombre de contenedor, nombre de la red creada, nombre de la imagen)

```
sudo docker run -P --network springcloud servicio-usuarios:v1
```

listar todos imagenes creadas
```
sudo docker ps -a
```

muestra consola
```
sudo docker logs servicio-eureka-server
```

instalación a l abase de datos
```
sudo docker pull postgres:12-alpine
```

configutación a la base de datos con usuario y password
```
sudo docker run -p 5432:5432 --name microservicios-posgres12 --network springcloud -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -e POSTGRES_DB=db_springboot_cloud -d postgres:12-alpine
```