package com.app.controller;

import javax.persistence.NoResultException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

import com.app.services.FoodServiceClass;
import com.app.services.FoodServiceInterface;
import com.app.services.VendorServiceInterface;

import pojos.Customer;
import pojos.FoodItem;
import pojos.Vendor;

@Controller
public class VendorController {

	@Autowired
	private VendorServiceInterface service;
	@Autowired
	private FoodServiceInterface foodService;
	
     public VendorController()
  {
	  System.out.println("This is vendor Controller");
   }
	
     @RequestMapping(value="/vendorRegister")
     public String showVendorRegister()
     {
    	 
    	 return "vendor/vendorRegistration";
     }
     
     @RequestMapping(value="/vendorRegister",method=RequestMethod.POST)
	 public String processRegistrationForm(@RequestParam("file") MultipartFile file,@Valid @ModelAttribute("v") Vendor v,BindingResult result,Model map,HttpSession hs)
		{
		if(result.hasErrors())
		{
			return "vendor/vendorRegistration";
			
		}
		try {
    	 System.out.println("in Vendor Registration form");
			System.out.println("Vendor details "+ v);
			
			final String  SAVE_DIR="images";
			String savePath="F:\\CDAC 2017\\Module_JAVASTANDARDEDITION\\Eclipse Programs\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\OnlineFood"+File.separator + SAVE_DIR;
			File fileSaveDir=new File(savePath);
	         if(!fileSaveDir.exists()){
	        	 
	             fileSaveDir.mkdir();
	         }
	             String fileName=file.getOriginalFilename();
	         

	             try{  
		        byte barr[]=file.getBytes();  
		          
		        BufferedOutputStream bout=new BufferedOutputStream( new FileOutputStream(savePath+File.separator+fileName));   
		                 
		        bout.write(barr);  
		        bout.flush();  
		        bout.close();  
		          
		        }catch(Exception e){System.out.println(e);}  

	             v.setVimage(savePath+"\\"+fileName);
	             
	             Integer id=service.registerVendor(v);
			/*if(id==null)
			{
				map.addAttribute("messege2","registration invalid");
				return "customer_registration";
			}*/
			hs.setAttribute("my_proof",id);
			hs.setAttribute("status","Registration Succesfull.....");
			return "/vendor/vendorLogin";
		} 
		catch (NoResultException e) 
		{
			map.addAttribute("registrationmessage", "registration failed , Pls retry...");
			return "vendor/vendorRegistration";

		}

		}
     
    /* @RequestMapping(value="/valid2")
		public String showValid()
		{
			System.out.println("in show valid form ");
			return "valid2";
		}
     */
     @GetMapping(value="/addFood")
     public String showAddFoodPage()
     {
    	 System.out.println("In get mapping of AddFood");
    	 return "food/addingFoodItems";
    	 
     }
     
     @PostMapping("/addFood")
     public String showAddFoodPage(@RequestParam("file") MultipartFile file,@ModelAttribute("food") FoodItem food)
     { 
    	 System.out.println("In post mapping of AddFood");
    	 final String  SAVE_DIR="images";
			String savePath="F:\\CDAC 2017\\Module_JAVASTANDARDEDITION\\Eclipse Programs\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\OnlineFood"+File.separator + SAVE_DIR;
			File fileSaveDir=new File(savePath);
	         if(!fileSaveDir.exists()){
	        	 
	             fileSaveDir.mkdir();
	         }
	             String fileName=file.getOriginalFilename();
	         

	             try{  
		        byte barr[]=file.getBytes();  
		          
		        BufferedOutputStream bout=new BufferedOutputStream( new FileOutputStream(savePath+File.separator+fileName));   
		                 
		        bout.write(barr);  
		        bout.flush();  
		        bout.close();  
		          
		        }catch(Exception e){System.out.println(e);}  

	             food.setFimage(savePath+"\\"+fileName);
	             System.out.println(savePath+"\\"+fileName);
	            
	             Integer fId=(Integer)service.addFoodItems(food);
	             return "food/addingFoodItems";
    	 
     }
     
     @RequestMapping(value="/VendorLoginValidate")
     public String showVendorLogin()
     { 	 
    	 System.out.println("in get method of vendor login");
    	 return "vendor/vendorLogin";
     }
     
     @RequestMapping(value="/VendorLoginValidate",method=RequestMethod.POST)
		public String validateUserLogin(@Valid Vendor vendorobj ,BindingResult result,Model map,HttpSession hs)
		{	
    	 try {
			System.out.println("in processing vendor login form");
			System.out.println("vendor details are"+vendorobj);
			//check for P.L. validation errors
			if(result.hasFieldErrors("vendorEmail")||result.hasFieldErrors("vpassword"))
			{
				System.out.println("p.l. errors in validation");
				return "vendor/vendorLogin";
			}
			System.out.println("no validation errors");
			// invoke service layer method
			
			Vendor validatedvendor=service.validateVendorLogin(vendorobj.getVendorEmail(),vendorobj.getVpassword());
			if(validatedvendor==null)
			{	map.addAttribute("msg","login failed");
			return "vendor/vendorLogin";
			}
		
			List<FoodItem> list;
			list=foodService.getFoods(validatedvendor.getVendorid());
			hs.setAttribute("foodlist", list);
			
			
		
			//map.addAttribute("valid_cust",validatedcust);
			//map.addAttribute("status","login successful");
			hs.setAttribute("valid_vendorobj",validatedvendor);
			hs.setAttribute("status","login successful");
			
			return "vendor/VendorHomePage";
    	 }catch (NoResultException e) 
			{
				map.addAttribute("message", "login failed  , Pls retry...");
				return "vendor/vendorLogin";

			}
		}
    
     
     
     
     
}
