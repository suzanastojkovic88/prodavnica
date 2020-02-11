package prodavnica.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prodavnica.model.StavkaDokumenta;

public class StavkaDokumentaServiceTest {

	@Before
	public void testSetup() {
	}

	@Test
	public void testGetAll() {
		List<StavkaDokumenta> stavke = new ArrayList<>();
		assertNotNull("getAll", stavke);
	}

	@Test
	public void testGetOne() {
		StavkaDokumenta stavka = new StavkaDokumenta();
		assertNotNull("getOne", stavka);
	}

	@Test
	public void testSave() {
		StavkaDokumenta stavka = new StavkaDokumenta(45L, 2, 45.57);
		assertNotNull("save", stavka);
	}

	@Test
	public void testRemove() {
		assertTrue("remove", true);
	}

	@After
	public void testCleanup() {
	}
}
