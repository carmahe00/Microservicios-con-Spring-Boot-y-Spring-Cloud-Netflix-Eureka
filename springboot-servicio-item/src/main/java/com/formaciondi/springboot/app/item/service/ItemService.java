package com.formaciondi.springboot.app.item.service;

import java.util.List;

import com.formaciondi.springboot.app.item.models.Item;
import com.formaciondi.springboot.app.item.models.Producto;

public interface ItemService {

	List<Item> findAll();
	Item findById(Long id, Integer cantidad);
	Producto save(Producto producto);
	Producto update(Producto producto, Long id);
	void delete(Long id);
}
