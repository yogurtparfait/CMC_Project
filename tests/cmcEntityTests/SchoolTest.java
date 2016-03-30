package cmcEntityTests;

import static org.junit.Assert.*;


	import entities.*;
	import org.junit.Before;
	import org.junit.Test;

	public class SchoolTest {

		@Before
		public void setUp() throws Exception {
			

			School s = new School("name","state","location","control",
					1,.5,.5,.5,.5,
					.5,1,.5,
					.5,1,1,1
					);
		}
		
		@Test
		public void test() {
			//TODO
			//assertTrue("Person",p==what)
		}

	}


