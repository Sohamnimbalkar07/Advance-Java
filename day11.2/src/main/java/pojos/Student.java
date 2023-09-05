package pojos;
import pojos.Course;

/*
* 1. Properties of Student
studentId,name,email, status
status : ADMISSION_CANCELLED, STUDENT_ADMITTED
 */
import javax.persistence.*;
@Entity
@Table(name="students_tbl")
public class Student extends BaseEntity {
	@Column(length = 30)
	private String name;
	@Column(length = 30,unique = true)
	private String email;
	@ManyToOne
	@JoinColumn(name="course_Id")
	private Course courseEnrolled;
//	@Enumerated(EnumType.STRING)
//	@Column(length = 50)
//	private Status status;


	public Student() {
		System.out.println("Constructor of Student invoke");

	}

	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
		//this.status = Status.STUDENT_ADMITTED;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
//	public Status getStatus() {
//		return status;
//	}
//
//	public void setStatus(Status status) {
//		this.status = status;
//	}
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	public Course getCourseEnrolled() {
		return courseEnrolled;
	}

	public void setCourseEnrolled(Course courseEnrolled) {
		this.courseEnrolled = courseEnrolled;
	}

	@Override
	public String toString() {
		return "Student [Id ="+ getId() +"name=" + name + ", email=" + email + ", courseEnrolled=" + courseEnrolled + "]";
	}

	

}
