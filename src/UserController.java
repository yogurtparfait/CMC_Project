import java.awt.List;

public class UserController {
	public User thisUser;
	public UserController(User u) {
		this.thisUser = u;
	}
	
	public List<School> getSavedSchools(Person p){
		//TODO
	}
	
	public List<String> displaySchoolInfo(School s){
		//TODO
	}
	
	public boolean removeSavedSchool(School s){
		//TODO
		return false;
	}
	
	public boolean saveSchool(School s){
		//TODO
	}
	
	public List<School> search(String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
		//TODO
	}
	
	public List<School> getRecommendations(School s){
		//TODO
	}
	
	public boolean UpdateUser(Person p,String firstName, String lastName, String password, String type){
		//TODO
		return false;
	}
}
