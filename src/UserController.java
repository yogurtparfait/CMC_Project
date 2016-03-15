import java.util.ArrayList;
import java.util.List;


public class UserController {
	private User thisUser;
	private DBController database;
	private SearchController search;
	public UserController(User u) {
		this.thisUser = u;
		database = new DBController();
	}
	
	public List<School> getSavedSchools(){
		return  database.getUserSchools(this.thisUser);
	}
	
	public List<String> displaySchoolInfo(School s){
		List<String> returnString = new ArrayList<String>();
		
		returnString.add(s.getName());
		returnString.add(s.getState());
		returnString.add(s.getLocation());
		returnString.add(s.getControl());
		returnString.add(Integer.toString(s.getNumStudents()));
		returnString.add(Double.toString(s.getPercentFemale()));
		returnString.add(Double.toString(s.getSATVerb()));
		returnString.add(Double.toString(s.getSATMath()));
		returnString.add(Double.toString(s.getExpenses()));
		returnString.add(Double.toString(s.getPercentFinancialAid()));
		returnString.add(Integer.toString(s.getNumberOfApplicants()));
		returnString.add(Double.toString(s.getPercentAdmitted()));
		returnString.add(Double.toString(s.getPercentEnrolled()));
		returnString.add(Integer.toString(s.getAcademicsScale()));
		returnString.add(Integer.toString(s.getSocialScale()));
		returnString.add(Integer.toString(s.getQualityOfLifeScale()));
		
		for(String e:s.getEmphases()){
			returnString.add(e);
		}
		
		return returnString;
	}
	
	public boolean removeSavedSchool(School s){
		return  database.unSaveSchool(this.thisUser, s);
	}
	
	public boolean saveSchool(School s){
		return  database.addSavedSchool(this.thisUser, s);
	}
	
	public List<School> search(String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale,
			String[] emphases){
		return search.search(name, state, location, control, numStudents, percentFemale, 
				SATVerb, SATMath, expenses, percentFinancialAid, numberOfApplicants, percentAdmitted, 
				percentEnrolled, academicsScale, socialScale, qualityOfLifeScale, emphases);
		//Make sure to catch nulls for no schools found.
	}
	
	public List<School> getRecommendations(School s){
		return search.recommendations(s);
	}
	
	public boolean UpdateUser(String firstName, String lastName, String password, String type){
		return  database.updatePerson(this.thisUser, firstName, lastName, password);
	}
	
	public User getUser(){
		return this.thisUser;
	}
}
