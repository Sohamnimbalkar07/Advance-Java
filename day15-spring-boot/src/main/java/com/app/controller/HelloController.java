package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //mandatory : to tell SC, following class is a spring bean,containing request handling logic
public class HelloController {

	public HelloController()
	{
		System.out.println("in constructor of" + getClass().getName());
	}
	
	//to tell SC : following method is a request handling method
	@RequestMapping("/hello")
	public String sayHello()
	{
		System.out.println(" in say hello");
		return "/welcome"; //logical view name(forward view name)
	}
}
