
public class PersonUI {

	public PersonUI() {
		
		public PersonController controller;
		public Person thisPerson;
		
		public boolean logOn(){
			return this.controller.logOn(String u, String password, boolean steal);
		}
		public boolean logOut(person p){
			
			if(this.thisPerson==null)
				return false;
			else
				return this.controller.logOut(person);
		}
		}
	}

}
