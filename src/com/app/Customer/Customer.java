package com.app.Customer;

import java.time.LocalDate;

public class Customer implements Comparable<Customer> {
	private static int count;
	static {
		count=0;
	}
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	
	//constructor
	public Customer(int customerId,String firstName,String lastName,String email,String password,double registrationAmount,LocalDate dob,ServicePlan plan)
	{
		this.customerId=++count;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.password=password;
		this.registrationAmount=registrationAmount;
		this.dob=dob;
		this.plan=plan;
	}
	
	//email constructor
	public Customer(String email)
	{
		this.email=email;
	}
	//email dob constructor
	public Customer(String email,LocalDate dob)
	{
		this.email=email;
		this.dob=dob;
	}


	public ServicePlan getPlan() {
		return plan;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getRegistrationAmount() {
		return registrationAmount;
	}

	public void setRegistrationAmount(double registrationAmount) {
		this.registrationAmount = registrationAmount;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Id: "+customerId+" first name: "+firstName+" last name: "+lastName+" email: "+email+" password: "+password+
				" registration amount: "+registrationAmount+
				" DOB: "+dob+" Service Plan: "+plan;
	}
	
//	@Override
//	public boolean equals(Object o)
//	{
//		if(o instanceof Customer)
//			return this.email.equals(((Customer)o).email) && this.dob.equals(((Customer)o).dob);
//		return false;
//	}
//	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Customer)
			return this.email.equals(((Customer)obj).email);
		return false;
	}

@Override
public int compareTo(Customer c) {
	return this.email.compareTo(c.email);
}
}
