package courseRegistrationSystem;
import java.util.*;

public class Course implements java.io.Serializable{
	
	//Variables
	private String courseName;
	private String id;
	private int maxStudents;
	private int currentStudents;
	private ArrayList<String> studentsRegistered;
	private String courseInstructor;
	private int courseSection;
	private String courseLocation;
	
	//constructor that initializes the studentsRegistered ArrayList
	public Course() {
		studentsRegistered = new ArrayList<String>();
	}
	
	//constructor that creates a specific course based on user input (when selecting createACourse)
	public Course (String courseName, String id, int maxStudents, int currentStudents, 
			ArrayList<String> studentsRegistered, String courseInstructor, int courseSection,
			String courseLocation) {
		this.courseName = courseName;
		this.id = id;
		this.maxStudents = maxStudents;
		studentsRegistered = new ArrayList<String>();
		this.currentStudents = currentStudents;
		this.studentsRegistered = studentsRegistered;
		this.courseInstructor = courseInstructor;
		this.courseSection = courseSection;
		this.courseLocation = courseLocation;
	}
	
//------------ GETTER METHODS -------------------------------------------------------	
	public String getCourseName() {
		return courseName;
	}
	
	public String getCourseID() {
		return id;
	}
	
	public int getMaxStudents() {
		return maxStudents;
	}
	
	public int getCurrentStudents() {
		return currentStudents;
	}
	
	public String getCourseInstructor() {
		return courseInstructor;
	}
	
	public int getCourseSection() {
		return courseSection;
	}
	
	public String getCourseLocation() {
		return courseLocation;
	}

	public ArrayList<String> getStudentsRegistered() {
		return studentsRegistered;	
	}
//------------- SETTER METHODS -----------------------------------------------	
	public void setCourseName(String newName){
		courseName = newName;
	}
	
	public void setCourseID(String newID){
		id = newID;
	}
	
	public void setMaxStudents(int newMax){
		maxStudents = newMax;
	}
	
	public void setCurrentStudents(int n){
		currentStudents = n;
	}
	
	public void setStudentsRegistered (String name){
		studentsRegistered.add(name);
		currentStudents++;
	}
	
	//Idea for Iterator was used from JAVA API as well as resource from StackOverflow.
	public void removeStudentsRegistered (String name){
		Iterator<String> iterator = studentsRegistered.iterator();
		while (iterator.hasNext()){
			String s = iterator.next();
			
			if(s.equals(name)){
				iterator.remove();
				currentStudents--;
			}
		}		
	}
	
	public void setCourseInstructor (String name){
		courseInstructor = name;
	}
	
	public void setCourseSection (int secNum){
		courseSection = secNum;
	}
	
	public void setCourseLocation (String location){
		courseLocation = location;
	}
		
}
