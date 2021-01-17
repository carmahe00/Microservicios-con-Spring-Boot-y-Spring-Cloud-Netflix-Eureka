package com.formacionbdi.springbootapp.usuarios;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.formacionbdi.springbootapp.usuarios.models.entity.Role;
import com.formacionbdi.springbootapp.usuarios.models.entity.Usuario;




@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{

	/**
	 * @param config expone los id de las clases
	 */
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Usuario.class, Role.class);
	}

	
}
