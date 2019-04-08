package courseRegistrationSystem;

import java.util.ArrayList;

public interface AdminInterface {
	
	//This interface provides the blueprints for the methods the Admin must implement
	//in the Admin class. These are basically all the methods that the Admin class doesn't
	//inherit from the User class that are specific to the Admin. 
	public Course createANewCourse();
	public void deleteACourse(ArrayList<Course> courseArrayL);
	public void editACourse(ArrayList<Course> courseArrayL); //edit any info for a course
	public void displayInformation(ArrayList<Course> courseArrayL); //for a given course when given ID
	public Student registerAStudent(String firstName, String lastName, String userName, String passWord);  
	
	public void viewFullCourses(ArrayList<Course> courseArrayL);
	public void writeFileFullCourses(ArrayList<Course> courseArrayL);
	public void viewRegisteredStudents(ArrayList<Course> courseArrayL); //view students registered for a course by course ID
	public void viewStudentsCourses(ArrayList<Course> courseArrayL); //view courses a student takes when given fname and lname
	public void sortCourses(ArrayList<Course> courseArrayL); //sort courses based on number of students registered.
	
}
