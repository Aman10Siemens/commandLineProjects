package com.app.dao;

import java.util.List;
import java.util.Set;

import pojos.Customer;
import pojos.FoodItem;
import pojos.Order;
import pojos.OrderDetail;

public interface FoodDaoInterface {

	public List<FoodItem> getFoodImages(int venId);
	public FoodItem getFoodDescription(int foodId);
	public Set<FoodItem> foodItemsInCart(int foodId);
	public Integer saveOrder(Order o);
	public Integer saveOrderDetail(OrderDetail details);
	public List<FoodItem> getFoods(int venId);
}
