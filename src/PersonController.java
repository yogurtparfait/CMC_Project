import java.util.List;

public class PersonController {
	
	private Person thisPerson;
	private DBController database;
	public PersonController(){}
	public PersonController(Person p){
		this.thisPerson = p;
		this.database=new DBController();
	}
	
	public PersonUI logOn(String username, String password, boolean steal){
		//Steal does nothing.
		
		Person foundPerson = database.findByUserName(username);
		if(password.equals(foundPerson.getPassword())){
			if(database.logInPerson(foundPerson)){
				if(foundPerson.getIsAdmin()){
					return new AdminUI((Admin)foundPerson);
				}
				else //Person is user 
					{ return new UserUI((User)foundPerson);
					}
			}
			else return null;//make sure to catch this
				
			
		}
	
			
		return null;//make sure to catch this
	}
	
	public boolean logOut(){
		if(this.thisPerson==null) return false;
			else return database.logOut(this.thisPerson);
	}
	
	
	public void assignPerson(Person p){
		this.thisPerson = p;
	}
	public char getActiveState(Person p)
	{
		return database.getActiveState(p);
	}
	public School getSchoolByName(String name){
		return database.getSchoolByName(name);
	}
}
