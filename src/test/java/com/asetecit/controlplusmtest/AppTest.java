package com.asetecit.controlplusmtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AppContextTest.class })
@DataJpaTest
@ActiveProfiles({ "test" })
public class AppTest {

	@Test
	public void propertyExist() {

	}

}
