package com.asetecit.controlplusmtest.service;

import java.util.Collection;

import com.asetecit.controlplusmtest.core.Producto;

public interface SearchService {

	Collection<Producto> searchProduct(String query, String type);

	Collection<Producto> searchProduct(boolean active);

}
