package cmcEntityTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entities.*;

public class AdminTest {
	private Admin a;
	
	@Before
	public void setUp() throws Exception {
		a = new Admin();
	}
	
	@Test
	public void testCreateAdmin() {
		assertTrue("Admin a is not null", !(a == null));
	}
	
	@Test
	public void testSetters() {
		
		a.setFirstName("fname");
		a.setLastName("lname");
		a.setUsername("username1");
		a.setPassword("password1");
		a.setIsAdmin(true);
		
		assertTrue("first name works", a.getFirstName().equals("fname"));
		assertTrue("last name works", a.getLastName().equals("lname"));
		assertTrue("username works", a.getUsername().equals("username1"));
		assertTrue("password works", a.getPassword().equals("password1"));
		assertTrue("this is an admin",a.getIsAdmin() == true);
	}


}

