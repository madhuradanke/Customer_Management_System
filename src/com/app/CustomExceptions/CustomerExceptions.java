package com.app.CustomExceptions;

@SuppressWarnings("serial")
public class CustomerExceptions extends Exception{
	public CustomerExceptions(String mesg)
	{
		super(mesg);
	}
}
