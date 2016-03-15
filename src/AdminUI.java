import java.util.List;

public class AdminUI extends PersonUI {

	public AdminController controller;
	public AdminUI(Admin a) {
		this.controller = new AdminController(a);
	}
	public void addSchool(String name,String state,String location,String control,
	int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
	double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
	double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
		this.controller.addSchool(name,state,location,control,
				numStudents,percentFemale,SATVerb,SATMath,expenses,
				percentFinancialAid,numberOfApplicants,percentAdmitted,
				percentEnrolled,academicsScale,socialScale,qualityOfLifeScale);
	}
	public List<Person> getPeople(){
		return this.controller.getPeople();	
	}
	public Person getPersonByUsername(String username){
		return this.controller.getPersonByUsername(username);
	}
	
	public boolean addPerson(String firstName, String lastName, String password, String username, String type){
		return this.controller.addPerson(firstName,lastName,password,username,type);	
	}
	public void changeStatus(Person p){
		this.controller.changeStatus(p);	
	}
	public boolean updatePerson(Person person, String firstName, String lastName, String password, String type){
		return this.controller.updatePerson(person, firstName,lastName,password,type);	
	}
	public void updateSchool(School s, String name,String state,String location,String control,
	int numStudents,double percentFemale,double SATVerb,double SATMath,double expenses,
	double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
	double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale, String[] emphases){
		this.controller.updateSchool(s,name,state,location,control,
				numStudents,percentFemale,SATVerb,SATMath,expenses,
				percentFinancialAid,numberOfApplicants,percentAdmitted,
				percentEnrolled,academicsScale,socialScale,qualityOfLifeScale, emphases);
	}
	public List<School> getSchools(){
		return this.controller.getSchools();
	}
	public School getSchoolByName(String name){
		return this.controller.getSchoolByName(name);
	}
}
