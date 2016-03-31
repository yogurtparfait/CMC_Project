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

		@Test
		public void testGetters(){
			Person p= new Person("first name","last name","username","password",isAdmin);
			
			assertTrue("first name works", p.getFirstName().equals("first name"));
			assertTrue("last name works", p.getLastName().equals("last name"));
			assertTrue("username works", p.getUsername().equals("username"));
			assertTrue("password works", p.getPassword().equals("password"));	
			//assertTrue("this is an admin",p.getIsAdmin())
			
		}
		
		@Test 
		public void testSetters(){
			Person p = new Person("first name","last name","username","password",isAdmin);
			
			p.setFirstName("fname");
			p.setLastName("lname");
			p.setUsername("username1");
			p.setPassword("password1");
			
			assertTrue("first name works", p.getFirstName().equals("fname"));
			assertTrue("last name works", p.getLastName().equals("lname"));
			assertTrue("username works", p.getUsername().equals("username1"));
			assertTrue("password works", p.getPassword().equals("password1"));
			
		}

	}


