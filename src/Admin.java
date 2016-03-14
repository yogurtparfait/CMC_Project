
public class Admin extends Person{
	public Admin(){
		super.setIsAdmin(true);
	}
	public Admin(String firstName, String lastName, String username, String password){
		super.setIsAdmin(true);
		super.setFirstName(firstName);
		super.setLastName(lastName);
		super.setUsername(username);
		super.setPassword(password);
	}

}
