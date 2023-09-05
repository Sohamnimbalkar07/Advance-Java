package beans;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import dao.TopicDaoImpl;
import dao.TutorialDaoImpl;
import pojos.Topic;

public class TopicTutorialBean {

	private TopicDaoImpl topicDao;
	private TutorialDaoImpl tutDao;
    private int topicId;
    private String tutName;
    private String tutAuthor;
    private int visits;
    private String contents;
    private String pubDate;
    private String message;
	public TopicTutorialBean() throws ClassNotFoundException, SQLException 
	{
		super();
		System.out.println("in ctor of" + getClass().getName());
		//dao instance
		topicDao = new TopicDaoImpl();
		
	}

	//setters n getters
	public TopicDaoImpl getTopicDao() {
		return topicDao;
	}

	public void setTopicDao(TopicDaoImpl topicDao) {
		this.topicDao = topicDao;
	}
	
	
	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTutName() {
		return tutName;
	}

	public void setTutName(String tutName) {
		this.tutName = tutName;
	}

	public String getTutAuthor() {
		return tutAuthor;
	}

	public void setTutAuthor(String tutAuthor) {
		this.tutAuthor = tutAuthor;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	//Add B.L method to fetch all topics
	public List<Topic> getTopics() throws SQLException
	{
		return topicDao.getAllTopics();	
	
	}
	
	public String validateInsertTutorialDetails()
	{
		int periodInMonths = Period.between(LocalDate.parse(pubDate),LocalDate.now()).getMonths();
		if(contents.length()>=255 || periodInMonths >6)
		{   //validation failed
			message = "Adding new tutorial failed";
			return "show_tut_form";
		}
		//validation sucess
		//invoke dao layer method to insert tut details
		return null;
	}
	
	
}
