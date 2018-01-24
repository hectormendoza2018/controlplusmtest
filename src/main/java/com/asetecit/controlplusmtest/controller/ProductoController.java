package com.asetecit.controlplusmtest.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asetecit.controlplusmtest.core.Producto;
import com.asetecit.controlplusmtest.repository.ProductoRepository;
import com.asetecit.controlplusmtest.service.SearchService;

@RestController
@RequestMapping("/products")
public class ProductoController {

	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);

	ProductoRepository repository;
	SearchService finder;

	@Autowired
	public ProductoController(ProductoRepository repository, SearchService finder) {
		this.repository = repository;
		this.finder = finder;
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

	@GetMapping("/search")
	public Collection<Producto> search(@RequestParam(defaultValue = "") String query,
			@RequestParam(required = false, defaultValue = "") String type) {

		return finder.searchProduct(query, type);
	}

	@GetMapping("/list")
	public Collection<Producto> search(@RequestParam(required = false) boolean active) {

		return finder.searchProduct(active);
	}

}
