package cmcEntityTests;

import static org.junit.Assert.*;


	import entities.*;
	import org.junit.Before;
	import org.junit.Test;

	public class PersonTest {

		@Before
		public void setUp() throws Exception {
			Person p = new Person();
		}
		
		@Test
		public void testCreatePerson() {
			Person p = new Person();
			assertTrue("Person p is not null", !(p == null));
		}

	}


