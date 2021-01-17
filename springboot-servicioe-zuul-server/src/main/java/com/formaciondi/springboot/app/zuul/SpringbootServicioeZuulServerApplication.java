package com.formaciondi.springboot.app.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 
 * @author juan
 * @EnableEurekaClient indica que es cliente
 * @EnableZuulProxy puerta de enalce de los microservicios
 */
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class SpringbootServicioeZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioeZuulServerApplication.class, args);
	}

}
