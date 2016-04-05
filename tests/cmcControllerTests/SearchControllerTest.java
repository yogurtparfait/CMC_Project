package cmcControllerTests;

import static org.junit.Assert.*;

import java.util.List;

import entities.*;
	import controllers.*;
	import org.junit.Before;
	import org.junit.Test;

	public class SearchControllerTest {
		SearchController controller;
		@Before
		public void setUp() throws Exception {
			controller = new SearchController();
		}
		
		
		@Test
		//Tested more thoroughly in DBcontrollerTest
		public void testSearch() {
			String[] empty = new String[0];
		List<School> schools2 = controller.search("","FLORIDA","","",
				-1,-1,-1,-1,-1,
				-1,-1,-1,
				-1,-1,-1,-1,empty
				);
		assertTrue("find returns correct school",
				schools2.get(0).getName().equals("FLORIDA ACADEMIC UNIVERSITY"));
		}

	}


