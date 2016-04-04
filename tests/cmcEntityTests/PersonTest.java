package cmcEntityTests;

import static org.junit.Assert.*;


	import entities.*;
	import org.junit.Before;
	import org.junit.Test;

	public class PersonTest {
		private Person p;
		

		@Before
		public void setUp() throws Exception {
			p = new Person();
		}
		
		@Test
		public void testCreatePerson() {
			assertTrue("Person p is not null", !(p == null));
		}

		
		@Test 
		public void testSetters(){
			
			p.setFirstName("fname");
			p.setLastName("lname");
			p.setUsername("username1");
			p.setPassword("password1");
			p.setIsAdmin(true);
			
			assertTrue("first name works", p.getFirstName().equals("fname"));
			assertTrue("last name works", p.getLastName().equals("lname"));
			assertTrue("username works", p.getUsername().equals("username1"));
			assertTrue("password works", p.getPassword().equals("password1"));
			assertTrue("isAdmin", (p.getIsAdmin() == true));
			
			
		}
		
		public void testGetters(){
			
			p.setFirstName("fname");
			p.setLastName("lname");
			p.setUsername("username1");
			p.setPassword("password1");
			p.setIsAdmin(true);
			
			assertTrue("first name works", p.getFirstName().equals("fname"));
			assertTrue("last name works", p.getLastName().equals("lname"));
			assertTrue("username works", p.getUsername().equals("username1"));
			assertTrue("password works", p.getPassword().equals("password1"));
			assertTrue("isAdmin", (p.getIsAdmin() == true));
			
		}
		

	}


