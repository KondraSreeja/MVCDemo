package com.cg;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Scope("session")
@Controller
@RequestMapping(value="user")




public class UserController {
	
	
	ArrayList<String>cityList;
	ArrayList<String>skillList;
	
	@RequestMapping(value="showLogin")
	public String prepareLogin(Model model){
		
		System.out.println("in prepareLogin() method");
		model.addAttribute("login",new Login());
		return "Login";
		
		
		
		
	}
	
	@RequestMapping(value="/checkLogin")
	public ModelAndView checkLogin(@ModelAttribute("login") Login l)
	{
		//Logic to validate userName and password against database
		return new ModelAndView("loginSuccess","username",l.getUserName());
	                           //viewName      modelName    modelObject
	}

	@RequestMapping(value="showRegister")
	public String prepareRegister(Model model){
		cityList=new ArrayList<String>();
		
		cityList.add("Mumbai");
		cityList.add("Hyderabad");
		cityList.add("Bangalore");
		cityList.add("Delhi");
		
		skillList = new ArrayList<String>();
		
		skillList.add("Java");
		skillList.add("Struts");
		skillList.add("Spring");
		skillList.add("Hibernate");
		
		model.addAttribute("cityList",cityList);
		model.addAttribute("skillList",skillList);
				
		model.addAttribute("user",new User());
		return "register";
	}
	
	@RequestMapping(value="/checkRegister")
	public String checkRegister(User user,Model model){
		model.addAttribute("user",user);
		return "registerSuccess";
	}
}
