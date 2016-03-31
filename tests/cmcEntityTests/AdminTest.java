package cmcEntityTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entities.*;

public class AdminTest {

	@Before
	public void setUp() throws Exception {
		Admin a = new Admin();
	}
	
	@Test
	public void testSetters() {
		//TODO
		Admin a= new Admin("first name","last name","username","password");
		
		a.setFirstName("fname");
		a.setLastName("lname");
		a.setUsername("username1");
		a.setPassword("password1");
		
		assertTrue("first name works", a.getFirstName().equals("fname"));
		assertTrue("last name works", a.getLastName().equals("lname"));
		assertTrue("username works", a.getUsername().equals("username1"));
		assertTrue("password works", a.getPassword().equals("password1"));
	}

}
