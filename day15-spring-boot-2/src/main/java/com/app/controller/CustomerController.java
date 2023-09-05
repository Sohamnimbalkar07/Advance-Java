package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.ITopicDao;
import com.app.dao.ITutorialDao;
import com.app.pojos.Topic;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ITopicDao topicDao;
	
	@Autowired
	private ITutorialDao tutDao;
	
	public CustomerController()
	{
		System.out.println("in constr of customer controller");
	}
	
	@GetMapping("/topics")
	public String showAllTopics(Model map)
	{
		System.out.println("in show all topics");
		map.addAttribute("topic_list",topicDao.getAllTopics());
		map.addAttribute("myTopic",new Topic());
		return "/customer/topics";
	}
	
	//add a req handling method for geting selected topic id n generate list of tuts from topic
	@GetMapping("/tutorials")
	public String showTutorialsByTopic(@ModelAttribute(name="myTopic") Topic topic1,Model map)
	{
		System.out.println("in show tuts"+ topic1); //id=4  topicname=null
		map.addAttribute("tut_names",tutDao.getAllTutorialsByTopic(topic1.getId()));
		return "/customer/tutorials";
	}
	
	//add request handling method for showing selected tut details
	public String showTutorilasDetails(@RequestParam String tut_name,Model map)
	{
		System.out.println("in show tut details");
		//get selected tut details from DAO + inc visits
		map.addAttribute("selected_tut",tutDao.updateVisits(tut_name));
		return "/customer/tutorials_details";
	}
}
