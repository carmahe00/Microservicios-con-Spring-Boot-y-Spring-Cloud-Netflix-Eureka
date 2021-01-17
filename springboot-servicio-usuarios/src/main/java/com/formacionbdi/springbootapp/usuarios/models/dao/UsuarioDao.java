package com.formacionbdi.springbootapp.usuarios.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.formacionbdi.springbootapp.usuarios.models.entity.Usuario;



/**
 * 
 * @author juan
 * @RepositoryRestResource para acceder a este respositorio desde otra app es
 *                         con la ruta usuarios
 */
@RepositoryRestResource(path="usuarios")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long> {
	
	/**
	 * @RestResource renombra la ruta para acceder a este recurso
	 * @param username nombre usuario renombrado
	 * @return usuario
	 */
	@RestResource(path="buscar-username")
	public Usuario findByUsername(@Param("username") String username);

	@Query("select u from Usuario u where u.username=?1")
	public Usuario obtenerPorUsername(String username);
}
