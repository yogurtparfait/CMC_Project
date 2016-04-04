package controllers;
import java.util.ArrayList;
import java.util.List;
import dblibrary.project.csci230.*;
import entities.*;

/**
 * Controller for the Database, that includes all of the functionalities.
 * @author Noah, Megan, Jordan, Yang
 */




public class DBController { 
	
	
	private UniversityDBLibrary library;
	
	/**
	 *  Constructor for the DBController.
	 */
	public DBController() {
		this.library = new UniversityDBLibrary("yogurtparf","yogurtparf","jmny4");
	}
	
	/** unsaves the school of the user.
	 * @param u
	 * @param s
	 * @return
	 */
	public boolean unSaveSchool(User u, School s){
		int i = library.user_removeSchool(u.getUsername(),s.getName());
		if(i<1) return false;
		return true;
	}
	
	/** Adds a school to the library
	 * @param u user
	 * @param s school
	 * @return
	 */
	public boolean addSavedSchool(User u, School s){
		int i = library.user_saveSchool(u.getUsername(),s.getName());
		if(i<1) return false;
		return true;

	}

	/** Finds a person by their username.
	 * @param username
	 * @return
	 */
	public Person findByUserName(String username){
		String[][] users = library.user_getUsers();
		for(String[] currentUser:users){
			if(currentUser[2].equals(username)){
				if(currentUser[4].charAt(0)=='u'){
					User returnUser = new User();
					//System.out.println("firstname: " + currentUser[0]);
					returnUser.setFirstName(currentUser[0]);
					//System.out.println("lastname: " + currentUser[1]);
					returnUser.setLastName(currentUser[1]);
					//System.out.println("Username: " + currentUser[2]);
					returnUser.setUsername(currentUser[2]);
					//System.out.println("Password: " + currentUser[3]);
					returnUser.setPassword(currentUser[3]);
					return returnUser;
				}
				else{ //isAdmin
				Admin returnAdmin = new Admin();
				//System.out.println("firstname: " + currentUser[0]);
				returnAdmin.setFirstName(currentUser[0]);
				//System.out.println("lastname: " + currentUser[1]);
				returnAdmin.setLastName(currentUser[1]);
				//System.out.println("Username: " + currentUser[2]);
				returnAdmin.setUsername(currentUser[2]);
				//System.out.println("Password: " + currentUser[3]);
				returnAdmin.setPassword(currentUser[3]);
				return returnAdmin;
				}				
			}
		}
		return null;
		}
	
	
	/** Creates a school.
	 * @param name 
	 * @param state 
	 * @param location
	 * @param control
	 * @param numStudents
	 * @param percentFemale 
	 * @param d
	 * @param SATMath
	 * @param expenses
	 * @param percentFinancialAid
	 * @param numberOfApplicants
	 * @param percentAdmitted
	 * @param percentEnrolled
	 * @param academicsScale
	 * @param socialScale
	 * @param qualityOfLifeScale
	 * @return
	 */
	public boolean createSchool(String name,String state,String location,String control,
			int numStudents,double percentFemale,double SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
		
		int i = library.university_addUniversity(name, state, location, control, numStudents,
				percentFemale, SATVerb, SATMath, expenses, percentFinancialAid, numberOfApplicants,
				percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
		if(i==-1) return false;
		return true;
		
	}
	
	/** Returns a list of the user schools.
	 * @param u User
	 * @return
	 */
	public List<School> getUserSchools(User u){
		String[][] userSchools = library.user_getUsernamesWithSavedSchools();
		String[][] schools = library.university_getUniversities();
		List<School> returnSchools = new ArrayList<School>();
		for(String[] currentUsername:userSchools){
		if(currentUsername[0].equals(u.getUsername())){
			for(String[] currentSchool:schools){
				if(currentUsername[1].equals(currentSchool[0])){
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
		}
		
		}
		return returnSchools;	
	}
	
	/** Retruns list of persons that are users.
	 * @return 
	 */
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

	/** Adds a person to the user library. 
	 * @param firstName First name of person
	 * @param lastName Last name of person
	 * @param password Password of person
	 * @param username username of person
	 * @return
	 */
	public boolean addPerson(String firstName, String lastName, String password, String username,char type){
		
		Person p = this.findByUserName(username);
		if(!(p==null)) {
			return false;
			
		}
		
		else{
			int i = library.user_addUser(firstName,lastName,username,password,type);
			if(i<1) return false;

			
			else return true;
		}
	}
	
	/**
	 *  Checks to see if the persons account is active.
	 * @param u Person 
	 * @return
	 */
	public boolean activate(Person u){
		Person p = this.findByUserName(u.getUsername());
		int i = library.user_editUser(p.getUsername(),p.getFirstName(),p.getLastName(),p.getPassword()
				,'u','Y');
		if(i==-1) return false;
		else return true;
	
	}
	
	//True if active
	/** Gets the active state of the person
	 * @param p
	 * @return
	 */
	public char getActiveState(Person p){
		String[][] persons = library.user_getUsers();
		for(String[] personInfo:persons){
			if(p.getUsername().equals(personInfo[2])){
				return personInfo[5].charAt(0);
			}
		}
		return 'e'; //Person not found. Make sure to catch. ERROR
	}
	
	//Should this update person in general? Can an admin update an admin?
	/** Updates the person info
	 * @param person
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @return
	 */
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
		if(i<1) return false;
		else return true;
	}
	
	//for steal
	/** Logouts the person.
	 * @param p
	 * @return
	 */
	public boolean logOut(Person p){
	//TODO
		return true;
	}
	
	//for steal
	/** Logs in the person and checks if availabale to steal. 
	 * @param p
	 * @return
	 */
	public boolean logInPerson(Person p){
		//TODO Has to do stealing. 
		return true;
	}
	
	/** Updates the school.
	 * @param s
	 * @param name
	 * @param state
	 * @param location
	 * @param control
	 * @param numStudents
	 * @param percentFemale
	 * @param SATVerb
	 * @param SATMath
	 * @param expenses
	 * @param percentFinancialAid
	 * @param numberOfApplicants
	 * @param percentAdmitted
	 * @param percentEnrolled
	 * @param academicsScale
	 * @param socialScale
	 * @param qualityOfLifeScale
	 * @param emphases
	 * @return
	 */
	public boolean updateSchool(School s, String name,String state,String location,String control,
			int numStudents,double percentFemale,double SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
		
		int i = library.university_editUniversity(name, state, location, control, numStudents, 
				percentFemale, SATVerb, SATMath, expenses, percentFinancialAid, numberOfApplicants, 
				percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
		
		if(i<1) return false;
		
		/*
		for(String e:emphases){
			int j = library.university_addUniversityEmphasis(name,e);
			if(j==-1) return false;
			
		}
		*/
		return true;
	}	
	
	//Override with emphases:
	public boolean updateSchool(School s, String name,String state,String location,String control,
			int numStudents,double percentFemale,double SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale, String[] emphases){
		
		int i = library.university_editUniversity(name, state, location, control, numStudents, 
				percentFemale, SATVerb, SATMath, expenses, percentFinancialAid, numberOfApplicants, 
				percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
		
		if(i<1) return false;
		
		/*
		for(String e:emphases){
			int j = library.university_addUniversityEmphasis(name,e);
			if(j==-1) return false;
			
		}
		*/
		return true;
	}	
	
	/** Deactivates a person.
	 * @param p
	 * @return
	 */
	public boolean deactivate(Person p){
		Person h = this.findByUserName(p.getUsername());
		int i = library.user_editUser(h.getUsername(),h.getFirstName(),h.getLastName(),h.getPassword()
				,'u','N');
		if(i==-1) return false;
		else return true;
	}
	
	/** Returns a list of schools 
	 * @return
	 */
	public List<School> getSchools(){
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
		
	/** Searchs for a school by name.
	 * @param name
	 * @return
	 */
	public School findBySchoolName(String name){
		String[][] schools = library.university_getUniversities();
		for(String[] currentSchool:schools){
		if(currentSchool[0].equals(name)) 
			return new School(
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
					Integer.parseInt(currentSchool[15]));
			
		}
		return null;
	}


	/** Searchs for a school by name. 
	 * @param name
	 * @return
	 */
	public School getSchoolByName(String name){
		String[][] schools = library.university_getUniversities();
		for(String[] currentSchool:schools){
			if(currentSchool[0].equals(name))
				return new School(
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
						Integer.parseInt(currentSchool[15]));
		}
		return null;
		}
	
	/** Search method. 
	 * @param name
	 * @param state
	 * @param location
	 * @param control
	 * @param numStudents
	 * @param percentFemale
	 * @param SATVerb
	 * @param SATMath
	 * @param expenses
	 * @param percentFinancialAid
	 * @param numberOfApplicants
	 * @param percentAdmitted
	 * @param percentEnrolled
	 * @param academicsScale
	 * @param socialScale
	 * @param qualityOfLifeScale
	 * @param emphases
	 * @return
	 */
	public List<School> search(String name,String state,String location,String control,
			int numStudents,double percentFemale,double SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale,
			String[] emphases){
	
		String[][] currentEmphases;
		boolean emphasesEqual = true;
		boolean emphasisFound = false;
		String[][] schools = library.university_getUniversities();
		List<School> returnSchools = new ArrayList<School>();
		

			for(String[] currentSchool:schools){
				currentEmphases = library.university_getNamesWithEmphases();
				
				//Checks Emphases
				for(String t:emphases){
					for(String[] s:currentEmphases){
						if((s[0].equals(name))&&(s[1].equals(t))){
							emphasisFound = true;
						}	
					}
					if(emphasisFound) emphasesEqual = true;
					else{
						emphasesEqual = false;
						break;
					}
				}
				
				
				if(
							//name
							(currentSchool[0].equals(name) || name.equals("")) &&
							//state
							(currentSchool[1].equals(state) || state.equals("")) &&
							//location
							(currentSchool[2].equals(location) || location.equals("")) &&
							//control
							(currentSchool[3].equals(control) || control.equals("")) &&
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
							(Integer.parseInt(currentSchool[15])== qualityOfLifeScale || qualityOfLifeScale==-1)&&
							//Emphases
							emphasesEqual)
							
				
				{
					

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
			
		

	
	
	/** Returns a list of schools(recommended)
	 * @param s
	 * @return
	 */
	public List<School> recommendations(School s){
		String[][] schools = library.university_getUniversities();
		List<School> returnSchools = new ArrayList<School>();
		School[] schoolList = new School[1000];
		double[] searchVector = new double[16];
		double[] foundVector = new double[1800];
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
	
			for(int i = 0;i<foundVector.length-1;i++){
				for(int j = 0;j<foundVector.length;j++){
					if(foundVector[i]<foundVector[0]){
						total = foundVector[0];
						holder = schoolList[0];
						foundVector[0] = foundVector[i];
						schoolList[0] = schoolList[i];
						foundVector[i] = foundVector[5];
						schoolList[i] = schoolList[5];
						foundVector[5] = foundVector[4];
						schoolList[5] = schoolList[4];
						foundVector[4] = foundVector[3];
						schoolList[4] = schoolList[3];
						foundVector[3] = foundVector[2];
						schoolList[3] = schoolList[2];
						foundVector[2] = foundVector[1];
						schoolList[2] = schoolList[1];
						foundVector[1] = total;
						schoolList[1] = holder;
						}
					else if(foundVector[i]<foundVector[1]){
						total = foundVector[1];
						holder = schoolList[1];
						foundVector[1] = foundVector[i];
						schoolList[1] = schoolList[i];
						foundVector[i] = foundVector[5];
						schoolList[i] = schoolList[5];
						foundVector[5] = foundVector[4];
						schoolList[5] = schoolList[4];
						foundVector[4] = foundVector[3];
						schoolList[4] = schoolList[3];
						foundVector[3] = foundVector[2];
						schoolList[3] = schoolList[2];
						foundVector[2] = total;
						schoolList[2] = holder;
						}
					else if(foundVector[i]<foundVector[2]){
						total = foundVector[2];
						holder = schoolList[2];
						foundVector[2] = foundVector[i];
						schoolList[2] = schoolList[i];
						foundVector[i] = foundVector[5];
						schoolList[i] = schoolList[5];
						foundVector[5] = foundVector[4];
						schoolList[5] = schoolList[4];
						foundVector[4] = foundVector[3];
						schoolList[4] = schoolList[3];
						foundVector[3] = total;
						schoolList[3] = holder;
						}
					else if(foundVector[i]<foundVector[3]){
						total = foundVector[3];
						holder = schoolList[3];
						foundVector[3] = foundVector[i];
						schoolList[3] = schoolList[i];
						foundVector[i] = foundVector[5];
						schoolList[i] = schoolList[5];
						foundVector[5] = foundVector[4];
						schoolList[5] = schoolList[4];
						foundVector[4] = total;
						schoolList[4] = holder;
						}
					else if(foundVector[i]<foundVector[4]){
						total = foundVector[4];
						holder = schoolList[4];
						foundVector[4] = foundVector[i];
						schoolList[4] = schoolList[i];
						foundVector[i] = foundVector[5];
						schoolList[i] = schoolList[5];
						foundVector[5] = total;
						schoolList[5] = holder;
						}
					else if(foundVector[i]<foundVector[5]){
						total = foundVector[5];
						holder = schoolList[5];
						foundVector[5] = foundVector[i];
						schoolList[5] = schoolList[i];
						foundVector[i] = total;
						schoolList[i] = holder;
						}
			}}
			//schoolList is now sorted shortest to longest.
			//doesn't return school at spot 1, since the closest school is always itself.
			for(int i = 1;i<6;i++){
				returnSchools.add(schoolList[i]);
			}
			
			return returnSchools;
			
			}
	public boolean deleteSchool(String schoolName){
		int i = library.university_deleteUniversity(schoolName);
		if(i==-1) return false;
		return true;
	}
	public boolean deletePerson(String username){
		int i = library.user_deleteUser(username);
		if(i==-1) return false;
		return true;
	}
	}
