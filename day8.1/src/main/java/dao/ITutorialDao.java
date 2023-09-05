package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Tutorial;

public interface ITutorialDao {

	List<String> getAllTutorialByTopic(String topicName) throws SQLException;
	//add a method to insert new tutorial under existing topic
	String addNewTutorial(Tutorial tutorial) throws SQLException;
}
