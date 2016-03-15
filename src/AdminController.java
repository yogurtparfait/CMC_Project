import java.util.List;

public class AdminController extends PersonController{
	
	private Admin thisAdmin;
	private DBController database;
	public AdminController(Admin a) {
		this.thisAdmin = a;
		database = new DBController();
	}
	public boolean addSchool(String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
	
				return  database.createSchool(name,state,location,control,
						numStudents,percentFemale,SATVerb,SATMath,expenses,
						percentFinancialAid,numberOfApplicants,percentAdmitted,
						percentEnrolled,academicsScale,socialScale,qualityOfLifeScale);
	
	}
			public List<Person> getPeople(){
				return database.getPeople();
			}
			
			public boolean addPerson(String firstName, String lastName, String password, String username, String type){
				return database.addPerson(firstName, lastName, password, username);
			}
			
			public Person getPersonByUsername(String username)
			{
				return database.findByUserName(username);
			}
			
			public boolean changeStatus(Person p){
				if(database.getActiveState(p)=='Y'){ 
					database.deactivate(p);
					return true;
				}
				else if(database.getActiveState(p)=='N'){
					database.activate(p);
					return true;
				}
				return false;
	
			}
			
			public boolean updatePerson(Person person, String firstName, String lastName, String password, String type){
				return database.updatePerson(person, firstName, lastName, password);
			}
			
			public void updateSchool(School s, String name,String state,String location,String control,
			int numStudents,double percentFemale,double SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale,
			String[] emphases){
				database.updateSchool(s, name, state, location, control, numStudents, 
						percentFemale, SATVerb, SATMath, expenses, percentFinancialAid, 
						numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale, emphases);
				
			}
			
			public List<School> getSchools(){
				return database.getSchools();
			}
			public School getSchoolByName(String name){
				return database.getSchoolByName(name);
			}
}
