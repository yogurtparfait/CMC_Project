package entities;

/**
 * @author Megan Noah Yang Jordan
 *
 */
public class User extends Person{

	private School[] savedSchools;
	
	
	/**
	 * creates user and makes sure it is set to not be admin
	 */
	public User(){
		super.setIsAdmin(false);
	}
	
	public User(String firstName, String lastName, String username, String password){
		super.setIsAdmin(false);
		super.setFirstName(firstName);
		super.setLastName(lastName);
		super.setUsername(username);
		super.setPassword(password);
	}
	/**
	 * @return the savedSchools
	 */
	public School[] getSavedSchools() {
		return savedSchools;
	}

	/**
	 * @param savedSchools the savedSchools to set
	 */
	public void setSavedSchools(School[] savedSchools) {
		this.savedSchools = savedSchools;
	}


}
