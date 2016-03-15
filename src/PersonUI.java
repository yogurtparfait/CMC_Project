
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
		public char getActiveState(Person p){
			return this.controller.getActiveState(p);
			
		}
		public School getSchoolByName(String name){
			return this.controller.getSchoolByName(name);
		}
}
	


