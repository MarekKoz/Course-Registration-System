package courseRegistrationSystem;

import java.util.ArrayList;

public interface StudentInterface {
	
	//This interface provides the blueprints for the methods the student must implement
	//in the Student class. These are basically all the methods that the Student class doesn't
	//inherit from the User class that are specific to the Student. 
	
	public void viewNotFullCourses(ArrayList<Course> courseArrayL);
	public void registerForCourse(ArrayList<Course> courseArrayL); //student enters course name, section and students full name. Then student added to course
	public void withdrawFromCourse(ArrayList<Course> courseArrayL); //student enters full name, course name and then the student will be taken off from course
	public void viewMyCourses(ArrayList<Course> courseArrayL); //view all courses student is registered for
	
}
