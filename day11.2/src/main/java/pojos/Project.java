package pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="projects_tbl")
public class Project extends BaseEntity {

	@Column(name="title",length= 30,unique=true)
	private String projectTitle;
	@Column(length=200)
	private String technology;
	@Column(name="completion_Date")
	private LocalDate completionDate;
	@ManyToMany
	@JoinTable(name="project_student",
	joinColumns=@JoinColumn(name="project_id"),
	inverseJoinColumns=@JoinColumn(name="student_id"))
    private Set<Student> students = new HashSet<>();
	public Project() {
		System.out.println("in project class constructor");
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public LocalDate getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Project [projectTitle=" + projectTitle + ", technology=" + technology + ", completionDate="
				+ completionDate + ", students=" + students + "]";
	}
	
	
	
}
