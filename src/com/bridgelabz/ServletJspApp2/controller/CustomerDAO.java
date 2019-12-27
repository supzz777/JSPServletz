package com.bridgelabz.ServletJspApp2.controller;

public interface CustomerDAO
{
	public int getCustomer(String username,String password);
	
	public int registerCustomer(Customer cust);
}