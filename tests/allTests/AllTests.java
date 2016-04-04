package allTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cmcControllerTests.AllControllerTests;
import cmcEntityTests.AllEntityTests;

@RunWith(Suite.class)
@SuiteClasses({AllEntityTests.class,AllControllerTests.class})
public class AllTests {

}
