package com.formaciondi.springboot.app.item.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formaciondi.springboot.app.item.models.Item;
import com.formaciondi.springboot.app.item.models.Producto;

/**
 * opcion 2 para implementra cliente Rest
 * 
 * @author juan
 *
 */
@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate clienteRest;

	/**
	 * @param clienteRest hace la petición indica el tipo; además convierte Arrays
	 */
	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays
				.asList(clienteRest.getForObject("http://servicio-productos/listar", Producto[].class));

		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("id", id.toString());
		Producto producto = clienteRest.getForObject("http://servicio-productos/ver/{id}", Producto.class,
				pathVariable);
		return new Item(producto, cantidad);
	}

	/**
	 * método para guardar producto .exchange envia y recibe datos la respuesta es
	 * de tipo ResponseEntity
	 * 
	 * @param producto enviado desde el cliente
	 * @return devuelve del ResponseEntity el producto
	 */
	@Override
	public Producto save(Producto producto) {
		HttpEntity<Producto> body = new HttpEntity<Producto>(producto);
		ResponseEntity<Producto> response = clienteRest.exchange("http://servicio-productos/crear", HttpMethod.POST,
				body, Producto.class);
		return response.getBody();
	}

	/**
	 * método para actualizar producto .exchange envia y recibe datos la respuesta
	 * es de tipo ResponseEntity
	 * 
	 * @param producto enviado desde el cliente
	 * @param id       identificador del producto
	 * @return devuelve del ResponseEntity el producto
	 */
	@Override
	public Producto update(Producto producto, Long id) {
		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("id", id.toString());
		HttpEntity<Producto> body = new HttpEntity<Producto>(producto);
		ResponseEntity<Producto> response = clienteRest.exchange("http://servicio-productos/editar/{id}",
				HttpMethod.PUT, body, Producto.class, pathVariable);
		return response.getBody();
	}

	/**
	 * método para eliminar el producto, no se especifica el tipo de petición porque
	 * esta explicitamente
	 */
	@Override
	public void delete(Long id) {
		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("id", id.toString());
		clienteRest.delete("http://servicio-productos/eliminar/{id}", pathVariable);

	}

}
