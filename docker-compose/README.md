comando para levantar los servicios(primero configuración, eureka y mysql)
```
sudo docker-compose up -d config-server
sudo docker-compose up -d servicio-eureka-server
sudo docker-compose up -d microservicios-mysql8
```

luego levanta cualquier servicio

```
sudo docker-compose up -d servicio-productos
```