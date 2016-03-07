import java.util.List;

public class AdminController extends PersonController{
	
	public Admin thisAdmin;
	public AdminController(Admin a) {
		this.thisAdmin = a;
	}
	public void addSchool(String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
	
				//TODO	
	
	}
			public List<Person> getPeople(){
				//TODO	
			}
			
			public boolean addPerson(String firstName, String lastName, String password, String username, String type){
				//TODO		
				return false;
			}
			
			public boolean changeStatus(Person p){
				//TODO	
			}
			
			public boolean updatePerson(Person person, String firstName, String lastName, String password, String type){
				//TODO	
				return false;
			}
			
			public void updateSchool(School s, String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
				//TODO	
			}
			
			public List<School> getSchools(Person p){
				//TODO	
			}

}
