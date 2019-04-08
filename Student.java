package courseRegistrationSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Student extends User implements StudentInterface, java.io.Serializable{
	
	public Student () {
		super();
	}
	
	//student constructor when user entered a name and log in credentials
	public Student (String fname, String lname, String username, String password){ 
		super(fname, lname, username, password);
	}
	
	//method to see all courses that are NOT full
	public void viewNotFullCourses(ArrayList<Course> courseArrayL) {
		System.out.println("These are the courses still available: ");
		System.out.println();
		for(int i = 0; i<courseArrayL.size(); i++){
			if ((courseArrayL.get(i).getCurrentStudents()) != ((courseArrayL.get(i).getMaxStudents()))){
				System.out.println(courseArrayL.get(i).getCourseName());
			}
		}
	}
	
	//method to register a student for a course. The method asks for a course id and section that the student wants to register for 
	//And asks the student to reenter their name to sign up.
	public void registerForCourse(ArrayList<Course> courseArrayL) { 
		System.out.println();
		System.out.println("Enter the [String] course id and [Number] course section of the course" 
				+ " that you would like to register to."); 
		System.out.println("Press Enter key after each value typed!");
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		boolean ifFound = false;
		String iD = " ";
		int cSection = 0;
		try{

			iD = in.readLine();			
			cSection = Integer.parseInt(in.readLine());

		}
		catch (IOException e){
			System.out.println("Wrong input!");
			e.printStackTrace();
		}
		System.out.println();
		String newStudentAdd = " ";
		System.out.println("Enter the [String] Student's Full Name to Add: ");
		System.out.println("Enter student's Full Name, then press Enter key.");
		try{
			newStudentAdd = in.readLine();
		}
		catch (IOException e){
			System.out.println("Wrong input. Make sure to enter a String!");
			e.printStackTrace();
		}
		for (int i=0; i<courseArrayL.size(); i++){
			if (iD.equals(courseArrayL.get(i).getCourseID()) && (cSection == courseArrayL.get(i).getCourseSection())){
					courseArrayL.get(i).setStudentsRegistered(newStudentAdd);
					ifFound = true;
			}
		}
		
		if(!ifFound){
			System.out.println("The course ID and Section didn't match any of the courses. Please make sure you entered the information correctly");
		}
	}

	//This method will remove a student from a course by entering the course id and section that they want to withdraw from 
	//and by reentering their name to confirm their decision 
	public void withdrawFromCourse(ArrayList<Course> courseArrayL) { 
		System.out.println();
		System.out.println("Enter the [String] course id and [Number] course section of the course" 
				+ " that you would like to withdraw from."); 
		System.out.println("Press Enter key after each value typed!");
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		boolean ifFound = false;
		String iD = " ";
		int cSection = 0;
		try{

			iD = in.readLine();			
			cSection = Integer.parseInt(in.readLine());

		}
		catch (IOException e){
			System.out.println("Wrong input!");
			e.printStackTrace();
		}
		System.out.println();
		String newStudentAdd = " ";
		System.out.println("Enter the [String] Student's Full Name to remove from course: ");
		System.out.println("Enter student's Full Name, then press Enter key.");
		try{
			newStudentAdd = in.readLine();
		}
		catch (IOException e){
			System.out.println("Wrong input. Make sure to enter a String!");
			e.printStackTrace();
		}
		for (int i=0; i<courseArrayL.size(); i++){
			if (iD.equals(courseArrayL.get(i).getCourseID()) && (cSection == courseArrayL.get(i).getCourseSection())){
					courseArrayL.get(i).removeStudentsRegistered(newStudentAdd);
					ifFound = true;
			}
		}
		
		if(!ifFound){
			System.out.println("The course ID and Section didn't match any of the courses. Please make sure you entered the information correctly");
		}
	}
	
	//This method will display all the students courses that he is registered in. 
	//The student will enter his name, and a list of courses that the student takes will pop up.
	public void viewMyCourses(ArrayList<Course> courseArrayL) { 
		System.out.println();
		System.out.println("Enter the [String] student's full name, then press Enter key."); 
		System.out.println();
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));

		String studentNames = " ";
		boolean ifFound = false;
		try{

			studentNames = in.readLine();		
		}
		catch (IOException e){
			System.out.println("Wrong input!");
			e.printStackTrace();
		}
		try{	
			System.out.println();
			System.out.println("Student registered for: ");
			for (int i=0; i<courseArrayL.size(); i++){
				for(String tempName : courseArrayL.get(i).getStudentsRegistered())
					if (studentNames.equals(tempName)){
						ifFound = true;
						System.out.print(courseArrayL.get(i).getCourseName() + ", ");
					}
			}
			
			System.out.println();
			if (!ifFound){
				System.out.println("If no course popped up, the student is not taking any courses.");
				System.out.println();
			}
			System.out.println();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Overrides the User's exit method to print a student specific message upon exiting program
	@Override
	public void exit() {
		System.out.println("Student has successfully logged out!");
		System.out.println();
	}
	
	//This method simply prints out the student menu of options
	public void printMenu() {
		System.out.println();
		System.out.println("Course Management: ");
		System.out.println();
		System.out.println("1. View all courses");
		System.out.println("2. View all courses that are NOT FULL");
		System.out.println("3. Register on a course");
		System.out.println("4. Withdraw from a course");
		System.out.println("5. View all courses that the current student is being registered in");
		System.out.println("6. Exit");
	}
}
