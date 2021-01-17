package com.formacionbdi.springbootapp.usuarios.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 20)
	private String username;

	@Column(length = 60)
	private String password;

	private Boolean enabled;
	private String nombre;
	private String apellido;

	@Column(unique = true, length = 100)
	private String email;

	/*
	 * @JoinTable configura la tabla intermedia(nombre, nombre llave foranea de la
	 * clase dueña de la anotacion, nombre llave foranea de la otra clase, el
	 * usuario_id y role_id en conjunto deben ser unicos)
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "usuario_id", "role_id" }) })
	private List<Role> roles;
	
	private Integer intentos;
}
