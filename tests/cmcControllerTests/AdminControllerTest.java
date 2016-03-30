package cmcControllerTests;

import static org.junit.Assert.*;


	import entities.*;
	import controllers.*;
	import org.junit.Before;
	import org.junit.Test;

	public class AdminControllerTest {

		@Before
		public void setUp() throws Exception {
			Admin a = new Admin();
			AdminController controller = new AdminController(a);
		}
		
		@Test
		public void test() {
			//TODO
		}

	}


