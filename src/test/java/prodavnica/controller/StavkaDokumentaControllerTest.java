package prodavnica.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prodavnica.dto.StavkaDokumentaDTO;

public class StavkaDokumentaControllerTest {

	@Before
	public void testSetup() {
	}

	@Test
	public void testGetAll() {
		List<StavkaDokumentaDTO> stavke = new ArrayList<>();
		assertNotNull("getAll", stavke);
	}

	@Test
	public void testGetOne() {
		StavkaDokumentaDTO stavka = new StavkaDokumentaDTO();
		assertNotNull("getOne", stavka);
	}

	@Test
	public void testAdd() {
		StavkaDokumentaDTO stavka = new StavkaDokumentaDTO();
		assertNotNull("add", stavka);
	}

	@Test
	public void testEdit() {
		StavkaDokumentaDTO stavka = new StavkaDokumentaDTO();
		assertNotNull("edit", stavka);
	}

	@Test
	public void testDelete() {
		assertTrue("delete", true);
	}

	@After
	public void testCleanup() {
	}
	
}
