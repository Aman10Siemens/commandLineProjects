package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.Customer;
import pojos.FoodItem;
import pojos.Vendor;

@Repository
public class VendorDaoClass implements VendorDaoInterface {

	@Autowired //injecting session factory dependency in dao layer
	private SessionFactory sf;
	
	@Override
	public Integer registerVendor(Vendor v) {
		// TODO Auto-generated method stub
		return (Integer)sf.getCurrentSession().save(v);
	}

	@Override
	public Vendor validateVendorLogin(String vendoremail, String vendorpassword) {

		return sf.getCurrentSession().createQuery("select v from Vendor v where v.vendorEmail=:em and v.vpassword=:pw",Vendor.class).setParameter("em", vendoremail).setParameter("pw", vendorpassword)
				.getSingleResult();
	}

	@Override
	public Integer addFoodItems(FoodItem f) {
		return (Integer)sf.getCurrentSession().save(f);
	}
	public List<Vendor> getResturantImageName(String cityName)	
	{
		return sf.getCurrentSession().createQuery("select v from Vendor v where  v.city=:cty",Vendor.class).setParameter("cty", cityName).getResultList();
		
		
	}
	
}
