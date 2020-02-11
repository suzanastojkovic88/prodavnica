package prodavnica.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prodavnica.dto.DokumentDTO;

public class DokumentControllerTest {

	@Before
	public void testSetup() {
	}

	@Test
	public void testGetAll() {
		List<DokumentDTO> dokumenti = new ArrayList<>();
		assertNotNull("getAll", dokumenti);
	}

	@Test
	public void testGetOne() {
		DokumentDTO dokument = new DokumentDTO();
		assertNotNull("getOne", dokument);
	}

	@Test
	public void testAdd() {
		DokumentDTO dokument = new DokumentDTO();
		assertNotNull("add", dokument);
	}

	@Test
	public void testEdit() {
		DokumentDTO dokument = new DokumentDTO();
		assertNotNull("edit", dokument);
	}

	@Test
	public void testDelete() {
		assertTrue("delete", true);
	}

	@After
	public void testCleanup() {
	}
	
}
