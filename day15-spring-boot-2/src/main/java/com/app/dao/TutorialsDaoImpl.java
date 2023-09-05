package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TutorialsDaoImpl implements ITutorialDao {

	@Autowired
	private EntityManager mgr;
	@Override
	public List<String> getAllTutorialsByTopic(int topicId) {
		
		String jpql="select t.tutorialName from Tutorial t where t.currentTopic.id=:id";
		return mgr.createQuery(jpql,String.class).setParameter("id",topicId).getResultList();
	}

}
