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
		public void test() {
			//TODO
		}

	}


