import java.awt.List;

public class UserUI extends PersonUI{

	public UserController controller;
	
	public UserUI(User u) {
		super.thisPerson = u;
		this.controller = new UserController(u);
	}
	
	public List<School> getSavedSchools(super.thisPerson){
		return this.controller.getSavedSchools(super.thisPerson);
	}
	
	public List<String> displaySchoolInfo(School s){
		return this.controller.displaySchoolInfo(s);
	}
	
	public boolean removeSavedSchool(School s){
		return this.controller.removeSavedSchool(s);
	}
	
	public boolean saveSchool(School s){
		return this.controller.saveSchool(s);
	}
	
	public List<School> search((School s, String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
		return this.controller.search((name,state,location,control,
				numStudents,percentFemale,SATVerb,SATMath,expenses,
				percentFinancialAid,numberOfApplicants,percentAdmitted,
				percentEnrolled,academicsScale,socialScale,qualityOfLifeScale);
	}
	
	public List<School> getRecommendations(School s){
		return this.controller.getRecommendations(s);
	}
	
	public User getUser(){
		return super.thisPerson;
	}
	
	public boolean UpdateUser(String firstName, String lastName, String password, String type){
	return this.controller.updateUser(super.thisPerson, firstName, lastName, password, type);
	}
	
	
	}

