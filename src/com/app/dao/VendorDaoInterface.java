package com.app.dao;

import java.util.List;

import pojos.FoodItem;
import pojos.Vendor;

public interface VendorDaoInterface {

	public Integer registerVendor(Vendor v);
	public Vendor validateVendorLogin(String vendoremail,String vendorpassword);
	public Integer addFoodItems(FoodItem f);
    public List<Vendor> getResturantImageName(String nm);	
    
}
