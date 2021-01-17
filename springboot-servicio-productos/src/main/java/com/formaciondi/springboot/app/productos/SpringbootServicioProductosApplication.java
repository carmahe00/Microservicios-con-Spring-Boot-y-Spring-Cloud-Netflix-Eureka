package com.formaciondi.springboot.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 * @author juan
 * @EnableEurekaClient indica que es cliente de eureka
 * @EntityScan busca la clase Producto que esta en paquete servicio-commons
 */
@SpringBootApplication
@EnableEurekaClient
//@EntityScan({"com.formacionbdi.springbootapp.commons.models.enetity"})
public class SpringbootServicioProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioProductosApplication.class, args);
	}

}
