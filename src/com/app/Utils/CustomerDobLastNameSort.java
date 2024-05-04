package com.app.Utils;

import java.util.Comparator;

import com.app.Customer.Customer;

public class CustomerDobLastNameSort implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		int returnVal=c1.getDob().compareTo(c2.getDob());
		if(returnVal==0)
		{
			return c1.getLastName().compareTo(c2.getLastName());
		}
		
		return returnVal;
	}
	
	

}
