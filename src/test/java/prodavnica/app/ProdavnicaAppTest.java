package prodavnica.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ProdavnicaAppTest extends TestCase {

	public ProdavnicaAppTest(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(ProdavnicaAppTest.class);
	}
	
	public void testProdavnicaApp() {
		assertTrue(true);
	}
	
}
