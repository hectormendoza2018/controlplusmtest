package com.asetecit.controlplusmtest.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/search")
	public Collection<Producto> search(@RequestParam(defaultValue = "") String query,
			@RequestParam(required = false, defaultValue = "") String type) {

		log.debug("Finding producto by {} with query [{}]", type, query);
		Collection<Producto> products = new ArrayList<>();

		switch (type) {
		case "category":
			try {
				products.addAll(repository.buscarPorCategoria(Integer.parseInt(query)));
			} catch (NumberFormatException e) {

			}
			break;
		case "cup":
			products.add(repository.buscarPorCup(query));
			break;
		case "price":
			try {
				products.addAll(repository.buscarPorPrecio(new BigDecimal(query)));
			} catch (NumberFormatException e) {

			}
			break;
		default:// by nombre
			products.add(repository.buscar(query));
			break;
		}

		return products;
	}

}
