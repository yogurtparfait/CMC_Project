import java.util.List;


public class UserController {
	public User thisUser;
	public UserController(User u) {
		this.thisUser = u;
	}
	
	public List<School> getSavedSchools(){
		return DBController.getSavedSchools();
	}
	
	public List<String> displaySchoolInfo(School s){
		//TODO
	}
	
	public boolean removeSavedSchool(School s){
		return DBController.unSaveSchool(this.thisUser, s);
	}
	
	public boolean saveSchool(School s){
		return DBController.addSavedSchool(this.thisUser, s);
	}
	
	public List<School> search(String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
		return SearchController.search(name, state, location, control, numStudents, percentFemale, 
				SATVerb, SATMath, expenses, percentFinancialAid, numberOfApplicants, percentAdmitted, 
				percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
		//Make sure to catch nulls for no schools found.
	}
	
	public List<School> getRecommendations(School s){
		return SearchController.recommendations(s);
	}
	
	public boolean UpdateUser(String firstName, String lastName, String password, String type){
		return DBController.updatePerson(this.thisUser, firstName, lastName, password);
	}
	
	public User getUser(){
		return this.thisUser;
	}
}
