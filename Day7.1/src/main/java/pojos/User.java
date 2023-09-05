package pojos;

public class User {

	private String userName;
	private String password;
	private int age;
	public User()
	{
		
	}
	public User(String userName, String password, int age)
	{
		super();
		this.userName = userName;
		this.password = password;
		this.age= age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", age=" + age + "]";
	}
	
	
}
