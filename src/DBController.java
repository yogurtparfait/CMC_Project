
public class DBController {
	
	public static boolean unSaveSchool(User u, School s){
		//TODO
		return false;
	}
	
	public static boolean addSavedSchool(User u, School s){
		//TODO
		return false;
	}

	public static User findByUserName(String username){
		//TODO
	}
	
	public static boolean createSchool(String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
		//TODO
		return false;
	}
	
	public static List<School> getUserSchools(User u){
		//TODO	
	}
	
	public static List<Person> getPeople(){
		//TODO	
	}

	public static boolean addUser(String firstName, String lastName, String password, String username){
		//TODO	
		return false;
	}
	
	public boolean activate(User u){
		//TODO	
		return false;
	}
	
	//Should this update person in general? Can an admin update an admin?
	public static boolean updateUser(User u,String firstName, String lastName, String password, String username){
		//TODO	
		return false;
	}
	
	public static boolean logOut(Person p){
	//TODO
		return false;
	}
	
	public static boolean updateSchool(School s, String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
		//TODO
		return false;
	}	
	
	public static boolean deactivate(Person p){
	//TODO
		return false;
	}
	
}
