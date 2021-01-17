#Configuración Docker Comandos

Genera la imagen docker

```
sudo docker build -t config-server:v1 .
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
sudo docker run -p 8888:8888 --name config-server --network springcloud config-server:v1
```

listar todos imagenes creadas
```
sudo docker ps -a
```