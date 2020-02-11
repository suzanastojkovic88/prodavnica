package prodavnica.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	RobaServiceTest.class, 
	DokumentServiceTest.class, 
	StavkaDokumentaServiceTest.class})
public class AllTestsService {

}
