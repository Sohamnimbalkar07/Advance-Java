package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.IUserService;

import com.app.pojos.User;

@Controller
@RequestMapping("/user")
public class UserController {
//dependency : service layer
	@Autowired
	private IUserService userService;
	
	public UserController()
	{
		System.out.println("in cont of " + getClass().getName());
	}
	
	@GetMapping("/login")
	//In handlerMapping Bean :
	//key = /user/login+ method=get
	//value = com.app.controller.UserController.ShowLoginForm
	public String showLoginForm()
	{
		System.out.println("inshow login form");
		return "/user/login";
	}
	
	//add req handling method(to service POST) : process the form
	//In handlerMapping Bean :
		//key = /user/login+ method=POS
		//value = com.app.controller.UserController.ShowLoginForm
	@PostMapping("/Login")
	public String processLoginForm(@RequestParam String email, @RequestParam(name="password") String pwd,Model map )
	{
		System.out.println("in process login form");
        try {
		//invoke service layer method for user validation
		User user =userService.validateUser(email,pwd);
		
		map.addAttribute("user_details",user);
		if(user.getRole().equals("ADMIN"))
		{
			return "/admin/add_tut_form";
		}
		return "/customer/topics";
        } catch(RuntimeException e)
        {
        	map.addAttribute("message", "Invalid Login, please retry !!!");
        	return "/user/login";  
        }
		
	}
}

