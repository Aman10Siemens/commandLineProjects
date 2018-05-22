package com.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.services.FoodServiceInterface;

import pojos.Customer;
import pojos.FoodItem;
import pojos.Order;
import pojos.OrderDetail;
import sun.misc.Request;

@Controller
public class FoodController {

	
	@Autowired
    private FoodServiceInterface foodService;
	
	public FoodController() {
     System.out.println("This is Food Controller...");
	}
	
	@RequestMapping(value="/foodMenu")
	public String showFoodMenu(@RequestParam int vendorid,Model map,HttpSession hs)
	{
		System.out.println("In foodmenu get page"+vendorid);
		hs.setAttribute("Food_Items_List",foodService.getFoodImages(vendorid));
		//hs.setAttribute("qty", 0);
		return "food/foodMenu";
	}
	
	
	@RequestMapping(value="/showDescriptionFood")
	public String showFoodDescription(@RequestParam int foodid,Model map,HttpSession hs)
	{
		if(hs.getAttribute("valid_cust")== null)
		{
			return "Home";
		}
		else
		{
			System.out.println("In food Description get page"+foodid);
			hs.setAttribute("Food_Description",foodService.getFoodDescriptions(foodid));//particular food object corresponding to the foodid
			map.addAttribute("FoodId",foodid);
			//hs.setAttribute("FoodId",foodid);
	
	   		return "food/foodDescription";
		}
	}
	
	/*@RequestMapping(value="/addToCart")
	public String addFoodToCart(@RequestParam("foodid") int foodid,@RequestParam("Qty") int Qty,Model map,HttpSession hs)
	{
		map.addAttribute("addedFoodId",foodid);
		hs.setAttribute("FoodInCart",foodService.foodItemsInCart(foodid));
		//int qty=(int)hs.getAttribute("qty")+1;
		hs.setAttribute("food"+foodid, Qty);
		return "food/foodMenu";
		
	}*/
	
	@PostMapping(value="/addToCart")
	public String addFoodToCart(@RequestParam("foodid") int foodid,@RequestParam("quantity") int quantity,Model map,HttpSession hs)
	{	
		System.out.println(foodid+"   "+quantity);
		hs.setAttribute("FoodInCart",foodService.foodItemsInCart(foodid));
		hs.setAttribute("food"+foodid, quantity);
		hs.setAttribute("fid",foodid);
		return "food/foodMenu";
	}
	
	@RequestMapping(value="ViewCart")
	public String showCart(HttpSession hs)
	{	ArrayList<FoodItem> l1=new ArrayList<>();
		Set<FoodItem> set=(Set<FoodItem>) hs.getAttribute("FoodInCart");
		
		for(FoodItem fobj:set)
		{
			l1.add(fobj);
		}
		double totalbill=0;
		
		for(FoodItem obj:l1)
		{
			int id=obj.getFoodid();
			int quantity=(Integer)hs.getAttribute("food"+id);
			totalbill+=obj.getPrice()*quantity;
		}
		hs.setAttribute("finalListInCart",l1);
		hs.setAttribute("total", totalbill);
		System.out.println("In show Cart...");
		return "food/viewCart";
	}
	
	@PostMapping(value="/saveOrder")
	public String saveOrder(@ModelAttribute("order") Order order,@RequestParam int customerId,HttpSession hs)
	{
		
		//save order functions................
		System.out.println("In save order controller");
		Customer c = new Customer(customerId);
		order.setCustomer(c);
		System.out.println(order);
		System.out.println(order.getCustomer().getCustomerId());
		Integer orderid=foodService.saveOrder(order);
		hs.setAttribute("orderid",orderid);
		hs.setAttribute("order_obj",order);
		order.setOrderId(orderid);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//save orderdetails functions.....
		ArrayList<FoodItem> finalListInCart=(ArrayList<FoodItem>)hs.getAttribute("finalListInCart");
		for(FoodItem obj:finalListInCart)
		{
			FoodItem fooditem= new FoodItem(obj.getFoodid());
			int id=obj.getFoodid();
			int quantity=(Integer)hs.getAttribute("food"+id);
			OrderDetail orderdetail= new OrderDetail();
			orderdetail.setFooditem(fooditem);
			orderdetail.setOrder(order);
			orderdetail.setQuantity(quantity);
			foodService.saveOrderDetail(orderdetail);
			
		}
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		
		return "food/Thankyou";
	}
	
	
}
