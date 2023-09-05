package com.app.controller;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {

	public TestController()
	{
		System.out.println("in constructor of " + getClass().getName());
	}
	
	@GetMapping("/test1")
	public ModelAndView testModelAndView()
	{
		System.out.println(" in test M n V");
		return new ModelAndView("/test/test1", "server_ts",LocalDateTime.now());
	}
	
	@GetMapping("/test2")
	public String testModelMap(Model modelMap)
	{
		System.out.println(" in test ModelMap" + modelMap);
		modelMap.addAttribute("server_ts",LocalDateTime.now()).addAttribute("num_list",Arrays.asList(10,20,30,40));
	    System.out.println(modelMap);
	    return "/test/test1";
	}
}
