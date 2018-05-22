package com.app.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.Customer;
import pojos.FoodItem;
import pojos.Order;
import pojos.OrderDetail;

@Repository
public class FoodDaoClass implements FoodDaoInterface {
	//List<FoodItem> listFoodItems=new ArrayList<>();
	Set<FoodItem> setFoodItems=new HashSet<>();
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<FoodItem> getFoodImages(int venId) {
		return sf.getCurrentSession().createQuery("select f from FoodItem f where  f.vendor.vendorid=:vid",FoodItem.class).setParameter("vid", venId).getResultList();
		
	}

	@Override
	public FoodItem getFoodDescription(int foodId) {
		return sf.getCurrentSession().createQuery("select f from FoodItem f where f.foodid=:fid",FoodItem.class).setParameter("fid",foodId).getSingleResult();
	}

	@Override
	public Set<FoodItem> foodItemsInCart(int foodId) {
		
		String jpql="Select f from FoodItem f where f.foodid=:fid";
		FoodItem fobj=sf.getCurrentSession().createQuery(jpql, FoodItem.class).setParameter("fid", foodId).getSingleResult();
		setFoodItems.add(fobj);
		return setFoodItems;
	}

	@Override
	public Integer saveOrder(Order o) {
		
		return (Integer)sf.getCurrentSession().save(o);
	
	}

	@Override
	public Integer saveOrderDetail(OrderDetail details) {
		
		return (Integer)sf.getCurrentSession().save(details);
	}

	@Override
	public List<FoodItem> getFoods(int venId) {
		List<FoodItem> l1;
		l1=sf.getCurrentSession().createQuery("select f from FoodItem f where f.vendor.vendorid=:vid",FoodItem.class).setParameter("vid",venId).getResultList();
		System.out.println(l1);
		return l1;
	}
	
	
	
	
}
