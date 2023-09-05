package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Topic;
import com.app.pojos.Tutorial;

@Repository
@Transactional
public class TopicDaoImpl implements ITopicDao {

	@Autowired
	private EntityManager manager;
	
	public TopicDaoImpl()
	{
		System.out.println("in Topic dao constructor");
	}
	
	@Override
	public List<Topic> getAllTopics() {
		
		String jpql = "select t from Topic";
		return manager.createQuery(jpql,Topic.class).getResultList();
	}
	
	public Tutorial updateVisits(String tutName)
	{
		String jpql="select t from Tutorial t where t.tutorialName=:name";
		Tutorial tutorial = mgr.createQuery(jpql,Tutorial.class).setParameter("name",tutName).getSingleResult();
		tutorial.setVisits(tutorial.getVisits()+1);
		return tutorial;
	}

}
