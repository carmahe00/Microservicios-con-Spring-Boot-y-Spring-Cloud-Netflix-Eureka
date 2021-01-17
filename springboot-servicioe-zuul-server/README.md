#Configuración Docker Comandos

Generar el .jar, perno sin verificar, porque la configuración de docker

```
mvn clean package -DskipTests
```
Genera la imagen docker

```
sudo docker build -t servicio-zuul-server:v1 .
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
sudo docker run -p 8090:8090 --network springcloud servicio-zuul-server:v1
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
sudo docker pull mysql:8
```

configutación a la base de datos con usuario y password
```
sudo docker run -p 3306:3306 --name microservicios-mysql8 --network springcloud -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=db_springboot_cloud -d mysql:8
```
