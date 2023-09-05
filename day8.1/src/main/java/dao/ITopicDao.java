package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Topic;

public interface ITopicDao {

	List<String> getAllTopicNames() throws SQLException;
	List<Topic> getAllTopics() throws SQLException;
}
