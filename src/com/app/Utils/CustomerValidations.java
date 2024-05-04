package com.app.Utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import com.app.CustomExceptions.CustomerExceptions;
import com.app.Customer.*;

public class CustomerValidations{
	
	//Validates all inputs
	public static Customer validateInputs(int customerId,String firstName,String lastName,String email,String password,double registrationAmount,String dob,String plan, ArrayList<Customer> customer) throws CustomerExceptions
	{
		
		//ServicePlan splan= parseAndValidateServicePlan(plan);
		LocalDate date=parseDate(dob);
		checkDuplicate(email,date,customer);
		ServicePlan serviceplan=parseAndValidateServicePlan(plan,registrationAmount,customer);
		parseValidateDob(dob);
		validatePassword(password);

		
		return new Customer(customerId,firstName,lastName,email,password,registrationAmount,date,serviceplan);
		
	}
	
	// add a static method for validating ServicePlan and regAmount
	public static ServicePlan parseAndValidateServicePlan(String plan,double regAmount,ArrayList<Customer> customer)throws CustomerExceptions
	{
		ServicePlan splan=ServicePlan.valueOf(plan.toUpperCase());
		if(splan.getRegAmount()==regAmount)
			return splan;
		throw new CustomerExceptions("Invalid Amount");
		//return ServicePlan.valueOf(plan.toUpperCase());
	}
	
	// add a static method for parsing string-> date
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}
	//checks for duplicate email and dob
	public static void checkDuplicate(String email,LocalDate dob,ArrayList<Customer> customer) throws CustomerExceptions
	{
		Customer c =new Customer(email,dob);
			if(customer.contains(c))
			{
				throw new CustomerExceptions("Duplicate email and Date of Birth");
			}
		
	}
	
	public static void checkEmail(String email,ArrayList<Customer> customer) throws CustomerExceptions
	{
		Customer c=new Customer(email);
		if(customer.contains(c))
		{
			System.out.println("email exists");
		}
		throw new CustomerExceptions("email does not exist");
	}
	
	//validate email and password
	public static void validateEmailPassword(String email,String password, ArrayList<Customer> customer) throws CustomerExceptions
	{		
		Customer c=new Customer(email);
		//System.out.println(customer.get((customer.indexOf(c))).getPassword()+" "+password);
		int index=customer.indexOf(c); 
		//if element not found
		 if(index==-1)
		{
			 throw new CustomerExceptions("Invalid email");
		}
		 //get index of email and check if the password entered is same
		if((customer.get(index).getPassword()).equals(password)) {
			System.out.println("login Succesfull");
		}
	}
	
	public static void validatePassword(String password) throws CustomerExceptions
	{
		String pass="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
			if(!password.matches(pass))
		
				throw new CustomerExceptions("Invalid password, doesnt satisfy requirements");
		
	}
	
	public static void parseValidateDob(String dob) throws CustomerExceptions
	{
		//LocalDate date2 = LocalDate.parse(dob);
		LocalDate date=LocalDate.parse(dob);
		int age=Period.between(date, LocalDate.now()).getYears();
		if(age<18)
			throw new CustomerExceptions("Invalid age");
		//return age;
		
	}
	
	//validate plan and registration amount
//	public static ServicePlan validatePlanAmount(ServicePlan plan,double regAmount,ArrayList<Customer> customer) throws CustomerExceptions
//	{
//		if(plan.getRegAmount()==regAmount)
//			return plan;
//		throw new CustomerExceptions("Invalid Amount");
//		
//	}


}
