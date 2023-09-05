package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	public HomeController()
	{
		System.out.println("in cont of" + getClass().getName());
	}
	
	@RequestMapping("/")
	public String ShowHomePage()
	{
		System.out.println("in show home page");
		return "/index";
	}
}
