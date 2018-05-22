package com.app.services;

import pojos.Customer;

public interface CustomerServiceInterface {
	
	public Integer registerCustomer(Customer c);
	
	public Customer  validateLogin(String custemail,String custpassword);

}
