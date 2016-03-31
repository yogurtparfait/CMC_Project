package entities;

/**
 * @author Megan Noah Jordan Yang
 *
 */
public class Person {

	private String firstName; 
	private String lastName;
	private String password;
	private String username;
	//IsLoggedOn currently does nothing
	private boolean isLoggedOn;
	private boolean isAdmin;

	
	
	
	/**
	 * gets password
	 * @return password of person
	 */
	public String getPassword(){
		return this.password;
	}

	/**
	 * gets first name
	 * @return the firstName of a person
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName of person
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @param b whether person is an administrator
	 */
	public void setIsAdmin(boolean b){
		this.isAdmin = b;
	}
	
	/**
	 * @return  isAdmin
	 */
	public boolean getIsAdmin(){
		return this.isAdmin;
	}

}