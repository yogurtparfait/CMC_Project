import java.util.List;

public class AdminController extends PersonController{
	
	public Admin thisAdmin;
	public AdminController(Admin a) {
		this.thisAdmin = a;
	}
	public boolean addSchool(String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
	
				return DBController.createSchool(name,state,location,control,
						numStudents,percentFemale,SATVerb,SATMath,expenses,
						percentFinancialAid,numberOfApplicants,percentAdmitted,
						percentEnrolled,academicsScale,socialScale,qualityOfLifeScale);
	
	}
			public List<Person> getPeople(){
				return DBController.getPeople();
			}
			
			public boolean addPerson(String firstName, String lastName, String password, String username, String type){
				return DBController.addPerson(firstName, lastName, password, username);
			}
			
			public void changeStatus(Person p){
				if(DBController.getActiveState(p)){ 
					DBController.deactivate(p);
				}
				else{
					DBController.deactivate(p);
				}
	
			}
			
			public boolean updatePerson(Person person, String firstName, String lastName, String password, String type){
				return DBController.updatePerson(person, firstName, lastName, password);
			}
			
			public void updateSchool(School s, String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
				DBController.updateSchool(s, name, state, location, control, numStudents, 
						percentFemale, SATVerb, SATMath, expenses, percentFinancialAid, 
						numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
				
			}
			
			public List<School> getSchools(){
				return DBController.getSchools();
			}

}
