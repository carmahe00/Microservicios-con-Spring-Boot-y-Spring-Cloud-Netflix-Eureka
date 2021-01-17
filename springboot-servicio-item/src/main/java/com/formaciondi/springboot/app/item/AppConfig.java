package com.formaciondi.springboot.app.item;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	/**
	 * @LoadBalanced busca la mejor instancia disponible
	 * @return registra RestTemplate, es un cliente Rest 
	 */
	@Bean("clienteRest")
	@LoadBalanced
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
}
