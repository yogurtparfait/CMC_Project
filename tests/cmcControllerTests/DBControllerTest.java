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
			u = new User("firstName","lastName","username","password");
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
			controller.addPerson("firstName","lastName","password","username",'u');
			System.out.println(controller.addSavedSchool(u, s));
			List<School> userSchools = controller.getUserSchools(u);
			assertTrue("school saved", !(userSchools.isEmpty()));
			
			assertTrue("unsave school fails for invalid school",
					(controller.unSaveSchool(u, new School("OtherName","state","location","control",
					1,.5,1,.5,.5,
					.5,1,.5,
					.5,1,1,1
					))==false));
			
			assertTrue("unsave school fails for invalid user",
					(controller.unSaveSchool(new User("firstName","lastName","password","OtherUsername"), s)==false));
			
			assertTrue("unsave school returns true",controller.unSaveSchool(u, s));
			assertTrue("unsave school removes school from saved schools",
					controller.getUserSchools(u).isEmpty());
		}
		
		@Test
		public void testSaveSchool() {
			controller.createSchool("name","state","location","control",
					1,.5,1,.5,.5,
					.5,1,.5,
					.5,1,1,1
					);
			controller.addPerson("firstName","lastName","password","username",'u');
			
			u = new User("firstName","lastName","username","password");
			s = new School("name","state","location","control",
					1,.5,1,.5,.5,
					.5,1,.5,
					.5,1,1,1
					);
			
			assertTrue("School begins unsaved", controller.getUserSchools(u).isEmpty());
			
			assertTrue("save school fails for invalid school",
					(controller.addSavedSchool(u, new School("OtherName","state","location","control",
					1,.5,1,.5,.5,
					.5,1,.5,
					.5,1,1,1
					))==false));
			
			assertTrue("save school fails for invalid user",
					(controller.addSavedSchool(new User("firstName","lastName","password","OtherUsername"),s))==false);
			
			controller.addSavedSchool(u, s);
			List<School> userSchools = controller.getUserSchools(u);
			assertTrue("save school works for valid user and school",
					!(userSchools.isEmpty()));
			
			controller.unSaveSchool(u, s);
		}
		@Test
		public void testFindByUsername() {
			boolean b = controller.addPerson("firstName","lastName","password","username",'u');
			assertTrue("find by username fails for invalid username",(controller.findByUserName("OtherUsername")==null));
			Person p = controller.findByUserName("username");
			System.out.println(b);
			assertTrue("found person has right first name",p.getFirstName().equals("firstName"));
			assertTrue("found person has right last name",p.getLastName().equals("lastName"));
			assertTrue("found person has right password",p.getPassword().equals("password"));
			assertTrue("found person has right Username",p.getUsername().equals("username"));
		}
		@Test
		public void testCreateSchool() {
			
			controller.deleteSchool("name1");
			
			assertTrue("createSchool works for new school",
					controller.createSchool("name1","state","location","control",
					1,.5,.5,.5,.5,
					.5,1,.5,
					.5,1,1,1
					)==true);
			
			School s1 = controller.getSchoolByName("name1");
			
			assertTrue("school has right name",s1.getName().equals("name1"));
			assertTrue("school has right location",s1.getLocation().equals("location"));
			
			
			assertTrue("createSchool fails when school already exists",
					(controller.createSchool("name1","state","location","control",
					1,.5,1,.5,.5,
					.5,1,.5,
					.5,1,1,1
					)==false));
			
		}
		
		@Test
		public void testGetUserSchools() {
			controller.deletePerson("username");
			controller.unSaveSchool(u, s);
			
			controller.createSchool("name","state","location","control",
					1,.5,1,.5,.5,
					.5,1,.5,
					.5,1,1,1
					);
			controller.addPerson("firstName", "lastName", "password", "username", 'u');
			
			List<School> userSchools = controller.getUserSchools(u);
			assertTrue("getUserSchools returns empty array for user with no saved schools",(userSchools.isEmpty()));
			controller.addSavedSchool(u, s);
			List<School> userSchools2 = controller.getUserSchools(u);
			assertTrue("getUserSchools works for valid user",!(userSchools2.isEmpty()));
			List<School> userSchools3 = controller.getUserSchools(new User("notAName","lastName","password","NotAUsername"));
			assertTrue("getUserSchools returns empty array for invalid user",(userSchools3.isEmpty()));
			controller.unSaveSchool(u, s);
		}
		
		@Test
		public void testGetPeople() {
			List<Person> persons = controller.getPeople();
			assertTrue("getPeople returns non-empty list",!(persons.isEmpty()));
			assertTrue("getPeople returns correct persons",!(persons.get(0).getFirstName()=="Edited"));
		}
		
		@Test
		public void addPerson() {
			controller.deletePerson("username5");
			assertTrue("addPerson works for new person",controller.addPerson(
					"firstName5","lastName5","password5","username5",'u'));
			assertTrue("addPerson fails if person is in database",!controller.addPerson(
					"firstName","lastName","password","username5",'u'));
			controller.deletePerson("username5");
		}
		
		@Test
		public void testActivateAndDeactivate() {
			controller.addPerson("firstName5","lastName5","password5","username5",'u');
			assertTrue("person starts active",controller.getActiveState(u)=='Y');
			controller.deactivate(u);
			assertTrue("deactivate works for active user",controller.getActiveState(u)=='N');
			controller.activate(u);
			assertTrue("activate works for non-active user",controller.getActiveState(u)=='Y');
		}
		
		@Test
		public void updatePerson() {
			controller.deletePerson("username5");
			Person u5 = new User("firstName5","lastName5","username5","password5");
			
			assertTrue("Update fails when person's username is not in database",
					!(controller.updatePerson(u5,"firstName5!!!","lastName5!!!","password5!!!")));
			
			controller.addPerson("firstName5","lastName5","password5","username5",'u');
			
			controller.updatePerson(u5,"firstName5!!!","lastName5!!!","password5!!!");
			Person u6 = controller.findByUserName(u5.getUsername());
			
			assertTrue("update changes firstName",u6.getFirstName().equals("firstName5!!!"));
			assertTrue("update changes lastName",u6.getLastName().equals("lastName5!!!"));
			assertTrue("update changes password",u6.getPassword().equals("password5!!!"));
			
			controller.deletePerson("username5");
		}
		
		@Test
		public void updateSchool() {
			controller.deleteSchool("name");			
			
			assertTrue("Update fails when school is not in database",
					!(controller.updateSchool(s,"name","state","location","control",
							1,.5,1,.5,.5,
							.5,1,.5,
							.5,1,1,1
							)));
			
			controller.createSchool("name","state","location","control",
					1,.5,1,.5,.5,
					.5,1,.5,
					.5,1,1,1
					);
			
			assertTrue("Update works when school is in database",
					(controller.updateSchool(s,"name","state!!!","location","control",
							1,.5,1,.5,.5,
							.5,1,.5,
							.5,1,1,1
							)));
			assertTrue("update changes firstName",controller.findBySchoolName("name").getState().equals("state!!!"));

			controller.deleteSchool("name");
		}
		
		@Test
		public void testGetSchools() {
			List<School> schools = controller.getSchools();
			assertTrue("getSchools returns non-empty list",!(schools.isEmpty()));
			assertTrue("getSchools returns correct schools",!(schools.get(0).getName()=="ABILENE CHRISTIAN UNIVERSITY"));
		}
		
		@Test
		public void findBySchoolName() {
			assertTrue("findBySchoolName fails for invalid school",
					(controller.findBySchoolName("eggplant empire")==null));
			assertTrue("findBySchoolName suceeds for valid school",
					(controller.findBySchoolName("ABILENE CHRISTIAN UNIVERSITY").getState().equals("TEXAS")));
		}
		
		@Test
		public void testSearch() {
			String[] empty = new String[0];
			List<School> schools1 = controller.search("ABILENE CHRISTIAN UNIVERSITY","","","",
					-1,-1,-1,-1,-1,
					-1,-1,-1,
					-1,-1,-1,-1,empty
					);
			assertTrue("find returns correct school",
					schools1.get(0).getName().equals("ABILENE CHRISTIAN UNIVERSITY"));
			
			
			
			List<School> schools2 = controller.search("","FLORIDA","","",
					-1,-1,-1,-1,-1,
					-1,-1,-1,
					-1,-1,-1,-1,empty
					);
			assertTrue("find returns correct school",
					schools2.get(0).getName().equals("FLORIDA ACADEMIC UNIVERSITY"));
			
			
			
			List<School> schools3 = controller.search("","","","",
					-1,30,-1,-1,-1,
					-1,-1,-1,
					-1,-1,-1,-1,empty
					);
			assertTrue("find returns correct school",
					schools3.get(0).getName().equals("CAL TECH"));
			
			List<School> schools4 = controller.search("","","","",
					-1,-1,-1,-1,-1,
					-1,-1,-1,
					-1,-1,-1,4,empty
					);
			assertTrue("find returns correct school",
					schools4.get(0).getName().equals("AUBURN"));
			
			List<School> schools5 = controller.search("","","URBAN","",
					-1,-1,-1,-1,-1,
					-1,-1,-1,
					-1,-1,-1,-1,empty
					);
			assertTrue("find returns correct school",
					schools5.get(0).getName().equals("AMERICAN UNIVERSITY OF BEIRUT"));
	}
		@Test
		public void testRecommendations() {
			List<School> schools = controller.getSchools();
			for(School s1:schools){
				assertTrue("recommendation works for every school",!(controller.recommendations(s1).isEmpty()));
		}
			
			School s2 = controller.findBySchoolName("BENNINGTON");
			

			List<School> schools1 = controller.recommendations(s2);
			assertTrue("School recommends correctly similar school",
					schools1.get(0).getName().equals("CAL TECH"));
	}
		
	}



