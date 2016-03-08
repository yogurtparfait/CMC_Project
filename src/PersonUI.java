
public class PersonUI {

	public PersonUI() {
		
		public PersonController controller;

		
		public boolean logOn(){
			return this.controller.logOn(String u, String password, boolean steal);
		}
		public boolean logOut(){
			this.controller.logOut();
		}
		}
	}

}
