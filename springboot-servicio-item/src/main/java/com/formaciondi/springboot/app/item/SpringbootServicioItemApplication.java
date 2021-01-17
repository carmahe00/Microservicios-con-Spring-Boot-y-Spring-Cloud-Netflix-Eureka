package com.formaciondi.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 * @author juan
 * @EnableFeignClients habilita clientes Feign
 * @RibbonClient indica el nombre del microservicio
 * @EnableEurekaClient indica que es cliente de eureka
 * @EnableCircuitBreaker se encarga de manejar posbles errores(latencia, time
 *                       out, Habilita Hystrix)
 * @EntityScan busca la clase Producto que esta en paquete servicio-commons
 * @EnableAutoConfiguration sobreescribir el método, desactiva la
 *                          autoconfiguración del datasource
 */
@EnableCircuitBreaker
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
//@EntityScan({ "com.formacionbdi.springbootapp.commons.models.enetity" })
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class SpringbootServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioItemApplication.class, args);
	}

}
