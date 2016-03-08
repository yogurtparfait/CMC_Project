import java.util.List;

public class PersonController {
	
	private Person thisPerson;
	public PersonController(){}
	public PersonController(Person p){
		this.thisPerson = p;
	}
	
	public personUI logOn(String username, String password, boolean steal){
		//Steal does nothing.
		
		User foundUser = DBController.findByUserName(username);
		if(password.equals(foundUser.getPassword())){
			if(DBController.logInPerson(foundUser)){
				if(foundUser.getIsAdmin()){
					return new AdminUI(foundUser);
				}
				else //Person is user 
					{ return new UserUI(foundUser);
					}
			}
			else return null;//make sure to catch this
				
			
		}
	
			
		return false;
	}
	
	public boolean logOut(){
		if(this.thisPerson==null) return false
			else return DBController.logOut(this.thisPerson);
	}
	
	
	public void assignPerson(Person p){
		this.thisPerson = p;
	}
}
