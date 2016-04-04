package cmcControllerTests;

import static org.junit.Assert.*;


	import entities.*;
	import controllers.*;
	import org.junit.Before;
	import org.junit.Test;
	import java.util.ArrayList;
	import java.util.List;


	public class UserControllerTest {
		User u;
		DBController dbController;
		UserController controller;
		
		@Before
		public void setUp() throws Exception {
			u = new User();
		    dbController = new DBController();
			controller = new UserController(u);
		}
		
		@Test
		public void testConstructor() {
			assertTrue("Construster is not null.", dbController!=null);
			assertTrue("Construster is not null.", controller!=null);
			
		}
		
		@Test
		public void testDisplaySchoolInfo(){
			School s = dbController.findBySchoolName("ABILENE CHRISTIAN UNIVERSITY");
			assertTrue("Testing that the name is right.", s.getName().equals("ABILENE CHRISTIAN UNIVERSITY"));
			List<String> testString = new ArrayList<String>();
			List<String> actualString = controller.displaySchoolInfo(s);
			
			
			testString.add("ABILENE CHRISTIAN UNIVERSITY");
			testString.add("TEXAS");
			testString.add("SUBURBAN");
			testString.add("PRIVATE");
			testString.add(Integer.toString(10000));
			testString.add(Double.toString(50.0));
			testString.add(Double.toString(-1.0));
			testString.add(Double.toString(-1.0));
			testString.add(Double.toString(12088));
			testString.add(Double.toString(70.0));
			testString.add(Integer.toString(4000));
			testString.add(Double.toString(90.0));
			testString.add(Double.toString(80.0));
			testString.add(Integer.toString(2));
			testString.add(Integer.toString(3));
			testString.add(Integer.toString(3));
			
			
			for(int i = 0; i < testString.size(); i++){
				System.out.println(actualString.get(i));
			assertTrue("It should be equal" + testString.get(i) + " and " + actualString.get(i) , testString.get(i).equals(actualString.get(i)));
		
			}
		}
		
}
