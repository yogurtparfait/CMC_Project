package controllers;
import java.util.List;

import entities.*;
import interfaces.*;
/**
 * @author Megan Noah Yang Jordan
 *
 */
public class SearchController {

	private DBController database;
	/**
	 * creates new searchcontroller and initializes DBController instance
	 */
	public SearchController(){
		database = new DBController();
	}
	
	/**
	 * Searches Database for schools matching parameters
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
		
	
		return database.search(name, state, location, control, numStudents, percentFemale, 
				SATVerb, SATMath, expenses, percentFinancialAid, numberOfApplicants, percentAdmitted, 
				percentEnrolled, academicsScale, socialScale, qualityOfLifeScale, emphases);
	}
	
	/**
	 * gets list of schools closest to provided school
	 * @param s school recommendations will match           
	 * @return list of recommended schools related to s
	 */
	public List<School> recommendations(School s){
		return database.recommendations(s);
	}
}
