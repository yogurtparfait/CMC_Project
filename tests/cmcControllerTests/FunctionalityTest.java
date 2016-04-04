package cmcControllerTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import entities.*;
import interfaces.AdminUI;
import interfaces.PersonUI;
import controllers.*;


public class FunctionalityTest {
	DBController controller;
	PersonController pController;
	User u;
	School s;
	Admin a;

	@Before
	public void setUp() throws Exception {

		
		
		//u = new User();
		//s = new School();
		//a = new Admin();
	}

	@Test
	public void testLogon() {
		//Tested in PersonController test	
	}
	
	@Test
	public void testManageProfile() {
		Person u5 = new User("firstName5","lastName5","username5","password5");
		assertTrue(u5.getFirstName()=="firstName5");
		u5.getLastName();
		u5.getUsername();
		u5.getPassword();
	}

}
