package com.app.dao;

import java.util.List;

import pojos.Admin;
import pojos.Customer;
import pojos.Vendor;

public interface AdminDaoInterface {
	
	public Admin validateLogin(String adminemail,String adminpassword);
	public List<Vendor> getAllVendor();
	public void deleteVendor(int vendorid);
	public Vendor getVendorDetail(int vendorid);
	public void updateVendor(Vendor v);
	
	public List<Customer> getAllCustomer();
	public void deleteCustomer(int customerid);
	public Customer getCustomerDetail(int customerid);
	public void updateCustomer(Customer c);
	
}
