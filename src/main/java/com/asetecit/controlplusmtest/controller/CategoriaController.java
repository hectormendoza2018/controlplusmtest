package com.asetecit.controlplusmtest.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asetecit.controlplusmtest.core.Categoria;
import com.asetecit.controlplusmtest.repository.CategoriaRepository;

@RestController
@RequestMapping("/categories")
public class CategoriaController {

	private static final Logger log = LoggerFactory.getLogger(CategoriaController.class);

	CategoriaRepository repository;

	@Autowired
	public CategoriaController(CategoriaRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/list")
	public Collection<Categoria> list() {

		log.debug("Listing all categories");
		return repository.listar();
	}

	@PostMapping("/add")
	public Categoria add(@RequestBody Categoria cat) {

		log.debug("adding category {}", cat);
		return repository.agregar(cat);
	}

	@PostMapping("/update")
	public Categoria update(@RequestBody Categoria cat) {

		log.debug("Updating category {}", cat);
		return repository.actualizar(cat);
	}

}
