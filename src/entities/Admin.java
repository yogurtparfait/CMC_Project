package entities;

/** The Admin class just creates an Admin as an object
 * @author Noah, Megan, Jordan, Yang
 *
 */


public class Admin extends Person{
	/**
	 * Default constructor for Admin
	 */
	public Admin(){
		super.setIsAdmin(true);
	}
	
	/** The Admin constructor for Admins.
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 */
	public Admin(String firstName, String lastName, String username, String password){
		super.setIsAdmin(true);
		super.setFirstName(firstName);
		super.setLastName(lastName);
		super.setUsername(username);
		super.setPassword(password);
	}

}
