package controllers;

import java.util.ArrayList;
import java.util.List;
import entities.*;
import interfaces.*;

/**
 * @author Megan Jordan Noah Yang
 *
 */
public class UserController {
	private User thisUser;
	private DBController database;
	private SearchController search;
	/**
	 * creates new usercontroller and initializes instances of dbcontroller and searchcontroller for it to use
	 * @param u
	 */
	public UserController(User u) {
		this.thisUser = u;
		database = new DBController();
		search = new SearchController();
	}
	
	/**
	 * 
	 * @return list of schools user has saved
	 */
	public List<School> getSavedSchools(){
		return  database.getUserSchools(this.thisUser);
	}
	
	/**
	 * @param s school to display info of
	 * @return list of strings of school's info
	 */
	public List<String> displaySchoolInfo(School s){
		List<String> returnString = new ArrayList<String>();
		
		returnString.add(s.getName());
		returnString.add(s.getState());
		returnString.add(s.getLocation());
		returnString.add(s.getControl());
		returnString.add(Integer.toString(s.getNumStudents()));
		returnString.add(Double.toString(s.getPercentFemale()));
		returnString.add(Double.toString(s.getSATVerb()));
		returnString.add(Double.toString(s.getSATMath()));
		returnString.add(Double.toString(s.getExpenses()));
		returnString.add(Double.toString(s.getPercentFinancialAid()));
		returnString.add(Integer.toString(s.getNumberOfApplicants()));
		returnString.add(Double.toString(s.getPercentAdmitted()));
		returnString.add(Double.toString(s.getPercentEnrolled()));
		returnString.add(Integer.toString(s.getAcademicsScale()));
		returnString.add(Integer.toString(s.getSocialScale()));
		returnString.add(Integer.toString(s.getQualityOfLifeScale()));
		
		if(!(s.getEmphases()==null)) for(String e:s.getEmphases()){
			returnString.add(e);
			
		}
		
		return returnString;
	}
	
	/**
	 * removes a school from a user's list of saved schools
	 * @param s school to be removed from user's list of saved
	 * @return true on success
	 */
	public boolean removeSavedSchool(School s){
		return  database.unSaveSchool(this.thisUser, s);
	}
	
	/**
	 * adds a school to user's list of saved schools
	 * @param s school to be added
	 * @return true on success
	 */
	public boolean saveSchool(School s){
		return  database.addSavedSchool(this.thisUser, s);
	}
	
	/**
	 * Searches in database for schools matching parameters
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
	 * @return list of schools matching parameters
	 */
	public List<School> search(String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale,
			String[] emphases){
		return search.search(name, state, location, control, numStudents, percentFemale, 
				SATVerb, SATMath, expenses, percentFinancialAid, numberOfApplicants, percentAdmitted, 
				percentEnrolled, academicsScale, socialScale, qualityOfLifeScale, emphases);
		//Make sure to catch nulls for no schools found.
	}
	
	/**
	 * gets recommendations which are schools most similar to s
	 * @param s school to get similar schools to
	 * @return list of schools similar to s
	 */
	public List<School> getRecommendations(School s){
		return search.recommendations(s);
	}
	
	
	/**
	 * given existing user updates fields based on parameters and saves to db
	 * 
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param type
	 * @return true on success
	 */
	public boolean UpdateUser(String firstName, String lastName, String password, String type){
		return  database.updatePerson(this.thisUser, firstName, lastName, password);
	}
	
	/**
	 * @return user associated with this controller
	 */
	public User getUser(){
		return this.thisUser;
	}
}
