package com.app.dao;

import java.util.List;

import pojos.Customer;

public interface CustomerDaoInterface {

	public Integer registerCustomer(Customer c);
	public Customer validateLogin(String custemail,String custpassword);
	
}
