package com.glearning.email.service;

import java.util.Random;

import com.glearning.email.model.Employee;

public class CredentialService {
	
	private static final String DOMAIN_NAME = "abc.com";
	private static final String DELIMITTER = " ";
	private static final String UPPER_CASE="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWER_CASE="abcdefghijklmnopqrstuvwxyz";
	private static final String SPECIAL_CHAR="!@#$%^&*()_-";
	private static final String NUMBER="0123456789";
	
	public String generatePassword(int length) {
		
		String value = UPPER_CASE+LOWER_CASE+SPECIAL_CHAR+NUMBER;
		Random random = new Random();
		
		char[] password = new char[length];
		
		for( int i = 0; i < length; i++) {
			password[i] = value.charAt(random.nextInt(value.length()));
			
		}
		
		return password.toString();
			
		
	}
	
	public String generateEmailAddress(String firstName, String lastName, String dept) {
		
		String emailAddress = firstName+DELIMITTER+lastName+"@"+dept+DOMAIN_NAME;
		return emailAddress;
		
		
		
	}
	
	public void showCredentials(Employee employee) {
		System.out.println("/////// Details of the Employee ////////");
		System.out.println("FirstName :: " +employee.getFirstName());
		System.out.println("LastName :: " +employee.getLastName());
		System.out.println("Email Address :: " +employee.getEmailAddress());
		System.out.println("Password :: " +employee.getPassword());
		System.out.println("Date of Birth :: " +employee.getDateOfBirth());
		
	}

}
