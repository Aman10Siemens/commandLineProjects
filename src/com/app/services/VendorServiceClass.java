package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.VendorDaoInterface;

import pojos.FoodItem;
import pojos.Vendor;

@Service
@Transactional
public class VendorServiceClass implements VendorServiceInterface {

	@Autowired
	private VendorDaoInterface dao;
	
	@Override
	public Integer registerVendor(Vendor v) {
		// TODO Auto-generated method stub
		return dao.registerVendor(v);
	}

	@Override
	public Vendor validateVendorLogin(String vendoremail, String vendorpassword) {
		
		return dao.validateVendorLogin(vendoremail, vendorpassword);
	}

	@Override
	public Integer addFoodItems(FoodItem f) {
		return dao.addFoodItems(f);
	}

	
	public List<Vendor> getResturantImageName(String cityName)	
	{
		
		return dao.getResturantImageName(cityName);
		
	}
}
