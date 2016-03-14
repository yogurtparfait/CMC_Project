
import java.util.List;

public class UserUI extends PersonUI{

	public UserController controller;
	
	public UserUI(User u) {
		this.controller = new UserController(u);
		
	}
	
	public List<School> getSavedSchools(){
		return this.controller.getSavedSchools();
	}
	
	//Returns all info as string with emphases at the end
	public List<String> displaySchoolInfo(School s){
		return this.controller.displaySchoolInfo(s);
	}
	
	public boolean removeSavedSchool(School s){
		return this.controller.removeSavedSchool(s);
	}
	
	public boolean saveSchool(School s){
		return this.controller.saveSchool(s);
	}
	
	//give null or -1 for empty fields
	public List<School> search(String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale,
			String [] emphases){
		return this.controller.search(name,state,location,control,
				numStudents,percentFemale,SATVerb,SATMath,expenses,
				percentFinancialAid,numberOfApplicants,percentAdmitted,
				percentEnrolled,academicsScale,socialScale,qualityOfLifeScale, emphases);
	}
	
	public List<School> getRecommendations(School s){
		return this.controller.getRecommendations(s);
	}
	
	public User getUser(){
		return controller.getUser();
	}
	
	public boolean UpdateUser(String firstName, String lastName, String password, String type){
	return this.controller.UpdateUser(firstName, lastName, password, type);
	}
	
	
	}

