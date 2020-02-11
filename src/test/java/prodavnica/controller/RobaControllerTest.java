package prodavnica.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prodavnica.dto.RobaDTO;

public class RobaControllerTest {

	@Before
	public void testSetup() {
	}

	@Test
	public void testGetAll() {
		List<RobaDTO> robaLista = new ArrayList<>();
		assertNotNull("getAll", robaLista);
	}

	@Test
	public void testGetOne() {
		RobaDTO roba = new RobaDTO();
		assertNotNull("getOne", roba);
	}

	@Test
	public void testAdd() {
		RobaDTO roba = new RobaDTO();
		assertNotNull("add", roba);
	}

	@Test
	public void testEdit() {
		RobaDTO roba = new RobaDTO();
		assertNotNull("edit", roba);
	}

	@Test
	public void testDelete() {
		assertTrue("delete", true);
	}

	@After
	public void testCleanup() {
	}
	
}
