import java.util.List;
import java.util.ArrayList;
//need to import the database class. not sure how.

public class DBController {
	
	
	
	
	private UniversityDBLibrary library;
	
	public DBController() {
		this.library = UniversityDBLibrary("yogurtparf","yogurtparf","jmny4");
	}
	
	public static boolean unSaveSchool(User u, School s){
		int i = library.user_removeSchool(u.getUsername(),s.getName());
		if(i==-1) return false;
		return true;
	}
	
	public static boolean addSavedSchool(User u, School s){
		int i = library.user_saveSchool(u.getUsername(),s.getName());
		if(i==-1) return false;
		return true;

	}

	public static Person findByUserName(String username){
		String[][] users = library.user_getUsers();
		for(String[] currentUser:users){
			if(currentUser[2].equals(username)){
				if(currentUser[4].charAt(0)=='u'){
					User returnUser = new User();
					returnUser.setFirstName(currentUser[0]);
					returnUser.setLastName(currentUser[1]);
					returnUser.setUsername(currentUser[2]);
					returnUser.setPassword(currentUser[3]);
					return returnUser;
				}
				else{ //isAdmin
				Admin returnAdmin = new Admin();
				returnAdmin.setFirstName(currentUser[0]);
				returnAdmin.setLastName(currentUser[1]);
				returnAdmin.setUsername(currentUser[2]);
				returnAdmin.setPassword(currentUser[3]);
				return returnAdmin;
				}
				
			}
		}
		}
	}
	
	public static boolean createSchool(String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
		
		int i = library.university_addUniversity(name, state, location, control, numStudents,
				percentFemale, SATVerb, SATMath, expenses, percentFinancialAid, numberOfApplicants,
				percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
		if(i==-1) return false;
		return true;
		
	}
	
	public static List<School> getUserSchools(User u){
		String[][] userSchools = library.getUsernamesWithSavedSchools();
		String[][] schools = library.university_getUniversities();
		List<School> returnSchools = new ArrayList<School>();
		for(String[] currentUsername:userSchools){
		if(currentUsername[0].equals(u.getUsername())){
			//TODO
			for(String[] currentSchool:schools){
				if(currentUsername[1].equals(currentSchool[0])){
					returnSchools.add(new School(
							//TODO
							//Fix all these parameter types
							//name
							currentSchool[0],
							//state
							currentSchool[1],
							//location
							currentSchool[2],
							//control
							currentSchool[3],
							//numberOfStudents
							Integer.parseInt(currentSchool[4]),
							//PercentFemale
							currentSchool[5],
							//SATVerbal
							currentSchool[6],
							//SATMath
							currentSchool[7],
							//Expenses
							currentSchool[8],
							//PercentFincancialAid
							currentSchool[9],
							//NumberOfApplicants
							currentSchool[10],
							//PercentAdmitted
							currentSchool[11],
							//PercentEnrolled
							currentSchool[12],
							//AcademicsScale
							currentSchool[13],
							//SocialScale
							currentSchool[14],
							//QualityOfLife
							Integer.parseInt(currentSchool[15])))
				}
			}
		}
		return schools;
		}
			
	}
	
	public static Person[] getPeople(){
		String[][] users = library.user_getUsers();
		Person[] people = Person[users]
		for(String[] currentUser:users){
			
		}
	}

	public static boolean addPerson(String firstName, String lastName, String password, String username){
		//TODO	
		return false;
	}
	
	public boolean activate(User u){
		//TODO	
		return false;
	}
	
	//True if active
	public static boolean getActiveState(Person p){
		//TODO
		return true;
	}
	
	//Should this update person in general? Can an admin update an admin?
	public static boolean updatePerson(Person person,String firstName, String lastName, String password){
		//TODO	
		return false;
	}
	
	public static boolean logOut(Person p){
	//TODO
		return false;
	}
	
	public static boolean logInPerson(Person p){
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
	
	public static List<School> getSavedSchools(){
		//TODO
	}
	
}
