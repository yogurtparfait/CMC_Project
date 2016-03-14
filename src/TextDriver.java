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
				System.out.println("Pick a use case: /n 1: login /n 3: manage profile /n 5: editProfile /n 0: Quit");
				choice = sc.nextInt();
				if (choice == 1)
					driver.login();
				else if(choice == 3)
					driver.manageProfile();
				else if(choice == 5)
					driver.editProfile();
				else if (choice == 0)
					System.out.println("Goodbye");
				else 
					System.out.println("not valid try a different number");
			}while( choice != 0);
		sc.close();
	}
	
	public void login(){
		System.out.println("Enter username");
		String username = sc.nextLine();
		System.out.println("Enter password");
		String password = sc.nextLine();
		System.out.println("Steal? true or false");
		boolean steal = sc.nextBoolean();
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
	public void manageSchools(){}
	public void searchSchools(){}
	public void logout(){}
	public void managePeople(){}
	public void editProfile(){}
	public void removeSchool(){}
	public void viewSchool(){}
	public void viewSearchResults(){}
	public void viewPerson(){}
	public void addPerson(){
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
		System.out.println(adminUI.addPerson(firstName,lastName, password, username,type));
		
	}
	public void addUniversity(){}
	public void editUniversity(){}
	public void viewSchoolAndRecommendations(){}
	public void changeActiveStatusUser(){}
	public void editPerson(){}
}
