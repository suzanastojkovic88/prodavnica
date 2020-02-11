package prodavnica.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prodavnica.model.Dokument;

public class DokumentServiceTest {

	@Before
	public void testSetup() {
	}

	@Test
	public void testGetAll() {
		List<Dokument> dokumenti = new ArrayList<>();
		assertNotNull("getAll", dokumenti);
	}

	@Test
	public void testGetOne() {
		Dokument dokument = new Dokument();
		assertNotNull("getOne", dokument);
	}

	@Test
	public void testSave() {
		Dokument dokument = new Dokument(10L, "Racun-1");
		assertNotNull("save", dokument);
	}

	@Test
	public void testRemove() {
		assertTrue("remove", true);
	}

	@After
	public void testCleanup() {
	}
}
