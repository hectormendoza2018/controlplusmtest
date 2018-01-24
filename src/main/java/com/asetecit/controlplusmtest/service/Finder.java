package com.asetecit.controlplusmtest.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asetecit.controlplusmtest.core.Producto;
import com.asetecit.controlplusmtest.repository.ProductoRepository;

@Service
public class Finder implements SearchService {

	ProductoRepository repository;

	@Autowired
	public Finder(ProductoRepository repository) {
		this.repository = repository;
	}

	private static final Logger log = LoggerFactory.getLogger(Finder.class);

	@Override
	public Collection<Producto> searchProduct(String query, String type) {

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
