package com.app.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.Customer;
@Repository 
public class CustomerDao implements CustomerDaoInterface {

	@Autowired //injecting session factory dependency in dao layer
	private SessionFactory sf;
	
	@Override
	public Integer registerCustomer(Customer c) {
				
		return (Integer)sf.getCurrentSession().save(c);

	}
	
	@Override
	public Customer validateLogin(String custemail,String custpassword)
	{
		return sf.getCurrentSession().createQuery("select c from Customer c where c.customerEmail=:em and c.password=:pw",Customer.class).setParameter("em", custemail).setParameter("pw", custpassword)
		.getSingleResult();
			
	}

}
