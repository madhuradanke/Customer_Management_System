package com.app.Customer;

public enum ServicePlan {
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
	
	//STATE
	private double regAmount;
	
	//constructor
	ServicePlan(double regAmount)
	{
		this.regAmount=regAmount;
	}
	
	@Override
	public String toString() {
		return name()+" : "+regAmount;
	}
	
	public double getRegAmount()
	{
		return regAmount;
	}
	
}
