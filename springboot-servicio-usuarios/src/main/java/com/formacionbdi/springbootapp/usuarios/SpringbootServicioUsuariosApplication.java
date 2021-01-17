package com.formacionbdi.springbootapp.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * 
 * @author juan
 * @EntityScan busca la clase Producto que esta en paquete servicio-commons
 */
//@EntityScan({"com.formacionbdi.springbootapp.usuarios.commons.models.entity"})
@SpringBootApplication
public class SpringbootServicioUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioUsuariosApplication.class, args);
	}

}
