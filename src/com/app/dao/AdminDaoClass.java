package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.Admin;
import pojos.Customer;
import pojos.FoodItem;
import pojos.Vendor;

@Repository
public class AdminDaoClass implements AdminDaoInterface {
	
	@Autowired //injecting session factory dependency in dao layer
	private SessionFactory sf;

	@Override
	public Admin validateLogin(String adminemail, String adminpassword) {
		
		return sf.getCurrentSession().createQuery("select a from Admin a where a.adminEmail=:em and a.apassword=:pw",Admin.class).setParameter("em", adminemail).setParameter("pw", adminpassword)
				.getSingleResult();
				
				
	}

	@Override
	public List<Vendor> getAllVendor() {
		return sf.getCurrentSession().createQuery("select v from Vendor v",Vendor.class).getResultList();
		
	}

	@Override
	public void deleteVendor(int vendorid) {
		
		Vendor vendor = (Vendor) sf.getCurrentSession().get(Vendor.class,vendorid);
		sf.getCurrentSession().delete(vendor);
		
	}

	@Override
	public Vendor getVendorDetail(int vendorid) {
		
		return (Vendor) sf.getCurrentSession().get(Vendor.class,vendorid);
	
	}

	@Override
	public void updateVendor(Vendor v) {
		
		sf.getCurrentSession().update(v);
		
	}
	
	

	@Override
	public List<Customer> getAllCustomer() {
		return sf.getCurrentSession().createQuery("select c from Customer c",Customer.class).getResultList();
		
	}

	@Override
	public void deleteCustomer(int customerid) {
		
		Customer customer = (Customer) sf.getCurrentSession().get(Customer.class,customerid);
		sf.getCurrentSession().delete(customer);
		
	}

	@Override
	public Customer getCustomerDetail(int customerid) {
		
		return (Customer)sf.getCurrentSession().get(Customer.class,customerid);
	
	}

	@Override
	public void updateCustomer(Customer c) {
		
		sf.getCurrentSession().update(c);
		
	}
	
	
}
