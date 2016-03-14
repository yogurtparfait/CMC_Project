import java.util.ArrayList;
import java.util.List;
import dblibrary.project.csci230.*;
public class DBController {
	
	
	
	
	private UniversityDBLibrary library;
	
	public DBController() {
		this.library = new UniversityDBLibrary("yogurtparf","yogurtparf","jmny4");
	}
	
	public boolean unSaveSchool(User u, School s){
		int i = library.user_removeSchool(u.getUsername(),s.getName());
		if(i==-1) return false;
		return true;
	}
	
	public boolean addSavedSchool(User u, School s){
		int i = library.user_saveSchool(u.getUsername(),s.getName());
		if(i==-1) return false;
		return true;

	}

	public Person findByUserName(String username){
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
		return null;
		}
	
	
	public boolean createSchool(String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
		
		int i = library.university_addUniversity(name, state, location, control, numStudents,
				percentFemale, SATVerb, SATMath, expenses, percentFinancialAid, numberOfApplicants,
				percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
		if(i==-1) return false;
		return true;
		
	}
	
	public List<School> getUserSchools(User u){
		String[][] userSchools = library.user_getUsernamesWithSavedSchools();
		String[][] schools = library.university_getUniversities();
		List<School> returnSchools = new ArrayList<School>();
		for(String[] currentUsername:userSchools){
		if(currentUsername[0].equals(u.getUsername())){
			for(String[] currentSchool:schools){
				if(currentUsername[1].equals(currentSchool[0])){
					returnSchools.add(new School(
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
							Double.parseDouble(currentSchool[5]),
							//SATVerbal
							Double.parseDouble(currentSchool[6]),
							//SATMath
							Double.parseDouble(currentSchool[7]),
							//Expenses
							Double.parseDouble(currentSchool[8]),
							//PercentFincancialAid
							Double.parseDouble(currentSchool[9]),
							//NumberOfApplicants
							Integer.parseInt(currentSchool[10]),
							//PercentAdmitted
							Double.parseDouble(currentSchool[11]),
							//PercentEnrolled
							Double.parseDouble(currentSchool[12]),
							//AcademicsScale
							Integer.parseInt(currentSchool[13]),
							//SocialScale
							Integer.parseInt(currentSchool[14]),
							//QualityOfLife
							Integer.parseInt(currentSchool[15])));
				}
			}
		}
		
		}
		return returnSchools;	
	}
	
	public List<Person> getPeople(){
		String[][] users = library.user_getUsers();
		List<Person> returnPersons = new ArrayList<Person>();
		for(String[] currentUser:users){
			if(currentUser[4].charAt(0)=='u'){
				User returnUser = new User();
				returnUser.setFirstName(currentUser[0]);
				returnUser.setLastName(currentUser[1]);
				returnUser.setUsername(currentUser[2]);
				returnUser.setPassword(currentUser[3]);
				returnPersons.add(returnUser);
			}
			else{ //isAdmin
			Admin returnAdmin = new Admin();
			returnAdmin.setFirstName(currentUser[0]);
			returnAdmin.setLastName(currentUser[1]);
			returnAdmin.setUsername(currentUser[2]);
			returnAdmin.setPassword(currentUser[3]);
			returnPersons.add(returnAdmin);
			}	
		}
		return returnPersons;
	}

	public boolean addPerson(String firstName, String lastName, String password, String username){
		Person p = this.findByUserName(username);
		if(!(p==null)) return false;
		else{
			int i = library.user_addUser(firstName,lastName,username,password,'u');
			if(i==-1) return false;
			else return true;
		}
	}
	
	public boolean activate(User u){
		Person p = this.findByUserName(u.getUsername());
		int i = library.user_editUser(p.getUsername(),p.getFirstName(),p.getLastName(),p.getPassword()
				,'u','Y');
		if(i==-1) return false;
		else return true;
	
	}
	
	//True if active
	public char getActiveState(Person p){
		String[][] persons = library.user_getUsers();
		for(String[] personInfo:persons){
			if(p.getUsername().equals(personInfo[2])){
				return personInfo[5].charAt(0);
			}
		}
		return 'e'; //Person not found. Make sure to catch.
	}
	
	//Should this update person in general? Can an admin update an admin?
	public boolean updatePerson(Person person,String firstName, String lastName, String password){
		int i = -1;
		if(person.getIsAdmin()){
			i = library.user_editUser(person.getUsername(),firstName,
					lastName,password,'a',this.getActiveState(person));
		}
		else{ //person is User:
			i = library.user_editUser(person.getUsername(),firstName,
					lastName,password,'u',this.getActiveState(person));
		}
		if(i==-1) return false;
		else return true;
	}
	
	public boolean logOut(Person p){
	//TODO
		return false;
	}
	
	public boolean logInPerson(Person p){
		//TODO
		return false;
	}
	
	public boolean updateSchool(School s, String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
		//TODO
		return false;
	}	
	
	public boolean deactivate(Person p){
		Person h = this.findByUserName(p.getUsername());
		int i = library.user_editUser(h.getUsername(),h.getFirstName(),h.getLastName(),h.getPassword()
				,'u','N');
		if(i==-1) return false;
		else return true;
	}
	
	public List<School> getSavedSchools(){
		String[][] schools = library.university_getUniversities();
		List<School> returnSchools = new ArrayList<School>();
			for(String[] currentSchool:schools){
					returnSchools.add(new School(
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
							Double.parseDouble(currentSchool[5]),
							//SATVerbal
							Double.parseDouble(currentSchool[6]),
							//SATMath
							Double.parseDouble(currentSchool[7]),
							//Expenses
							Double.parseDouble(currentSchool[8]),
							//PercentFincancialAid
							Double.parseDouble(currentSchool[9]),
							//NumberOfApplicants
							Integer.parseInt(currentSchool[10]),
							//PercentAdmitted
							Double.parseDouble(currentSchool[11]),
							//PercentEnrolled
							Double.parseDouble(currentSchool[12]),
							//AcademicsScale
							Integer.parseInt(currentSchool[13]),
							//SocialScale
							Integer.parseInt(currentSchool[14]),
							//QualityOfLife
							Integer.parseInt(currentSchool[15])));
			}
		return returnSchools;
		}
		

	}
