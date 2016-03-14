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
		
	public List<School> search(String name,String state,String location,String control,
			int numStudents,double percentFemale,double SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
	

		String[][] schools = library.university_getUniversities();
		List<School> returnSchools = new ArrayList<School>();
		

			for(String[] currentSchool:schools){
				if(
							//name
							(currentSchool[0]== name || name==null) &&
							//state
							(currentSchool[1]== state || state==null) &&
							//location
							(currentSchool[2]== location || location==null) &&
							//control
							(currentSchool[3]== control || control==null) &&
							//numberOfStudents
							(Integer.parseInt(currentSchool[4])== numStudents || numStudents==-1) &&
							//PercentFemale
							(Double.parseDouble(currentSchool[5])== percentFemale || percentFemale==-1) &&
							//SATVerbal
							(Double.parseDouble(currentSchool[6])== SATVerb || SATVerb==-1) &&
							//SATMath
							(Double.parseDouble(currentSchool[7])== SATMath || SATMath==-1) &&
							//Expenses
							(Double.parseDouble(currentSchool[8])== expenses || expenses==-1) &&
							//PercentFincancialAid
							(Double.parseDouble(currentSchool[9])== percentFinancialAid || percentFinancialAid==-1) &&
							//NumberOfApplicants
							(Integer.parseInt(currentSchool[10])== numberOfApplicants || numberOfApplicants==-1) &&
							//PercentAdmitted
							(Double.parseDouble(currentSchool[11])== percentAdmitted || percentAdmitted==-1) &&
							//PercentEnrolled
							(Double.parseDouble(currentSchool[12])== percentEnrolled || percentEnrolled==-1) &&
							//AcademicsScale
							(Integer.parseInt(currentSchool[13])== academicsScale || academicsScale==-1) &&
							//SocialScale
							(Integer.parseInt(currentSchool[14])== socialScale || socialScale==-1) &&
							//QualityOfLife
							(Integer.parseInt(currentSchool[15])== qualityOfLifeScale || qualityOfLifeScale==-1)) {
					

					returnSchools.add(new School(
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
			return returnSchools;
				}
			
		

	
	
	public List<School> recommendations(School s){
		String[][] schools = library.university_getUniversities();
		List<School> returnSchools = new ArrayList<School>();
		School[] schoolList = new School[300];
		double[] searchVector = new double[15];
		double[] foundVector = new double[15];
		double total = 0;
		School holder; //placeholder for sorting, total is used for the doubles.
		int counter = 0;
		
			//calculates the difference vector
			for(String[] currentSchool:schools){
				
							//name
									if(currentSchool[0].equals(s.getName())) searchVector[0] = 0;
									else searchVector[0] = 1;
							//state
									if(currentSchool[1].equals(s.getState())) searchVector[1] = 0;
									else searchVector[1] = 1;
							//location
									if(currentSchool[2].equals(s.getLocation())) searchVector[2] = 0;
									else searchVector[2] = 1;
							//control
									if(currentSchool[3].equals(s.getName())) searchVector[3] = 0;
									else searchVector[3] = 1;
							//numberOfStudents
									searchVector[4] = Math.abs(Double.parseDouble(currentSchool[4]) - s.getNumStudents())/s.getNumStudents();
							//PercentFemale
									searchVector[5] = Math.abs(Double.parseDouble(currentSchool[5]) - s.getPercentFemale())/s.getPercentFemale();
							//SATVerbal
									searchVector[6] = Math.abs(Double.parseDouble(currentSchool[6]) - s.getSATVerb())/s.getSATVerb();
							//SATMath
									searchVector[7] = Math.abs(Double.parseDouble(currentSchool[7]) - s.getSATMath())/s.getSATMath();
							//Expenses
									searchVector[8] = Math.abs(Double.parseDouble(currentSchool[8]) - s.getExpenses())/s.getExpenses();
							//PercentFincancialAid
									searchVector[9] = Math.abs(Double.parseDouble(currentSchool[9]) - s.getPercentFinancialAid())/s.getPercentFinancialAid();
							//NumberOfApplicants
									searchVector[10] = Math.abs(Double.parseDouble(currentSchool[10]) - s.getNumberOfApplicants())/s.getNumberOfApplicants();
							//PercentAdmitted
									searchVector[11] = Math.abs(Double.parseDouble(currentSchool[11]) - s.getPercentAdmitted())/s.getPercentAdmitted();
							//PercentEnrolled
									searchVector[12] = Math.abs(Double.parseDouble(currentSchool[12]) - s.getPercentEnrolled())/s.getPercentEnrolled();
							//AcademicsScale
									searchVector[13] = Math.abs(Double.parseDouble(currentSchool[13]) - s.getAcademicsScale())/s.getAcademicsScale();
							//SocialScale
									searchVector[14] = Math.abs(Double.parseDouble(currentSchool[14]) - s.getSocialScale())/s.getSocialScale();
							//QualityOfLife
									searchVector[15] = Math.abs(Double.parseDouble(currentSchool[15]) - s.getQualityOfLifeScale())/s.getQualityOfLifeScale();

									total = 0;
									for(double d:searchVector){
										total = total + d;
									}
									foundVector[counter] = total;
									
									schoolList[counter++] = (new School(
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
			//Found vector now has distances for each school.
			//to find the closest five:
			
			for(int i = 0;i<foundVector.length;i++){
				for(int j = 0;j<foundVector.length;j++){
					if(foundVector[i]>foundVector[i+1]){
						total = foundVector[i+1];
						holder = schoolList[i+1];
						foundVector[i+1] = foundVector[i];
						schoolList[i+1] = schoolList[i];
						foundVector[i] = foundVector[i+1];
						schoolList[i+1] = schoolList[i];
					}
					}
			}
			
			//schoolList is now sorted shortest to longest.
			
			for(int i = 0;i<5;i++){
				returnSchools.add(schoolList[i]);
			}
			return returnSchools;
			
			}
	}
