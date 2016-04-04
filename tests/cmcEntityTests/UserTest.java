package cmcEntityTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entities.*;

public class UserTest {
	private User u;
	
	@Before
	public void setUp() throws Exception {
		u = new User();
	}
	
	@Test
	public void testConstructors() {
		assertTrue("User is not null", !(u==null));
	}
	
	@Test
	public void testSet(){
		School[] savedSchools = new School[1];
		u.setSavedSchools(savedSchools);
		
		assertTrue("setSavedSchool works", u.getSavedSchools().equals(savedSchools));
		
	}

}
