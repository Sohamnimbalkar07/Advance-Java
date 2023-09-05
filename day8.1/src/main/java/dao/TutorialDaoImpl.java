package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pojos.Tutorial;

import static utils.DBUtils.fetchDBConnection;

public class TutorialDaoImpl implements ITutorialDao {

	private Connection cn;
	private PreparedStatement pst1,pst4;
	
	public TutorialDaoImpl() throws SQLException, ClassNotFoundException{
		
		cn=fetchDBConnection();
		pst1=cn.prepareStatement("select t1.name from tutorials t1 inner join topics t2 on t1.topic_id=t2.id where t2.name=?");
		pst4=cn.prepareStatement("insert into tutorial values(default,?,?,?,?,?,?)");
	}
	@Override
	public List<String> getAllTutorialByTopic(String topicName) throws SQLException {
		
		List<String> tutNames = new ArrayList<>();
		pst1.setString(1,topicName);
		try(ResultSet rst= pst1.executeQuery())
		{
			while(rst.next())
			{
				tutNames.add(rst.getString(1));
			}
		}
		return tutNames;
	}

	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		if(pst4 != null)
			pst4.close();
	}
	@Override
	public String addNewTutorial(Tutorial tutorial) throws SQLException {
		//set In param
		pst4.setString(1,tutorial.getTutorialName());
		pst4.setString(1,tutorial.getAuthor());
		pst4.setDate(1,tutorial.getPublishDate());
		pst4.setInt(1,tutorial.getVisits());
		pst4.setInt(1,tutorial.getTopicId());
		pst4.setInt(1,tutorial.getContents());
		
		return null;
	}
}
