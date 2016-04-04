package cmcControllerTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import entities.*;
import controllers.*;


public class FunctionalityTest {
	DBController controller;
	User u;
	School s;
	Admin a;

	@Before
	public void setUp() throws Exception {
		controller = new DBController();
		//u = new User();
		//s = new School();
		//a = new Admin();
	}

	@Test
	public void test() {
		
	}

}
