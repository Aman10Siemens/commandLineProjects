package com.app.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.FoodDaoInterface;

import pojos.FoodItem;
import pojos.Order;
import pojos.OrderDetail;

@Service
@Transactional
public class FoodServiceClass implements FoodServiceInterface {

	@Autowired
	private FoodDaoInterface dao;
	
	@Override
	public List<FoodItem> getFoodImages(int venId) {
		
		return dao.getFoodImages(venId);
	}

	@Override
	public FoodItem getFoodDescriptions(int foodId) {
		return dao.getFoodDescription(foodId);
	}

	@Override
	public Set<FoodItem> foodItemsInCart(int foodId) {
		return dao.foodItemsInCart(foodId);
	}

	@Override
	public Integer saveOrder(Order o) {
		
		return dao.saveOrder(o);
	}

	@Override
	public Integer saveOrderDetail(OrderDetail details) {
		
		return dao.saveOrderDetail(details);
	}

	@Override
	public List<FoodItem> getFoods(int venId) {
		return dao.getFoods(venId);
	}
	
	
	
	
	
}
