package interfaces;
import java.util.List;

import controllers.*;
import entities.*;
/**
 * @author Megan, Jordan, Noah, Yang
 * User Interface for people logged in as Admins
 */
public class AdminUI extends PersonUI {

	public AdminController controller;
	/**
	 * @param a Administrator currently logged in
	 */
	public AdminUI(Admin a) {
		this.controller = new AdminController(a);
	}
	/**
	 *  Creates a new school and enters them in the db
	 * 
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
	 */
	public void addSchool(String name,String state,String location,String control,
	int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
	double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
	double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
		this.controller.addSchool(name,state,location,control,
				numStudents,percentFemale,SATVerb,SATMath,expenses,
				percentFinancialAid,numberOfApplicants,percentAdmitted,
				percentEnrolled,academicsScale,socialScale,qualityOfLifeScale);
	}
	/**
	 * gets all people in database
	 * @return list of all people in db
	 */
	public List<Person> getPeople(){
		return this.controller.getPeople();	
	}
	/**
	 * gets person from database that has specific username
	 * @param username  username of person to be found
	 * @return person with correct username
	 */
	public Person getPersonByUsername(String username){
		return this.controller.getPersonByUsername(username);
	}
	
	/**
	 * Creates new person and adds them to database
	 * 
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param username
	 * @param type
	 * @return true on success
	 */
	public boolean addPerson(String firstName, String lastName, String password, String username, char type){
		return this.controller.addPerson(firstName,lastName,password,username,type);	
	}
	/**
	 * Activates a person who is deactivated and deactivates an activer person
	 * @param p person to be activated or deactivated
	 */
	public void changeStatus(Person p){
		this.controller.changeStatus(p);	
	}
	
	/**
	 * Changes fields in existing person according to parameters
	 * @param person Person to be updated
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param type
	 * @return
	 */
	public boolean updatePerson(Person person, String firstName, String lastName, String password, String type){
		return this.controller.updatePerson(person, firstName,lastName,password,type);	
	}
	/**
	 * Changes fields in existing school according to parameters
	 * 
	 * @param s school to be updated
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
	 */
	public void updateSchool(School s, String name,String state,String location,String control,
	int numStudents,double percentFemale,double SATVerb,double SATMath,double expenses,
	double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
	double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale, String[] emphases){
		this.controller.updateSchool(s,name,state,location,control,
				numStudents,percentFemale,SATVerb,SATMath,expenses,
				percentFinancialAid,numberOfApplicants,percentAdmitted,
				percentEnrolled,academicsScale,socialScale,qualityOfLifeScale, emphases);
	}
	/**
	 * Gets list of schools that are in the db so they can be managed
	 * 
	 * @return list of schools in database
	 */
	public List<School> getSchools(){
		return this.controller.getSchools();
	}
	/* (non-Javadoc)
	 * @see PersonUI#getSchoolByName(java.lang.String)
	 */
	public School getSchoolByName(String name){
		return this.controller.getSchoolByName(name);
	}
}
