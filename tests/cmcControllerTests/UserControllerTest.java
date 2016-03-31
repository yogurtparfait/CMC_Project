package cmcControllerTests;

import static org.junit.Assert.*;


	import entities.*;
	import controllers.*;
	import org.junit.Before;
	import org.junit.Test;

	public class UserControllerTest {

		@Before
		public void setUp() throws Exception {
			User u = new User();
			UserController controller = new UserController(u);
		}
		
		@Test
		public void test() {
			//TODO
		}

	}


