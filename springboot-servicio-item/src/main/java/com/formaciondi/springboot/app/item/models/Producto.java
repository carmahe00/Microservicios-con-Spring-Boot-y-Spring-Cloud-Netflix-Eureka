package com.formaciondi.springboot.app.item.models;

import java.io.Serializable;
import java.util.Date;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private Double precio;
	
	
	private Date createAt;
	
	
}
