FROM openjdk:12
VOLUME /tmp
EXPOSE 8090
ADD ./target/springboot-servicioe-zuul-server-0.0.1-SNAPSHOT.jar zull-productos.jar
ENTRYPOINT ["java","-jar","/zull-productos.jar"]