package courseRegistrationSystem;
import java.util.*;

public abstract class User implements java.io.Serializable{
	//Variables
	protected String username;
	protected String password;
	protected String fname;
	protected String lname;
	
	//default constructor
	public User() {
		
	}
	
	//constructor with specific paramenters
	public User(String fname, String lname, String username, String password){
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
	}
	
	//This method will display all the courses available to the screen.
	public void viewCourses(ArrayList<Course> courseArrayList) {
		System.out.println("Here are all the courses: ");
		System.out.println();
		
		for (int i = 0; i<courseArrayList.size(); i++){
			System.out.println("Course Name: " + courseArrayList.get(i).getCourseName());
			System.out.println("Course ID: " + courseArrayList.get(i).getCourseID());
			System.out.println("Number of students registered: " + courseArrayList.get(i).getCurrentStudents());
			System.out.println("Maximum number of students allowed to be registered: " + courseArrayList.get(i).getMaxStudents());
			System.out.println();
		}
	}//ends viewCourses method
	
	//This method will exit the program
	public void exit() {
		//EXIT FROM EITHER STUDENT OR ADMIN PORTAL
	}
}
