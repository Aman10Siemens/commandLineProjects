package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CustomerDaoInterface;

import pojos.Customer;

@Service
@Transactional
public class CustomerService implements CustomerServiceInterface {

	@Autowired
	private CustomerDaoInterface dao;
	
	@Override
	public Integer registerCustomer(Customer c) {
		
		return dao.registerCustomer(c);
	}

	@Override
	public Customer validateLogin(String custemail, String custpassword) {
		
	return dao.validateLogin(custemail, custpassword);
	}

}
