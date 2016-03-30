package interfaces;

import entities.*;
import controllers.*;
/**
 * @author Megan Jordan
 *
 */
public class PersonUI {

	private PersonController controller;

	
	/**
	 * creates new PersonUI and  initializes new PersonController to belong to PersonUI 
	 */
	public PersonUI() {
		this.controller = new PersonController(new Person());
	}
		
		/**
		 * Logs person on by verifying username and password and returning correct ui instance for driver to interact with
		 * @param username
		 * @param password
		 * @param steal
		 * @return true on sucess
		 */
		public PersonUI logOn(String username, String password, boolean steal){
			return this.controller.logOn(username,password,steal);
		}
		/**
		 * logs person out   
		 * @return true on success
		 */
		public boolean logOut(){
			return this.controller.logOut();
		}
		/**
		 * checks if person is active or not
		 * @param p
		 * @return a for active person d for deactivated
		 */
		public char getActiveState(Person p){
			return this.controller.getActiveState(p);
			
		}
		/**
		 * gets school from database with given name
		 * @param name
		 * @return school with name
		 */
		public School getSchoolByName(String name){
			return this.controller.getSchoolByName(name);
		}
}
	


