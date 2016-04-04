package cmcControllerTests;

import static org.junit.Assert.*;


	import entities.*;
	import interfaces.*;
	import controllers.*;
	import org.junit.Before;
	import org.junit.Test;

	public class PersonControllerTest {
		PersonController controller;
		PersonController controller2;
		
		@Before
		public void setUp() throws Exception {
			Person p = new Person();
			controller = new PersonController(p);
			controller2 = new PersonController();
		}
		
		@Test
		public void testConstructor() {
			assertTrue("controller is null",controller != null);
			assertTrue("controller is null",controller2 != null);
		}

		@Test
		public void TestLogOn(){

			PersonUI ui = controller.logOn("ImadUser", "Edited", true);
			assertTrue("is admin", ui instanceof AdminUI);
			
			//PersonUI ui2 = controller2.logOn("juser", "user", true);
			//assertTrue("is user", ui instanceof UserUI);

		}
		
		@Test 
		public void testLogOnBadPassword() {
			PersonUI ui = controller.logOn("ImadUser", "wrong", true);
		}
		
		@Test 
		public void testLogOnBadUserName(){
			PersonUI ui = controller.logOn("NotAUser", "NotAPassword", false);
		}
		
		
	}


