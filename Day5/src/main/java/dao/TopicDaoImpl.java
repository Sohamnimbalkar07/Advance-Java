package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.fetchDBConnection;
import pojos.Topic;

public class TopicDaoImpl implements ITopicDao {

	
	private Connection cn;
	private PreparedStatement pst1;
	
	public TopicDaoImpl() throws SQLException, ClassNotFoundException{
		
		cn=fetchDBConnection();
		pst1=cn.prepareStatement("select name from topics");
	}

	

	@Override
	public List<String> getAllTopicNames() throws SQLException {
		List<String> topicNames=new ArrayList<>();
		try(ResultSet rst=pst1.executeQuery())
		{
			while(rst.next())
				topicNames.add(rst.getString(1));
		}
		return topicNames;
	}
	
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
	}

}
