package com.formaciondi.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.formaciondi.springboot.app.item.models.Producto;



/**
 * 
 * @author juan
 * @FeignClient indica a donde se conecta(nombre aplicación , dirección url)
 */
@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {

	/**
	 * 
	 * @GetMapping sirve para hacer la petición al controlador del microsercicio producto
	 */
	@GetMapping("/listar")
	List<Producto> listar();
	
	@GetMapping("/ver/{id}")
	Producto detalle(@PathVariable Long id);
	
	@PostMapping("/crear")
	Producto crear(@RequestBody Producto producto);
	
	@PutMapping("/editar/{id}")
	Producto update(@RequestBody Producto producto, @PathVariable Long id);
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id);
}
