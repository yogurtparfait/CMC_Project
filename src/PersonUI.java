
public class PersonUI {

	private PersonController controller;

	public PersonUI() {
		this.controller = new PersonController(new Person());
	}
		
		public PersonUI logOn(String username, String password, boolean steal){
			return this.controller.logOn(username,password,steal);
		}
		public boolean logOut(){
			return this.controller.logOut();
		}
		}
	


