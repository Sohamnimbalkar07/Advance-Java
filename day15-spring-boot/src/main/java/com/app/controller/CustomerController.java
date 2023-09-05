package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.ITopicDao;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ITopicDao topicDao;
	
	public CustomerController()
	{
		System.out.println("in constr of customer controller");
	}
	
	@GetMapping("/topics")
	public String showAllTopics(Model map)
	{
		map.addAttribute("topic_list",topicDao.getAllTopics());
		return "/customer/topics";
	}
}
