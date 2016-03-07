
public class AdminUI extends PersonUI {

	public AdminUI(Admin a) {
		super.thisPerson = a;
	}
	public void addSchool(String name,String state,String location,String control,
	int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
	double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
	double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
		super.controller.addSchool(name,state,location,control,
				numStudents,percentFemale,SATVerb,SATMath,expenses,
				percentFinancialAid,numberOfApplicants,percentAdmitted,
				percentEnrolled,academicsScale,socialScale,qualityOfLifeScale);
	}
	public List<Person> getPeople(){
		return super.controller.getPeople();	
	}
	public List<Person> addPerson(String firstName, String lastName, String password, String username, String type){
		return super.controller.addPerson(firstName,lastName,password,username,type);	
	}
	public boolean changeStatus(Person p){
		return super.controller.changeStatus(p);	
	}
	public boolean updatePerson(String firstName, String lastName, String password, String type){
		return super.controller.addPerson(firstName,lastName,password,type);	
	}
	public void updateSchool(School s, String name,String state,String location,String control,
	int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
	double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
	double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
		super.controller.updateSchool(s,name,state,location,control,
				numStudents,percentFemale,SATVerb,SATMath,expenses,
				percentFinancialAid,numberOfApplicants,percentAdmitted,
				percentEnrolled,academicsScale,socialScale,qualityOfLifeScale);
	}
	public List<School> getSchools(){
		return super.controller.getSchools(super.thisPerson);
	}
}
