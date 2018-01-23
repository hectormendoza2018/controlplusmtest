package com.asetecit.controlplusmtest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asetecit.controlplusmtest.core.Producto;
import com.asetecit.controlplusmtest.repository.ProductoRepository;

@RestController
@RequestMapping("/products")
public class ProductoController {

	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);

	ProductoRepository repository;

	public ProductoController(ProductoRepository repository) {
		this.repository = repository;
	}

	@PostMapping("/add")
	public Producto add(@RequestBody Producto product) {

		log.debug("adding producto {}", product);
		return repository.agregar(product);
	}

	@PostMapping("/update")
	public Producto update(@RequestBody Producto product) {

		log.debug("Updating producto {}", product);
		return repository.actualizar(product);
	}

}
