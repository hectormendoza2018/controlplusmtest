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

import com.asetecit.controlplusmtest.core.Sucursal;
import com.asetecit.controlplusmtest.repository.SucursalRepository;

@RestController
@RequestMapping("/branchs")
public class SucursalController {

	private static final Logger log = LoggerFactory.getLogger(SucursalController.class);

	SucursalRepository repository;

	@Autowired
	public SucursalController(SucursalRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/list")
	public Collection<Sucursal> list() {

		return repository.listar();
	}

	@PostMapping("/add")
	public Sucursal add(@RequestBody Sucursal branch) {

		log.debug("adding branch {}", branch);
		return repository.agregar(branch);
	}

	@PostMapping("/update")
	public Sucursal update(@RequestBody Sucursal branch) {

		log.debug("Updating branch {}", branch);
		return repository.actualizar(branch);
	}
}
