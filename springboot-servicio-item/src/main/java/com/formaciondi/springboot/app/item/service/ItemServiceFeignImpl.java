package com.formaciondi.springboot.app.item.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formaciondi.springboot.app.item.clientes.ProductoClienteRest;
import com.formaciondi.springboot.app.item.models.Item;
import com.formaciondi.springboot.app.item.models.Producto;


/**
 * opción 1 para impletar cliente Feign(microservicio)
 * @author juan
 *
 */
@Service("serviceFeign")
public class ItemServiceFeignImpl implements ItemService {

	@Autowired
	private ProductoClienteRest clienteFeign;
	
	
	@Override
	public List<Item> findAll() {
		return clienteFeign.listar().stream().map( p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.detalle(id), cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		return clienteFeign.crear(producto);
	}

	@Override
	public Producto update(Producto producto, Long id) {
		return clienteFeign.update(producto, id);
	}

	@Override
	public void delete(Long id) {
		clienteFeign.eliminar(id);
	}

}
