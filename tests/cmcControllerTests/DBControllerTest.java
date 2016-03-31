package cmcControllerTests;

import static org.junit.Assert.*;

import java.util.List;

import entities.*;
	import controllers.*;
	import org.junit.Before;
	import org.junit.Test;

	public class DBControllerTest {
		DBController controller;
		User u;
		School s;
		
		@Before
		public void setUp() throws Exception {
			controller = new DBController();
			u = new User("firstName","lastName","password","username");
			s = new School("name","state","location","control",
					1,.5,1,.5,.5,
					.5,1,.5,
					.5,1,1,1
					);
		}
		
		@Test
		public void testConstructor() {
			assertTrue("DBController constructor works",!(controller==null));
		}
		
		@Test
		public void testUnsaveSchool() {
			controller.createSchool("name","state","location","control",
					1,.5,1,.5,.5,
					.5,1,.5,
					.5,1,1,1
					);
			controller.addPerson("firstName","lastName","password","username");
			System.out.println(controller.addSavedSchool(u, s));
			List<School> userSchools = controller.getUserSchools(u);
			assertTrue("school saved", userSchools.get(0).getName().equals("name"));
			
			assertTrue("unsave school fails for invalid school",
					(controller.unSaveSchool(u, new School("OtherName","state","location","control",
					1,.5,1,.5,.5,
					.5,1,.5,
					.5,1,1,1
					))==false));
			
			assertTrue("unsave school fails for invalid user",
					(controller.unSaveSchool(new User("firstName","lastName","password","OtherUsername"), s)==false));
			
			controller.unSaveSchool(u, s);
			assertTrue("unsave school works for valid user and school",controller.getUserSchools(u).isEmpty());
		}
		
		@Test
		public void testSaveSchool() {
			controller.createSchool("name","state","location","control",
					1,.5,1,.5,.5,
					.5,1,.5,
					.5,1,1,1
					);
			controller.addPerson("firstName","lastName","password","username");
			
			assertTrue("School begins unsaved", controller.getUserSchools(u).isEmpty());
			
			assertTrue("save school fails for invalid school",
					(controller.addSavedSchool(u, new School("OtherName","state","location","control",
					1,.5,1,.5,.5,
					.5,1,.5,
					.5,1,1,1
					))==false));
			
			assertTrue("save school fails for invalid user",
					(controller.addSavedSchool(new User("firstName","lastName","password","OtherUsername"),s))==false);
			
			System.out.println(controller.addSavedSchool(u, s));
			List<School> userSchools = controller.getUserSchools(u);
			assertTrue("save school works for valid user and school",
					userSchools.get(0).getName().equals("name"));
			
			controller.unSaveSchool(u, s);
		}
		@Test
		public void testFindByUsername() {
			controller.addPerson("firstName","lastName","password","username");
			assertTrue("find by username fails for invalid username",(controller.findByUserName("OtherUsername")==null));
			Person p = controller.findByUserName("firstName");
			assertTrue("found person has right first name",p.getFirstName().equals("firstName"));
			assertTrue("found person has right last name",p.getFirstName().equals("lastName"));
			assertTrue("found person has right password",p.getPassword().equals("password"));
			assertTrue("found person has right Username",p.getUsername().equals("username"));
		}
	}



