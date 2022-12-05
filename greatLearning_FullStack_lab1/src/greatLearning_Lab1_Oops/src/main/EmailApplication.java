package greatLearning_Lab1_Oops.src.main;




import java.util.Scanner;

import greatLearning_Lab1_Oops.src.employeeDetails.Employee;
import greatLearning_Lab1_Oops.src.interfaces.ICredentialService;
import greatLearning_Lab1_Oops.src.service.CredentialServicesImpl;



public class EmailApplication {
	
	public static void main(String args[]) {
		EmailApplication application = new EmailApplication();
		Scanner sc = new Scanner(System.in);
		ICredentialService credentialService = new CredentialServicesImpl("nico.com");
		int option = 0;
		do {	
			System.out.println("1. Technical");
			System.out.println("2. Admin");
			System.out.println("3. Human Resource");
			System.out.println("4. Legal");
			System.out.println("5. Exit");
			System.out.println("Enter Your Option : ");
			option = sc.nextInt();
			
			switch (option) {
			case 1:
				application.generateEmailAndRandomPassword(sc, credentialService, "tech");
				break;
			case 2:
				application.generateEmailAndRandomPassword(sc, credentialService, "admin");
				break;
			case 3:
				application.generateEmailAndRandomPassword(sc, credentialService, "hr");
				break;
			case 4:
				application.generateEmailAndRandomPassword(sc, credentialService, "legal");
				break;
			case 5:
				System.out.println("Sayo Nara....");
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Error: You have entered wrong option. Please Try Again...");
				break;
			}
		} while (option != 5);
	}

	private void generateEmailAndRandomPassword(Scanner sc, ICredentialService credentialService, String department) {
		System.out.println("Your FirstName : ");
		String firstName = sc.next();
		System.out.println("Your LastName : ");
		String lastName = sc.next();
		Employee emp = new Employee(firstName, lastName);
		emp.setDepartment(department);
		emp.setEmail(credentialService.generateEmailAddress(emp));
		emp.setPassword(credentialService.generatePassword(10));
		credentialService.showCredentials(emp);
	}
}