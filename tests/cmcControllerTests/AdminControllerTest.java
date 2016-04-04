package cmcControllerTests;

import static org.junit.Assert.*;


	import entities.*;
	import controllers.*;
	import org.junit.Before;
	import org.junit.Test;

	public class AdminControllerTest {
		Admin a;
		AdminController controller;
		
		@Before
		public void setUp() throws Exception {
			a = new Admin();
			controller = new AdminController(a);
		}
		
		@Test
		public void testConstructor() {
			assertTrue("AdminController's controller works",!(controller==null));
		}
		
		@Test
		public void testAddPerson(){

			assertTrue("controller is an admin", controller.addPerson("firstName", "lastName", "password", "username", 'a')==false);
			assertTrue("controller is an admin", controller.addPerson("firstName", "lastName", "password", "username", 'u')==false);
			assertFalse("controller is an admin", controller.addPerson("firstName", "lastName", "password", "username", 'c')==true);
		}	


	}


