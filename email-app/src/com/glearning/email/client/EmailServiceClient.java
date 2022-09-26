package com.glearning.email.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.glearning.email.model.Employee;
import com.glearning.email.service.CredentialService;
import com.glearning.email.service.EmployeeService;

public class EmailServiceClient {
	
	private static CredentialService credentialService = new CredentialService();
	private static EmployeeService employeeService = new EmployeeService(credentialService);
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter First Name");
		String firstName = sc.next();
		
		System.out.println("Please enter Last Name");
		String lastName = sc.next();
		
		System.out.println("Please enter Date of Birth in dd/mm/yy format");
		String strdob = sc.next();
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yy");
		LocalDate dob = LocalDate.parse(strdob, pattern);
		
		Employee newHire = new Employee(firstName, lastName, dob);
		
		System.out.println("Enter your Department");
		System.out.println("1 -> Technical");
		System.out.println("2 -> Admin");
		System.out.println("3 -> Human Resource");
		System.out.println("4 -> Legal");
		
		int opt = sc.nextInt();
		
		switch(opt) {
		case 1: 
			newHire.setDept("Technical");
			employeeService.generateEmailAddress(newHire);
			break;
		case 2:
			newHire.setDept("Admin");
			employeeService.generateEmailAddress(newHire);
			//employeeService.printEmployeeDetails(newHire);
			break;
		case 3: 
			newHire.setDept("Human Resource");
			employeeService.generateEmailAddress(newHire);
			break;
		case 4: 
			newHire.setDept("Legal");
			employeeService.generateEmailAddress(newHire);
			break;
			
		}
			
			

		
		System.out.println("Enter your option for the following");
		System.out.println("1 -> Generate Password ");
		System.out.println("2 -> Show Details");
		
		int option = sc.nextInt();
		
		switch(option) {
		case 1: 
			employeeService.saveCredentials(8, newHire);
			employeeService.printEmployeeDetails(newHire);
			break;
		case 2:
			employeeService.printEmployeeDetails(newHire);
			break;
			
		
		}
		
		
	}
	
}


