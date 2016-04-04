package controllers;
import java.util.List;

import entities.*;
import interfaces.*;

/**
 * @author Yang, Megan, Jordan, Noah
 *
 */
public class AdminController extends PersonController{
	
	private Admin thisAdmin;
	private DBController database;
	/**
	 * @param a administrator currently interacting
	 */
	public AdminController(Admin a) {
		this.thisAdmin = a;
		database = new DBController();
	}
	/**
	 * adds school to db
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
	 * @return true for success
	 */
	public boolean addSchool(String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
	
				return  database.createSchool(name,state,location,control,
						numStudents,percentFemale,SATVerb,SATMath,expenses,
						percentFinancialAid,numberOfApplicants,percentAdmitted,
						percentEnrolled,academicsScale,socialScale,qualityOfLifeScale);
	
	}
			/**
			 * Gets all the people so admin can manage them
			 * @return list of people with accounts
			 */
			public List<Person> getPeople(){
				return database.getPeople();
			}
			
			/**
			 * Creates a new person and enters them in the db
			 * @param firstName
			 * @param lastName
			 * @param password
			 * @param username
			 * @param type
			 * @return true on success
			 */
			public boolean addPerson(String firstName, String lastName, String password, String username, char type){
				if(!(type=='a'||type=='u')) return false;
				return database.addPerson(firstName, lastName, password,username, type);
			}
			
			/**
			 * Gets a person so they can be viewed or edited
			 * @param username
			 * @return Person with corresponding username
			 */
			public Person getPersonByUsername(String username)
			{
				return database.findByUserName(username);
			}
			
			/**
			 * Changes an active person to deactivated and a deactivated person to active
			 * @param p Person whose status will change
			 * @return true on success
			 */
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
			
			/**
			 * Sets fields of existing person database entry to new values
			 * @param person Person to be updated
			 * @param firstName
			 * @param lastName
			 * @param password
			 * @param type
			 * @return true on success
			 */
			public boolean updatePerson(Person person, String firstName, String lastName, String password, String type){
				return database.updatePerson(person, firstName, lastName, password);
			}
			
			/**
			 * Sets fields of existing school database entry to new values
			 * 
			 * @param s School to be updated
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
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale,
			String[] emphases){
				database.updateSchool(s, name, state, location, control, numStudents, 
						percentFemale, SATVerb, SATMath, expenses, percentFinancialAid, 
						numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale, emphases);
				
			}
			
			/**
			 * gets a list of all the schools in the database so they can be managed
			 * @return list of schools in database
			 */
			public List<School> getSchools(){
				return database.getSchools();
			}
			/* (non-Javadoc)
			 * @see PersonController#getSchoolByName(java.lang.String)
			 */
			public School getSchoolByName(String name){
				return database.getSchoolByName(name);
			}
}
