package com.asetecit.controlplusmtest.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asetecit.controlplusmtest.dto.ExistenciaDto;
import com.asetecit.controlplusmtest.repository.ExistenciaRepository;

@RestController
@RequestMapping("/existences")
public class ExistenciaController {

	private static final Logger log = LoggerFactory.getLogger(ExistenciaController.class);

	ExistenciaRepository repository;

	@Autowired
	public ExistenciaController(ExistenciaRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/list")
	public Collection<ExistenciaDto> list() {

		return repository.listar().stream().map(item -> new ExistenciaDto(item)).collect(Collectors.toList());
	}

	@PostMapping("/add")
	public ExistenciaDto add(@Valid @RequestBody ExistenciaDto existence) {

		log.debug("adding existence {}", existence);
		return new ExistenciaDto(repository.agregar(existence.toEntity()));
	}

	@PostMapping("/update")
	public ExistenciaDto update(@Valid @RequestBody ExistenciaDto existence) {

		log.debug("Updating existence {}", existence);
		return new ExistenciaDto(repository.actualizar(existence.toEntity()));
	}

}
