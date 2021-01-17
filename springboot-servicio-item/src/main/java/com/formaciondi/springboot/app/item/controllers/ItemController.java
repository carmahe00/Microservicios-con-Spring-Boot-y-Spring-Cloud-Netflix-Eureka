package com.formaciondi.springboot.app.item.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formaciondi.springboot.app.item.models.Item;
import com.formaciondi.springboot.app.item.models.Producto;
import com.formaciondi.springboot.app.item.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author juan
 * @RefreshScope actualiza el contexto de spring(las variables del archivo de propiedades)
 */
@RefreshScope
@RestController
@Slf4j
public class ItemController {

	@Autowired
	private Environment env;
	
	@Autowired
	@Qualifier("serviceFeign")
	private ItemService itemService;
	
	@Value("${configuracion.texto}")
	private String texto;
	
	@GetMapping("/listar")
	public List<Item> listar(){
		return itemService.findAll();
	}
	
	/**
	 * 
	 * @HystrixCommand ejecuta un método alternativo en caso de alguna excepción o fallo
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "metodoAlternativo")
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
	
	/**
	 * 
	 * @param id identificador en caso de fallo
	 * @param cantidad en caso de fallo
	 * @return regresa un nuevo Item
	 */
	public Item metodoAlternativo(Long id, Integer cantidad) {
		Item item = new Item();
		Producto producto = new Producto();
		item.setCantidad(cantidad);
		
		producto.setNombre("Camara Sony(Método alternativo)");
		producto.setPrecio(500.00);
		item.setProducto(producto);
		return item;
	}
	
	@GetMapping("/obtener-config")
	public ResponseEntity<?> obtenerConfigutacion(@Value("${server.port}") String puerto){
		log.info(texto);
		
		Map<String, String> json= new HashMap<String, String>();
		json.put("texto", texto);
		json.put("puerto", puerto);
		
		//Vaida que tenga profiles
		if(env.getActiveProfiles().length>0 && env.getActiveProfiles()[0].equals("dev")) {
			json.put("autor.nombre", env.getProperty("configuracion.autor.nombre"));
			json.put("autor.email", env.getProperty("configuracion.autor.email"));
		}
		
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crear(@RequestBody Producto producto) {
		return itemService.save(producto);
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editar(@RequestBody Producto producto,@PathVariable Long id) {
		return itemService.update(producto, id);
	}
	
	/**
	 * 
	 * @param id identificador del producto
	 */
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		itemService.delete(id);
	}
}
