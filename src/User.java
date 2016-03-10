
public class User extends Person{

	private School[] savedSchools;
	
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
