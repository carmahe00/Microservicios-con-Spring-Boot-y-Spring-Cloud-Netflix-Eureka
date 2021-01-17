#Configuración Docker Comandos

Genera la imagen docker

```
sudo docker build -t servicio-eureka-server:v1 .
```

Mostrar infrmación de la imagen creada
```
docker image
```

crea una red para comunicar los microservicios

```
sudo docker network create springcloud
```

corre docket (nombre de contenedor, nombre de la red creada, nombre de la imagen)

```
sudo docker run -p 8761:8761 --name servicio-eureka-server --network springcloud servicio-eureka-server:v1
```

listar todos imagenes creadas
```
sudo docker ps -a
```

muestra consola
```
sudo docker logs servicio-eureka-server
```