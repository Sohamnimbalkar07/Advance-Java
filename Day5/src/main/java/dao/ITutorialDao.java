package dao;

import java.sql.SQLException;
import java.util.List;

public interface ITutorialDao {

	List<String> getAllTutorialByTopic(String topicName) throws SQLException;
}
