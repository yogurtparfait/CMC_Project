package cmcControllerTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdminControllerTest.class, DBControllerTest.class,
		FunctionalityTest.class, PersonControllerTest.class,
		SearchControllerTest.class, UserControllerTest.class })
public class AllControllerTests {

}
