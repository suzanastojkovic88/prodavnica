package prodavnica.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prodavnica.model.Roba;

public class RobaServiceTest {

	@Before
	public void testSetup() {
	}

	@Test
	public void testGetAll() {
		List<Roba> robaLista = new ArrayList<>();
		assertNotNull("getAll", robaLista);
	}

	@Test
	public void testGetOne() {
		Roba roba = new Roba();
		assertNotNull("getOne", roba);
	}

	@Test
	public void testSave() {
		Roba roba = new Roba(5L, "Monitor");
		assertNotNull("save", roba);
	}

	@Test
	public void testRemove() {
		assertTrue("remove", true);
	}

	@After
	public void testCleanup() {
	}
}
