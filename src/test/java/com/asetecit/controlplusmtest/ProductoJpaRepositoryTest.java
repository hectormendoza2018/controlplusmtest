package com.asetecit.controlplusmtest;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.asetecit.controlplusmtest.core.Categoria;
import com.asetecit.controlplusmtest.core.Producto;
import com.asetecit.controlplusmtest.repository.ProductoJpaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest	
@SpringBootTest(classes = { AppContextTest.class })
@ActiveProfiles("test")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductoJpaRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ProductoJpaRepository productoRepository;

	@Autowired
	protected Environment env;

	private Categoria cat;

	// write test cases here

	@Before
	public void createCategory() {
		cat = new Categoria("NUEVA2");
		entityManager.persist(cat);
	}

	@Test
	public void whenFindByName_thenReturnEmployee() {

		// given
		Producto producto = new Producto.Build().withNombre("Bayer").withActivo(true).withCategoria(cat).withCup("1234")
				.withPrecio(new BigDecimal(10)).build();
		entityManager.persist(producto);
		// entityManager.flush();

		// when
		Producto found = productoRepository.findByNombre("Bayer");

		// then
		assertThat(found.getNombre()).isEqualTo(producto.getNombre());
	}

	@Test
	public void whenDeleteFile_thenReturnNull() {

		// given

		Producto producto = new Producto.Build().withNombre("Bayer").withActivo(true).withCategoria(cat).withCup("1234")
				.withPrecio(new BigDecimal(10)).build();
		entityManager.persist(producto);
		// entityManager.flush();

		productoRepository.deleteById(1);

		// when
		Producto found = productoRepository.findByNombre("Bayer");

		// then
		assertThat(found == null);
	}

	@Test
	public void whenSave_thenReturnIdentity() {

		// given
		Producto producto = new Producto.Build().withNombre("Mazola").withActivo(true).withCategoria(cat)
				.withCup("1234").withPrecio(new BigDecimal(10)).build();
		entityManager.persist(producto);
		// entityManager.flush();

		// when
		Producto found = productoRepository.findById(1).get();

		// then
		assertThat(found != null);
	}

}
