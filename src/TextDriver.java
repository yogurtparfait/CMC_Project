import java.util.Scanner;

public class TextDriver {
	
	public static void main(String[] args) {
		int choice;
		Scanner sc = new Scanner(System.in);
		TextDriver driver = new TextDriver();

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
				else
					System.out.println("not valid try a different number");
			}while( choice != 0);
	}
	public void login(){}
	public void manageProfile(){}
	public void manageSchools(){}
	public void searchSchools(){}
	public void logout(){}
	public void manageUsers(){}
	public void editProfile(){}
	public void removeSchool(){}
	public void viewSchool(){}
	public void viewSearchResults(){}
	public void viewUser(){}
	public void addUser(){}
	public void addUniversity(){}
	public void editUniversity(){}
	public void viewSchoolAndRecommendations(){}
	public void changeActiveStatusUser(){}
	public void editUser(){}
}
