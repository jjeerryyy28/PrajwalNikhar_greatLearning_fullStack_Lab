package greatLearning_Lab1_Oops.src.service;

import greatLearning_Lab1_Oops.src.employeeDetails.Employee;
import greatLearning_Lab1_Oops.src.interfaces.ICredentialService;

public class CredentialServicesImpl implements ICredentialService {
	private String companySuffix;

	public CredentialServicesImpl(String companySuffix) {
		this.companySuffix = companySuffix;
	}

	//creating method which will create random password: 
	public String generatePassword(int length) {
		String Setpassword = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * Setpassword.length());
			password[i] = Setpassword.charAt(rand);
		}
		return new String(password);
	}
	
	//generating email address according to respective departments:
	public String generateEmailAddress(Employee emp) {
		if (emp != null && ((emp.getFirstName() != null && !emp.getFirstName().isEmpty())
				|| emp.getLastName() != null && !emp.getLastName().isEmpty())) {
			return emp.getFirstName().toLowerCase().concat(emp.getLastName().toLowerCase()).concat("@").concat(emp.getDepartment().toLowerCase()).concat(".")
					.concat(companySuffix);
		} else {
			System.out.println("Invalid details");
		}
		return null;
	}
	
	//display method
	public void showCredentials(Employee emp) {
		System.out.println("\n \n *****EMPLOYEE DETAILS*****");
		if (emp != null) {
			if (emp.getEmail() != null && !emp.getEmail().isEmpty()) {
				System.out.println("YOUR EMAIL ID: " + emp.getEmail());
			}
			if (emp.getPassword() != null && !emp.getPassword().isEmpty()) {
				System.out.println("Password : " + emp.getPassword());
			}
		}
		System.out.println("******************************\n\n");
	}
}
