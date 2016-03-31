package cmcEntityTests;

import static org.junit.Assert.*;


	import entities.*;
	import org.junit.Before;
	import org.junit.Test;

import controllers.DBController;


	public class SchoolTest {
		private School s;

		@Before
		public void setUp() throws Exception {
			

			s = new School("name","state","location","control",
					1,.5,.5,.5,.5,
					.5,1,.5,
					.5,1,1,1
					);
		}
		
		@Test
		public void testCreatesObject() {
			assertTrue("School constructor works",!(s==null));
		}

	
	@Test
	public void testGetters() {

	/*	(String name,String state,String location,String control,
				int numStudents,double percentFemale,double SATVerb,double SATMath,double expenses,
				double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
				double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale)*/
		
		assertTrue("Name getter works",s.getName().equals("name"));
		assertTrue("State getter works",s.getState().equals("state"));
		assertTrue("Location getter works",s.getLocation().equals("location"));
		assertTrue("Control getter works",s.getControl().equals("control"));
		assertTrue("numStudents getter works",s.getNumStudents()==1);
		assertTrue("percentFemale getter works",s.getPercentFemale()==.5);
		assertTrue("SATVerb getter works",s.getSATVerb()==.5);
		assertTrue("SATMAth getter works",s.getSATMath()==.5);
		assertTrue("expenses getter works",s.getExpenses()==.5);
		assertTrue("percentFinancialAid getter works",s.getPercentFinancialAid()==.5);
		assertTrue("numberOfApplicants getter works",s.getNumberOfApplicants()==1);
		assertTrue("percentAdmitted getter works",s.getPercentAdmitted()==.5);
		assertTrue("percentEnrolled getter works",s.getPercentEnrolled()==.5);
		assertTrue("academicsScale getter works",s.getAcademicsScale()==1);
		assertTrue("qualityOfLifeScale getter works",s.getQualityOfLifeScale()==1);
		
	}
	@Test
	public void testSetters() {

		s.setName("name1");
		s.setState("state1");
		s.setLocation("location1");
		s.setControl("control1");
		s.setNumStudents(2);
		s.setPercentFemale(.4);
		s.setSATVerb(.4);
		s.setSATMath(.4);
		s.setExpenses(.4);
		s.setPercentFinancialAid(.4);
		s.setNumberOfApplicants(2);
		s.setPercentAdmitted(.4);
		s.setPercentEnrolled(.4);
		s.setAcademicsScale(2);
		s.setSocialScale(2);
		s.setQualityOfLifeScale(2);
		
		assertTrue("Name getter works",s.getName().equals("name1"));
		assertTrue("State getter works",s.getState().equals("state1"));
		assertTrue("Location getter works",s.getLocation().equals("location1"));
		assertTrue("Control getter works",s.getControl().equals("control1"));
		assertTrue("numStudents getter works",s.getNumStudents()==2);
		assertTrue("percentFemale getter works",s.getPercentFemale()==.4);
		assertTrue("SATVerb getter works",s.getSATVerb()==.4);
		assertTrue("SATMAth getter works",s.getSATMath()==.4);
		assertTrue("expenses getter works",s.getExpenses()==.4);
		assertTrue("percentFinancialAid getter works",s.getPercentFinancialAid()==.4);
		assertTrue("numberOfApplicants getter works",s.getNumberOfApplicants()==2);
		assertTrue("percentAdmitted getter works",s.getPercentAdmitted()==.4);
		assertTrue("percentEnrolled getter works",s.getPercentEnrolled()==.4);
		assertTrue("academicsScale getter works",s.getAcademicsScale()==2);
		assertTrue("qualityOfLifeScale getter works",s.getQualityOfLifeScale()==2);
		
	}
}


