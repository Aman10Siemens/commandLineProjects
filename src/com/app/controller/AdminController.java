package com.app.controller;

import java.util.*;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.services.AdminServiceInterface;

import pojos.Admin;
import pojos.Customer;
import pojos.Vendor;

@Controller
public class AdminController {
	
	@Autowired
	private AdminServiceInterface adminService;

	public AdminController() {
		
		System.out.println("Admin Controller constructor");
	}
	
	@RequestMapping(value="/AdminLoginValidate")
    public String showAdminLogin()
    { 	 
   	 System.out.println("in get method of Admin login");
   	 return "admin/adminlogin";
    }
	
	@RequestMapping(value="/AdminLoginValidate",method=RequestMethod.POST)
	public String showAdminLogin(@Valid @ModelAttribute("a")Admin adminobj ,BindingResult result,Model map,HttpSession hs)
	{	
								
		try {
			
			System.out.println("in processing admin login form");
			System.out.println("admin details are"+adminobj);
			//check for P.L. validation errors
			if(result.hasFieldErrors("adminEmail")||result.hasFieldErrors("apassword"))
			{
				System.out.println("p.l. errors in validation");
				return "admin/adminlogin";
			}
			System.out.println("admin details are"+adminobj);
			System.out.println("no validation errors");
			
			
			//invoke service layer method for user validation
			System.out.println(adminobj.getAdminEmail()+" "+adminobj.getApassword());
			Admin validatedadmin=adminService.validateLogin(adminobj.getAdminEmail(),adminobj.getApassword());
			System.out.println("After service method of admin is called "+validatedadmin);
			if(validatedadmin==null)
			{	map.addAttribute("msg","login failed");
			return "admin/adminlogin";
			}
			hs.setAttribute("valid_adminobj",validatedadmin);
			hs.setAttribute("status","login successful");
			
			return "admin/adminHome";
			
			} 
		catch (NoResultException e) 
		{
			map.addAttribute("message", "login failed  , Pls retry...");
			return "admin/adminlogin";

		}}
		
		@RequestMapping("/listAllVendor")
		public String listAllVendor( HttpSession adminSession)
		
		{
			System.out.println("in list all venorcontroller");
		List<Vendor> vendors=adminService.getAllVendor();
		System.out.println(" 2 list all venorcontroller"+ vendors);
		
		adminSession.setAttribute("vendorsList", vendors);
		return "admin/listAllVendor";
		}
			
		@RequestMapping("/VendorDelete")
		public String vendorDelete( HttpSession adminSession,@RequestParam("id") int Id)	
		{
			System.out.println("in delete vendor controller");
			
			adminService.deleteVendor(Id);
			System.out.println(" 2 delete  vendorcontroller");
			return "redirect:/listAllVendor";
		}
		
		@RequestMapping("/updateVendor")
		public String showUpdateVendor(HttpSession adminSession,@RequestParam("id") int Id)
		{
			System.out.println("in update vendor controller get method");
			Vendor v=adminService.getVendorDetail(Id);
			adminSession.setAttribute("vendor_obj",v);
			return "admin/updateVendor";
		}
		
		@RequestMapping(value="/updateVendor",method=RequestMethod.POST)
		public String showUpdateVendor(@ModelAttribute("vendorobj") Vendor v,HttpSession adminSession)
		{
			System.out.println("in update vendor post method "+v);
			Vendor vobj=(Vendor)adminSession.getAttribute("vendor_obj");
			v.setVendorid(vobj.getVendorid());
			v.setCity(vobj.getCity());
			v.setRestaurantName(vobj.getRestaurantName());
			v.setVimage(vobj.getVimage());
			v.setVpassword(vobj.getVpassword());
			
			System.out.println(" vendor obj " + v);
			
			adminService.updateVendor(v);
			
			return "redirect:/listAllVendor";
		}
		
		@RequestMapping("/listAllCustomer")
		public String listAllCustomer( HttpSession adminSession)
		
		{
			System.out.println("in list all customer controller");
			List<Customer> customers=adminService.getAllCustomer();
			System.out.println(" 2 list all customer controller"+ customers);
		
			adminSession.setAttribute("customerList", customers);
			return "admin/listAllCustomer";
		}
		
		@RequestMapping("/CustomerDelete")
		public String customerDelete( HttpSession adminSession,@RequestParam("id") int Id)	
		{
			System.out.println("in delete customer controller");
			
			adminService.deleteCustomer(Id);
			System.out.println(" 2 delete  customer controller");
			return "redirect:/listAllCustomer";
		}
		
		@RequestMapping("/updateCustomer")
		public String showUpdateCustomer(HttpSession adminSession,@RequestParam("id") int Id)
		{
			System.out.println("in update customer controller get method");
			Customer v=adminService.getCustomerDetail(Id);
			adminSession.setAttribute("customer_obj",v);
			return "admin/updateCustomer";
		}
		
		@RequestMapping(value="/updateCustomer",method=RequestMethod.POST)
		public String showUpdateCustomer(@ModelAttribute("customerobj") Customer c,HttpSession adminSession)
		{
			System.out.println("in update customer post method "+c);
			Customer cobj=(Customer)adminSession.getAttribute("customer_obj");
			
			System.out.println("customer obj " + c);
			
			c.setCustomerId(cobj.getCustomerId());
			c.setCustomerName(cobj.getCustomerName());
			c.setPassword(cobj.getPassword());
			
			adminService.updateCustomer(c);
			
			return "redirect:/listAllCustomer";
		}
	
	}
