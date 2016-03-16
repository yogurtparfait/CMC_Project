import java.util.List;
import java.util.Scanner;

public class TextDriver {
	private Scanner sc; 
	private PersonUI ui;
	private UserUI userUI;
	private AdminUI adminUI;
	
	
	private TextDriver()
	{
		ui = new PersonUI();
	}
	
	private void setScanner(Scanner sc)
	{
		this.sc = sc;
	}
	
	public static void main(String[] args) {
		TextDriver driver = new TextDriver();
		Scanner sc = new Scanner(System.in);    //using because eclipse truncates commandline output before you can read it
		
		System.out.println("Logging in as ImadUser");
		driver.login();
		sc.nextLine();
		System.out.println("Manage People");
		driver.managePeople();
		sc.nextLine();
		System.out.println("Add Person");
		driver.addPerson();
		sc.nextLine();
		System.out.println("Edit Person");
		driver.updatePerson();
		sc.nextLine();
		System.out.println("Deactivate/Activate Person");
		driver.changeActiveStatusPerson();
		sc.nextLine();
		System.out.println("Manage People");
		driver.managePeople();
		sc.nextLine();
		System.out.println();
		System.out.println("Manage Universities");
		driver.manageSchools();
		sc.nextLine();
		System.out.println("Add University");
		driver.addUniversity();
		sc.nextLine();
		System.out.println("Edit University");
		driver.updateUniversity();
		sc.nextLine();
		System.out.println("Manage Universities");
		driver.manageSchools();
		sc.nextLine();
		System.out.println();
		System.out.println("Logging out ImadUser");
		driver.logout();
		
		sc.nextLine();
		System.out.println("Logging in as user");
		driver.loginUser();
		sc.nextLine();
		System.out.println("manage profile: ");
		driver.manageProfile();
		sc.nextLine();
		System.out.println("edit profile: ");
		driver.updateProfile();
		sc.nextLine();
		System.out.println("Manage Profile to see edit");
		driver.manageProfile();
		sc.nextLine();
		System.out.println("Search Schools");		
		driver.searchSchools();
		sc.nextLine();
		System.out.println("View School and Reccommedations");
		driver.viewSchoolAndRecommendations();
		sc.nextLine();
		System.out.println("Save School");
		driver.saveSchool();
		sc.nextLine();
		System.out.println("Manage Saved Schools");		
		driver.manageSavedSchools();
		sc.nextLine();
		System.out.println("View School");
		driver.viewSchool();
		sc.nextLine();
		System.out.println("Remove School");
		driver.removeSchool();
		sc.nextLine();
		System.out.println("Manage Saved Schools to see deleted");
		driver.manageSavedSchools();
		sc.nextLine();
		System.out.println("End of Demo");
	}
	
	public void login(){
		/*System.out.println("Enter username");		//not working correctly
		String username = sc.nextLine();			//scanner prints both enter username and enter password without 
		System.out.println("Enter password");		//waiting for the username
		String password = sc.nextLine();
		System.out.println("Steal? true or false");
		boolean steal = sc.nextBoolean();*/
		
		System.out.println("Username: ImadUser");
		System.out.println("Password: Edited ");
		String username = "ImadUser";
		String password = "Edited";
		boolean steal = true;
		System.out.println("logon result");
		ui = ui.logOn(username, password, steal);
		if (ui instanceof UserUI)
		{
			userUI = (UserUI) ui;
			System.out.println("user");
		}
		else if (ui instanceof AdminUI)
		{
			adminUI = (AdminUI) ui;
			System.out.println("admin");
		}
		else
		{
			System.out.println("Issssssuuuuue with login");
		}

	}
	public void loginUser(){
		System.out.println("Username: juser");
		System.out.println("Password: user");
		ui = ui.logOn("juser","user", true);
		if (ui instanceof UserUI)
		{
			userUI = (UserUI) ui;
			System.out.println("user");
		}
		else if (ui instanceof AdminUI)
		{
			adminUI = (AdminUI) ui;
			System.out.println("admin");
		}
		else
		{
			System.out.println("Issssssuuuuue with login");
		}
	}
	
	public void saveSchool(){
		School s1 = userUI.getSchoolByName("COOLSCHOOL");
<<<<<<< HEAD
		School s2 = userUI.getSchoolByName("WORCESTER");			//not sure if this is an actual one replace with valid
=======
		School s2 = userUI.getSchoolByName("ARIZONA STATE");	
>>>>>>> branch 'master' of https://github.com/yogurtparfait/CMC_Project.git
		userUI.saveSchool(s1);
		userUI.saveSchool(s2);
		System.out.println("Schools Saved: " + s1.getName() + ", " + s2.getName());
	}
	
	public void manageProfile(){
		User user = userUI.getUser();
		System.out.println("First Name: " + user.getFirstName());
		System.out.println("Last Name: " + user.getLastName());
		System.out.println("Username: " + user.getUsername());
		System.out.println("Password: " + user.getPassword());
		System.out.println("isAdmin: " + user.getIsAdmin() );
		
		
	}
	public void manageSchools(){
		System.out.println("U10 Manage Schools");
		if(this.adminUI ==null)
			System.out.println("not logged in as admin");
		else
		{
			List<School> schools = adminUI.getSchools();
			for(School s : schools)
			{
				System.out.print("Name: " + s.getName() + " State: " + s.getState() + " Location: " + s.getLocation());
				System.out.print(" Control: " + s.getControl() + " #of Students: " + s.getNumStudents() + " %Female: " + s.getPercentFemale());
				System.out.print(" SATverbal: " + s.getSATVerb() + " SATmath:"+ s.getSATMath() + " Expenses: " + s.getExpenses());
				System.out.print(" %with Financial Aid: " + s.getPercentFinancialAid() + " # of Applicants: " + s.getNumberOfApplicants());
				System.out.print(" %admitted: " + s.getPercentAdmitted() + " %enrolled: " + s.getPercentEnrolled() );
				System.out.print(" Academics scale: " + s.getAcademicsScale() + " Social Scale: " + s.getSocialScale() );
				System.out.print(" Quality of Life: " + s.getQualityOfLifeScale());
				System.out.println();
			}
		}
		System.out.println();
	}
	public void manageSavedSchools(){
		List <School> schools = userUI.getSavedSchools();
		for(School s: schools)
		{
			System.out.println(s.getName());
		}
		System.out.println();
	}
	
	public void searchSchools(){
		System.out.println("Searching");
		List <School> schools = userUI.search("COOLSCHOOL", "MN", "", "", -1,-1, -1, -1, -1, -1, -1,-1,-1,-1, -1,-1, new String[0]);
		System.out.println(schools.size() + " schools found");
		for (School s : schools)
		{
			System.out.println(s.getName());
		}
	}
	public void logout(){
		ui.logOut();
		System.out.println("Logged Out");
	}
	public void managePeople(){
		if(this.adminUI ==null)
			System.out.println("not logged in as admin");
		else
		{
			List<Person> people = adminUI.getPeople();
			for(Person p: people)
			{
				System.out.println("firstName: " + p.getFirstName() + " lastname: " + p.getLastName() + " username: " + 
				 p.getUsername() + " password: " + p.getPassword() + " isAdmin: " + p.getIsAdmin() + " ActiveStatus: " + adminUI.getActiveState(p));
			}
		}
	}
	public void updateProfile(){
		System.out.println("U5 Edit Profile");
		User user = userUI.getUser();
		String firstName = user.getFirstName();
		String lastName = user.getLastName() + "Edited";
		String password = user.getPassword();
		String type;
		if (user.getIsAdmin())
			 type = "a";
		else
			 type = "u";
		userUI.UpdateUser(firstName, lastName,password,type);
		System.out.println("Profile edited");
	}
	public void removeSchool(){
		School s = userUI.getSchoolByName("COOLSCHOOL");
		userUI.removeSavedSchool(s);
		System.out.println("COOLSCHOOL removed from saved schools");
	}
	public void viewSchool(){
		School s = userUI.getSchoolByName("COOLSCHOOL");
		System.out.println("Viewing " + s.getName());
		System.out.println("Name: " + s.getName());
		System.out.println("All the other stuff prints");
	}
	public void viewSearchResults(){}
	
	public void addPerson(){
		/*
		System.out.println("Enter firstname");
		String firstName = sc.nextLine();
		System.out.println("Enter lastname");
		String lastName = sc.nextLine();
		System.out.println("Enter password");
		String password = sc.nextLine();
		System.out.println("Enter username");
		String username = sc.nextLine();
		System.out.println("Enter type");
		String type = sc.nextLine();
		*/
		
		String firstName = "Super";
		String lastName = "Admin";
		String password = "password";
		String username = "SuperAdmin";
		String type = "a";
		
		System.out.println(adminUI.addPerson(firstName,lastName, password, username,type));
		
	}
	public void addUniversity(){
		System.out.println("U25 Add University");
		adminUI.addSchool("COOLSCHOOL","MN","Rural" ,"Private",
				200, 50.0, 800, 900.5, 50000,
				50.0, 7000, 50.0,
				50.0, 4, 5, 5);
		System.out.println("COOLSCHOOL added");
	}
	public void updateUniversity(){
		System.out.println("U26 Edit University" );
		School school = adminUI.getSchoolByName("COOLSCHOOL");
		System.out.println(school == null);
		adminUI.updateSchool(school, school.getName(),school.getState(),school.getLocation(),school.getControl(),
				school.getNumStudents(),school.getPercentFemale(),school.getSATVerb(),school.getSATMath()*2,school.getExpenses(),
				school.getPercentFinancialAid(),school.getNumberOfApplicants(),school.getPercentAdmitted(),
				school.getPercentEnrolled(),school.getAcademicsScale(),school.getSocialScale(),school.getQualityOfLifeScale(), school.getEmphases());
		
		
		System.out.println("COOLSCHOOL's SATMATH doubled");
	}
	public void viewSchoolAndRecommendations(){
		
		System.out.println("Viewing school and recommendations");
		School s = userUI.getSchoolByName("COOLSCHOOL");
		System.out.println("Name: " + s.getName());
		System.out.println("Prints other fields");
<<<<<<< HEAD
		List <School> schools = userUI.getRecommendations(s);
		System.out.println("Reccomennding:");
		for (School r : schools)
		{
			System.out.println(r.getName());
		}
		
=======
		//List <School> schools = userUI.getRecommendations(s);
		//System.out.println("Reccomennding:");
		//for (School r : schools)
		//{
		//	System.out.println(r.getName());
		//}
>>>>>>> branch 'master' of https://github.com/yogurtparfait/CMC_Project.git
	}
	public void changeActiveStatusPerson(){
		System.out.println("U20 Deactivate/Activate");
		Person person = adminUI.getPersonByUsername("SuperAdmin");
		adminUI.changeStatus(person);
		System.out.println("Status changed on SuperAdmin");
	}
	public void updatePerson(){
		System.out.println("U19 Edit Person");
		Person person = adminUI.getPersonByUsername("SuperAdmin");
		String firstName = person.getFirstName();
		String lastName = person.getLastName() + "Edited";
		String password = person.getPassword();
		String type;
		if (person.getIsAdmin())
			 type = "a";
		else
			 type = "u";
		adminUI.updatePerson(person, firstName, lastName, password, type);
		System.out.println("Person SuperAdmin edited");
	}
}
