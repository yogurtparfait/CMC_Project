package cmcControllerTests;

import static org.junit.Assert.*;


	import entities.*;
	import controllers.*;
	import org.junit.Before;
	import org.junit.Test;

	public class UserControllerTest {
		User u;
		UserController controller;
		@Before
		public void setUp() throws Exception {
			u = new User();
			controller = new UserController(u);
		}
		
		@Test
		public void test() {
			//TODO
		}

	}


