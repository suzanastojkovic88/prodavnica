package prodavnica.controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	RobaControllerTest.class, 
	DokumentControllerTest.class, 
	StavkaDokumentaControllerTest.class})
public class AllTestsController {

}
