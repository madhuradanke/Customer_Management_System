package com.app.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import com.app.CustomExceptions.CustomerExceptions;
import com.app.Customer.Customer;
import com.app.Customer.ServicePlan;

public class CustomerUtility{
	
	//static method to remove a customer
	public static void unsubscribeCustomer(String email,ArrayList<Customer> customer) throws CustomerExceptions
	{
		Customer c= new Customer(email);
		//finds index of given customer from the list
		int index=customer.indexOf(c);
		//if customer not present throw exception
		if(index==-1)
			throw new CustomerExceptions("Account not found");
		//else remove customer
		customer.remove(index);
		System.out.println("account removed");
	}
	
	//change password
	public static void changePassword(String email,String oldpassword,String newpassword,ArrayList<Customer> customer) throws CustomerExceptions
	{
		Customer c=new Customer(email);
		int index=customer.indexOf(c);
		if(index == -1)
			throw new CustomerExceptions("Invalid email");
		if((customer.get(index).getPassword()).equals(oldpassword))
		{
			customer.get(index).setPassword(newpassword);
			System.out.println("password reset");
		}
	}
	
	public static ArrayList<Customer> populateCustomer()
	{
		Customer c1= new Customer(1,"madhura","danke","madhura@gmail.com","madhura",5000,LocalDate.of(2001, 07, 15),ServicePlan.DIAMOND);
		Customer c2=new Customer(2,"srushti","danke","srushti@gmail.com","srushti",1000,LocalDate.of(2005, 11, 24),ServicePlan.SILVER);
		Customer c3=new Customer(3,"sneha","Agr","sneha@gmail.com","sneha",1000,LocalDate.of(2002,9,11),ServicePlan.SILVER);
		Customer c4=new Customer(4,"gayatri","k","gayatri@gmail.com","gayatri",2000,LocalDate.of(1999, 12, 22),ServicePlan.GOLD);
		Customer c5=new Customer(5,"abc","xyz","abc@gmail.com","abc",5000,LocalDate.of(2005, 10, 24),ServicePlan.DIAMOND);
		Customer c6=new Customer(6,"abc1","xyz1","abc@gmail.com","abc",10000,LocalDate.of(2005, 10, 24),ServicePlan.PLATINUM);
		Customer c7=new Customer(7,"mno","pqr","mno@gmail.com","mno",1000,LocalDate.of(2005, 11, 24),ServicePlan.SILVER);
		ArrayList<Customer> customerList=new ArrayList<Customer>();
		Customer[] custArray= {c1,c2,c3,c4,c5,c6,c7};
		for(Customer c: custArray)
		{
			customerList.add(c);
		}
		return customerList;
	}
	
	public static void removePlanDate(String splan,String sdate,ArrayList<Customer> customer) throws CustomerExceptions
	{
		ServicePlan plan=ServicePlan.valueOf(splan.toUpperCase());
		LocalDate date=LocalDate.parse(sdate);
		Iterator<Customer> itr=customer.iterator();
		//for(Customer c:customer)
			while(itr.hasNext())
			{
				System.out.println("in while hasnext");
				Customer c=itr.next();
				if(c.getPlan()==plan && c.getDob().isAfter(date)) 
				{
						System.out.println("in if next date");
						itr.remove();
					
				}

			}
				
	}
	

}
