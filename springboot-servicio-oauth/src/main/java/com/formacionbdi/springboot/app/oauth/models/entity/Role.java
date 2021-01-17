package com.formacionbdi.springboot.app.oauth.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length =  30)
	private String nombre;
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "roles")
	private List<Usuario> usuarios;
}
