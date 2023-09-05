package com.app.dao;

import java.util.List;

public interface ITutorialDao {

	List<String> getAllTutorialsByTopic(int topicId);
     Tutorial updateVisits(String tutName);
}
