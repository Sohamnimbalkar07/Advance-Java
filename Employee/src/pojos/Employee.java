package pojos;
import java.sql.Date;

public class Employee {

	private int empID;
	private String name;
	private String address;
	private double salary;
	private String deptID;
	private Date joinDate;
	
	public Employee()
	{
		
	}

	public Employee(int empID, String name, String address, double salary, String deptID, Date joinDate) {
		super();
		this.empID = empID;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.deptID = deptID;
		this.joinDate = joinDate;
	}
	
    public Employee(int empID, String name, double salary,Date joinDate) {
		super();
		this.empID = empID;
		this.name = name;
        this.salary = salary;
	    this.joinDate = joinDate;
	}

	
	public Employee(String name, String address, double salary, String deptID, Date joinDate) {
		super();
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.deptID = deptID;
		this.joinDate = joinDate;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDeptID() {
		return deptID;
	}

	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", name=" + name + ", address=" + address + ", salary=" + salary
				+ ", deptID=" + deptID + ", joinDate=" + joinDate + "]";
	}
	
	
	
}
