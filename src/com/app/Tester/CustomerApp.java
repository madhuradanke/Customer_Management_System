package com.app.Tester;

import static com.app.Utils.CustomerUtility.changePassword;
import static com.app.Utils.CustomerUtility.populateCustomer;
import static com.app.Utils.CustomerUtility.unsubscribeCustomer;
import static com.app.Utils.CustomerUtility.removePlanDate;
import static com.app.Utils.CustomerValidations.validateEmailPassword;
import static com.app.Utils.CustomerValidations.validateInputs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.app.CustomExceptions.CustomerExceptions;
import com.app.Customer.Customer;
import com.app.Utils.CustomerDobLastNameSort;
import com.app.Utils.CustomerValidations;

public class CustomerApp {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			
			boolean exit=false;
			ArrayList<Customer> customer=populateCustomer();
			
			while(!exit)
			{
				try {
					System.out.println("1. SignUp \n" + "2.SignIn \n"+ "3.Change password \n"
				+"4.Unsubcribe customer \n"+"5.Display Customers \n"+"6.Sort by email \n"+"7.Sort according to Dob and Lastname \n"
							+"8.Remove customer according to plan and specified date \n"
							 +"0.Exit");
					switch(sc.nextInt())
					{
					case 1:
						
							System.out.println("enter firstName, lastName, email, password, registrationAmount, dob, plan: ");
							Customer cust=validateInputs(1,sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),customer);
							customer.add(cust);
						break;
					case 2:
						//login
						//check email
						System.out.println("enter email & password : ");
						validateEmailPassword(sc.next(),sc.next(),customer);
						break;
						
					case 3:
						//change password
						System.out.println("enter email,old password and new password: ");
						changePassword(sc.next(),sc.next(),sc.next(),customer);
						break;
						
					case 4:
						//remove an account
						System.out.println("enter email: ");
						unsubscribeCustomer(sc.next(),customer);
						break;
					case 5:
						//display all customers
							for(Customer c: customer)
							{
									System.out.println(c);
							}
						break;
					case 6:
						//natural ordering
						Collections.sort(customer);
						break;
					case 7:
						//custom ordering for dob and last name 
						//using Anonymous class
						Collections.sort(customer,new Comparator<Customer>(){
								public int compare(Customer c1,Customer c2)
								{
									int returnVal=c1.getDob().compareTo(c2.getDob());
									if(returnVal==0)
									{
										return c1.getLastName().compareTo(c2.getLastName());
									}
									return returnVal;
								}
								});
						//creating new class
						//Collections.sort(customer,new CustomerDobLastNameSort());
						break;
					case 8:
						//remove all customers having plan and born after specified date
						System.out.println("Enter service plan and date: ");
						removePlanDate(sc.next(),sc.next(),customer);
						break;
					case 0:
						exit=true;
					}
					
				}catch(CustomerExceptions e)
				{
					System.out.println(e);
					sc.nextLine();
				}
			}
			
		}
	}

}
