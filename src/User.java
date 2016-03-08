
public class User extends Person{

	private School[] savedSchools;
	public class User(){
		super.setIsAdmin(false);
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
