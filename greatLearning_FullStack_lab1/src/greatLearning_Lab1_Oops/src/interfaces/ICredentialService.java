package greatLearning_Lab1_Oops.src.interfaces;

import greatLearning_Lab1_Oops.src.employeeDetails.Employee;

//interface: 

public interface ICredentialService {
	String generatePassword(int length);
	String generateEmailAddress(Employee emp);
	void showCredentials(Employee emp);
}