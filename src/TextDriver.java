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
		int choice;
		Scanner sc = new Scanner(System.in);
		
		TextDriver driver = new TextDriver();
		driver.setScanner(sc);
		
		

		do 
			{
				System.out.println("Pick a use case: \n 1: login \n 3: manage profile \n 5: editProfile \n 18: addPerson  ");
				System.out.println(" 16: Manage People \n 0: Quit");
				choice = sc.nextInt();
				if (choice == 1)
					driver.login();
				else if(choice == 3)
					driver.manageProfile();
				else if(choice == 5)
					driver.editProfile();
				else if (choice == 0)
					System.out.println("Goodbye");
				else if (choice == 18)
					driver.addPerson();
				else if (choice == 16)
					driver.managePeople();
				else 
					System.out.println("not valid try a different number");
			}while( choice != 0);
		sc.close();
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
	public void manageProfile(){}
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
	public void searchSchools(){}
	public void logout(){}
	public void managePeople(){
		if(this.adminUI ==null)
			System.out.println("not logged in as admin");
		else
		{
			List<Person> people = adminUI.getPeople();
			for(Person p: people)
			{
				System.out.println("firstName: " + p.getFirstName() + " lastname: " + p.getLastName() + " username: " + 
				 p.getUsername() + " password: " + p.getPassword() + " isAdmin: " + p.getIsAdmin() );
			}
		}
	}
	public void editProfile(){}
	public void removeSchool(){}
	public void viewSchool(){}
	public void viewSearchResults(){}
	
	public void addPerson(){
		/*System.out.println("Enter firstname");
		String firstName = sc.nextLine();
		System.out.println("Enter lastname");
		String lastName = sc.nextLine();
		System.out.println("Enter password");
		String password = sc.nextLine();
		System.out.println("Enter username");
		String username = sc.nextLine();
		System.out.println("Enter type");
		String type = sc.nextLine();*/
		
		String firstName = "Super";
		String lastName = "Admin";
		String password = "password";
		String username = "SuperAdmin";
		String type = "a";
		
		System.out.println(adminUI.addPerson(firstName,lastName, password, username,type));
		
	}
	public void addUniversity(){}
	public void editUniversity(){}
	public void viewSchoolAndRecommendations(){}
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
