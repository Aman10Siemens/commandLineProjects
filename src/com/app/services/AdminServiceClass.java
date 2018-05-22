package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AdminDaoInterface;

import pojos.Admin;
import pojos.Customer;
import pojos.Vendor;

@Service
@Transactional
public class AdminServiceClass implements AdminServiceInterface {
	
	@Autowired
	private AdminDaoInterface dao;

	@Override
	public Admin validateLogin(String adminemail, String adminpassword) {
		
		return dao.validateLogin(adminemail,adminpassword);
	}

	@Override
	public List<Vendor> getAllVendor() {
		
		return dao.getAllVendor();
	}

	@Override
	public void deleteVendor(int vendorid) {
		System.out.println(" delete vendor service method");
	   dao.deleteVendor(vendorid);
	}

	@Override
	public Vendor getVendorDetail(int vendorid) {
		
		System.out.println("In get vendor detail method of service class");
		
		return dao.getVendorDetail(vendorid);
		
	}

	@Override
	public void updateVendor(Vendor v) {
		
		System.out.println(" in update vendor method of service class");
		dao.updateVendor(v);
	}
	
	
	
	@Override
	public List<Customer> getAllCustomer() {
		return dao.getAllCustomer();
	}

	@Override
	public void deleteCustomer(int customerid) {
		System.out.println(" delete customer service method");
	   dao.deleteCustomer(customerid);
	}

	@Override
	public Customer getCustomerDetail(int customerid) {
		
		System.out.println("In get customer detail method of service class");
		
		return dao.getCustomerDetail(customerid);
	}

	@Override
	public void updateCustomer(Customer c) {
	
		System.out.println(" in update customer method of service class");
		dao.updateCustomer(c);
		
	}

		

}
