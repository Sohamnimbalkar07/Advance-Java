package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="courses_tbl")
public class Course extends BaseEntity {

	@Column(length = 50,unique = true)
	private String title;
	@Column(name="start_date")
	private LocalDate startDate;
	@Column(name="end_date")
	private LocalDate endDate;
	private double fees;
	private int capacity;
//	@Enumerated(EnumType.STRING)
//	@Column(length = 50)
	//private Status status;
//	//one to many Course 1 <------> * Admission
//	@OneToMany(....)
//	private List<Admission> admissions=new ArrayList<>();
	
	public Course() {
		System.out.println("Constructor of Course invoke");
	}
	public Course(String title, LocalDate startDate, LocalDate endDate, double fees, int capacity) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.capacity = capacity;
		//this.status=Status.COURSE_LAUNCHED;
	}
	//all getters n setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
//	public Status getStatus() {
//		return status;
//	}
//	public void setStatus(Status status) {
//		this.status = status;
//	}
	@Override
	public String toString() {
	return "Course [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", fees=" + fees
			+ ", capacity=" + capacity + ",ID = " + getId() + "]";
	}
	
	

}
