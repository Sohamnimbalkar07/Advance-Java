package dao;

import pojos.Address;
import pojos.Student;

public interface IStudentDao {
	//String linkAddressDetails(long studentId, Address a);
	//Student getStudentDetails(String email);
	
    String admitNewStudent(Student student, String courseTitle);
	
}