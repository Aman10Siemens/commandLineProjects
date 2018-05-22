package com.app.controller;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.services.CustomerServiceInterface;
import com.app.services.FoodServiceInterface;
import com.app.services.VendorServiceInterface;

import pojos.Customer;
import pojos.Vendor;

@Controller
public class MainController {

		@Autowired
		private CustomerServiceInterface service;
        @Autowired
		private VendorServiceInterface VendorService;
        @Autowired
        private FoodServiceInterface foodService;
        
		public MainController() {
			
			System.out.println("This is ctor of services");
		}
		
		@RequestMapping(value="/customer_registration")
		public String showRegistrationForm()
		{
			System.out.println("in show registration form ");
			return "customer_registration";
		}
		
		
		
		@RequestMapping(value="/customer_registration",method=RequestMethod.POST)
		
		public String processRegistrationForm(@Valid@ModelAttribute("c") Customer c,BindingResult result,Model map,HttpSession hs)
		{
			try {
			if(result.hasErrors())
			{
				return "customer_registration";
				
				
			}
				
				
				System.out.println("in process login form");
			System.out.println("customer details "+ c);
			Integer id=service.registerCustomer(c);
			
			
			/*if(id==null)
			{
				map.addAttribute("messege","registrration invalid");
				return "customer_registration";
			}*/
		    //hs.setAttribute("Customer_details",c);
			hs.setAttribute("my_proof",id);
			hs.setAttribute("status","Registration Succesfull.....");
			return "redirect:/valid";
			}catch (NoResultException e) 
			{
				map.addAttribute("registrationmessage", "Invalid registration detail , Pls retry...");
				
				return "Home";

			}
		}
		
		@RequestMapping(value="/valid")
		public String showValid()
		{
			System.out.println("in show valid form ");
			return "/valid";
		}
		
		
		
		@RequestMapping(value="/Home")
		public String showHome()
		{
			System.out.println("in show Home form ");
			
			return "Home";
		}
		
		@RequestMapping(value="/LoginValidate",method=RequestMethod.POST)
		public String validateUserLogin(@Valid Customer custobj ,BindingResult result,Model map,HttpSession hs)
		{	
									
			try {
				
				System.out.println("in processing login form");
				System.out.println("customer details are"+custobj);
				//check for P.L. validation errors
				if(result.hasFieldErrors("customerEmail")||result.hasFieldErrors("password"))
				{
					System.out.println("p.l. errors in validation");
					return "Home";
				}
				System.out.println("no validation errors");
				
				
				//invoke service layer method for user validation
				
				Customer validatedcust=service.validateLogin(custobj.getCustomerEmail(),custobj.getPassword());
				if(validatedcust==null)
				{	map.addAttribute("msg","login failed");
				return "Home";
				}
			
				//map.addAttribute("valid_cust",validatedcust);
				//map.addAttribute("status","login successful");
				
				hs.setAttribute("valid_cust",validatedcust);
				hs.setAttribute("status","login successful");
				//return "CustomerHomePage";
				return "citySelection";
				
				} 
			catch (NoResultException e) 
			{
				map.addAttribute("message", "login failed  , Pls retry...");
				return "Home";

			}
				
		}
			
		
		
		@RequestMapping(value="/orderDirectCity")
		public String showDirectCityPage()
		{
			System.out.println("Order page direct to city....");
			return "citySelection";
			
		}
		
		@PostMapping(value="/orderDirectCity")
		public String postDirectCityPage(@ModelAttribute("v") Vendor v,Model map)
		{
		    // map.addAttribute("city_selected",v.getCity());
		map.addAttribute("VendorList",VendorService.getResturantImageName(v.getCity()));
		     
		     return "restaurant";
		}
		
		@RequestMapping(value="/redirectToHome")
		public String reversePage()
		{
			System.out.println("Redirect to Home...");
			return "Home";
			
		}
		
	/*	@RequestMapping(value="/foodMenu1")
		public String showFoodMenu1(@RequestParam int vendorid,Model map)
		{ System.out.println("In foodmenu get page"+vendorid);
		map.addAttribute("Food_Items_List",foodService.getFoodImages(vendorid));
		
			return "food/foodMenu1";
		}
	*/	
		
		@RequestMapping(value="/aboutus")
		public String aboutus()
		{
			System.out.println("in show about us page ");
			return "aboutus";
		}
		
		@RequestMapping(value="/contactus")
		public String contactus()
		{
			System.out.println("in show contact us page ");
			return "contactUs";
		}
		
		@RequestMapping(value="/clogout")
		public String logout(HttpSession hs)
		{
			System.out.println("in  log out controller");
			
			
			if(hs != null)
			    hs.invalidate();
			return "Home";
			
		}
}
