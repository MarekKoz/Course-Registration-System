package courseRegistrationSystem;

import java.util.*;
import java.io.*;

public class Admin extends User implements AdminInterface{

	static String username = "Admin";
	static String password = "Admin001";

	public Admin () {

	}

	//This method creates a new course by asking the user to enter information about the course
	//Once the method receives the info, it creates a course and returns it to main so it will be added
	//to the course ArrayList
	public Course createANewCourse() {
		System.out.println("Enter the [String] course name, [String] id,[number] maxinum number of"
				+ " students, "); 
		System.out.println("[String] course instructor, [number] course section, [String] course location.");
		System.out.println("Press Enter key after each value typed!");
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		String cName = " ";
		String iD = " ";
		int mxmNum = 0;
		String cInstructor = " ";
		int cSection = 0;
		String cLocation = " ";
		try{
			cName = in.readLine();
			iD = in.readLine();
			mxmNum = Integer.parseInt(in.readLine());
			cInstructor = in.readLine();
			cSection = Integer.parseInt(in.readLine());
			cLocation = in.readLine();
		}
		catch (IOException e){
			System.out.println("Wrong input!");
			e.printStackTrace();
		}
		
		Course newCourse = new Course(cName, iD, mxmNum, 0, null, cInstructor, cSection, cLocation);
		return newCourse;
	}

	//This method deletes a course from the courseArrayList in the main, by asking the user to 
	//enter the course's id and section number. 
	public void deleteACourse(ArrayList<Course> courseArrayL) {
		System.out.println("Enter the [String] course id and [number] course section of the course" 
						 + "that you would like to delete."); 
		System.out.println("Press Enter key after each value typed!");
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		
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
		for (int i=0; i<courseArrayL.size(); i++){
			if (iD.equals(courseArrayL.get(i).getCourseID()) && (cSection == courseArrayL.get(i).getCourseSection())){
				courseArrayL.remove(i);
			}
		}
	}

	//This method allows the user to edit any aspect of an existing course 
	//by asking which course to edit and then displaying a menu of possible options that 
	//the user can edit. 
	public void editACourse(ArrayList<Course> courseArrayL) {//edit any info for a course
		System.out.println();
		System.out.println("Enter the [String] course id and [number] course section of the course" 
				+ " that you would like to edit."); 
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
		//Menu that the user can choose from to edit a specific element of a course
		for (int i=0; i<courseArrayL.size(); i++){
			if (iD.equals(courseArrayL.get(i).getCourseID()) && (cSection == courseArrayL.get(i).getCourseSection())){
				System.out.println();
				System.out.println("Course Found! What would you like to edit?");
				System.out.println("1. Course Name");
				System.out.println("2. Course ID");
				System.out.println("3. Maximum Number of Students in Course");
				System.out.println("4. Current Number of Students in Course");
				System.out.println("5. Add a Student Name to Students Registered in Course List");
				System.out.println("6. Remove a Student Name from Students Registered in Course List");
				System.out.println("7. Course Instructor");
				System.out.println("8. Course Section");
				System.out.println("9. Course Location");
				System.out.println();
				System.out.println("Enter the option NUMBER: ");
				ifFound = true;
				int courseIndex = i;
				
				
				int tempSelection = 0;
				try{
					tempSelection = Integer.parseInt(in.readLine());
				}
				catch (IOException e){
					System.out.println("Wrong input. Make sure to enter a NUMBER!");
					e.printStackTrace();
				}
				
				switch(tempSelection) {
				case 1: 
					String newCourseName = " ";
					System.out.println("Enter a new [String] Course Name: ");
					try{
						newCourseName = in.readLine();
					}
					catch (IOException e){
						System.out.println("Wrong input. Make sure to enter a String!");
						e.printStackTrace();
					}
					
					courseArrayL.get(i).setCourseName(newCourseName);
						break;
						
				case 2: 
					String newCourseID = " ";
					System.out.println("Enter a new [String] Course ID: ");
					try{
						newCourseID = in.readLine();
					}
					catch (IOException e){
						System.out.println("Wrong input. Make sure to enter a String!");
						e.printStackTrace();
					}
					
					courseArrayL.get(i).setCourseID(newCourseID);
						break;
						
				case 3: 
					int newCourseMaxNums = 0;
					System.out.println("Enter a new [number] Maximum Number of Students for the course: ");
					try{
						newCourseMaxNums = Integer.parseInt(in.readLine());
					}
					catch (IOException e){
						System.out.println("Wrong input. Make sure to enter a NUMBER!");
						e.printStackTrace();
					}
					
					courseArrayL.get(i).setMaxStudents(newCourseMaxNums);
						break;
						
				case 4: 
					int newCourseCurrNums = 0;
					System.out.println("Enter a new [number] Current Number of Students for the course: ");
					try{
						newCourseCurrNums = Integer.parseInt(in.readLine());
					}
					catch (IOException e){
						System.out.println("Wrong input. Make sure to enter a NUMBER!");
						e.printStackTrace();
					}
					
					courseArrayL.get(i).setCurrentStudents(newCourseCurrNums);
						break;
						
				case 5: 
					String newStudentAdd = " ";
					System.out.println("Enter a new [String] Student Name to Add: ");
					System.out.println("Enter student's First Name and Last Name, then press Enter key.");
					try{
						newStudentAdd = in.readLine();
					}
					catch (IOException e){
						System.out.println("Wrong input. Make sure to enter a String!");
						e.printStackTrace();
					}
					
					courseArrayL.get(i).setStudentsRegistered(newStudentAdd);
						break;
						
				case 6: 
					String newStudentDel = " ";
					System.out.println("Enter a [String] Student Name to Delete Off List: ");
					System.out.println("Enter student's First Name and Last Name, then press Enter key.");
					try{
						newStudentDel = in.readLine();
					}
					catch (IOException e){
						System.out.println("Wrong input. Make sure to enter a String!");
						e.printStackTrace();
					}
					
					courseArrayL.get(i).removeStudentsRegistered(newStudentDel);
						break;
						
				case 7: 
					String newCourseInstructor = " ";
					System.out.println("Enter a new [String] Course Instructor to Add: ");
					try{
						newCourseInstructor = in.readLine();
					}
					catch (IOException e){
						System.out.println("Wrong input. Make sure to enter a String!");
						e.printStackTrace();
					}
					
					courseArrayL.get(i).setCourseInstructor(newCourseInstructor);
						break;
						
				case 8: 
					int newSection = 0;
					System.out.println("Enter a new [number] Course Section Number for the course: ");
					try{
						newCourseCurrNums = Integer.parseInt(in.readLine());
					}
					catch (IOException e){
						System.out.println("Wrong input. Make sure to enter a NUMBER!");
						e.printStackTrace();
					}
					
					courseArrayL.get(i).setCourseSection(newSection);
						break;
				case 9: 
					String newLocation = " ";
					System.out.println("Enter a new [String] Course Location to Add: ");
					try{
						newLocation = in.readLine();
					}
					catch (IOException e){
						System.out.println("Wrong input. Make sure to enter a String!");
						e.printStackTrace();
					}
					
					courseArrayL.get(i).setCourseLocation(newLocation);
						break;
				} //ends switch statement block 
			}
		}
		//If the user enters a course id and section that doesn't match any of the existing courses, then they will be presented with this 
		//error message
		if (!ifFound) {
			System.out.println("Course not found. Make sure you entered the correct information with the correct format(String/number)");
		}
	}

	//This method will display a course's information to the user. 
	//The user is asked to enter a course id and section, then the corresponding information will
	//be printed to the screen
	public void displayInformation(ArrayList<Course> courseArrayL) { //for a given course when given ID
		System.out.println();
		System.out.println("Enter the [String] course id and [number] course section of the course" 
				+ " that you would like to get more information on."); 
		System.out.println("Press Enter key after each value typed!");
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));

		String iD = " ";
		int cSection = 0;
		boolean ifFound = false;
		try{

			iD = in.readLine();			
			cSection = Integer.parseInt(in.readLine());

		}
		catch (IOException e){
			System.out.println("Wrong input!");
			e.printStackTrace();
		}
		catch(NumberFormatException nex){
			System.out.println("You have entered a string instead of a number for the course section!!");
			System.out.println("You can only enter a number for course section");
			System.out.println();
		}
		try{	
			for (int i=0; i<courseArrayL.size(); i++){
				if (iD.equals(courseArrayL.get(i).getCourseID()) && (cSection == courseArrayL.get(i).getCourseSection())){
					System.out.println("Course Name: " + courseArrayL.get(i).getCourseName());
					System.out.println("Course ID: " + courseArrayL.get(i).getCourseID());
					System.out.println("Number of students registered: " + courseArrayL.get(i).getCurrentStudents());
					System.out.println("Maximum number of students allowed to be registered: " + courseArrayL.get(i).getMaxStudents());
					System.out.println("Course Instructor: " + courseArrayL.get(i).getCourseInstructor());
					System.out.println("Course Section: " + courseArrayL.get(i).getCourseSection());
					System.out.println("Course Location: " + courseArrayL.get(i).getCourseLocation());
					ifFound = true;
					System.out.print("Students registered: ");
					for (String tempStudent : courseArrayL.get(i).getStudentsRegistered()){
						System.out.print(tempStudent + ", ");
					}
					System.out.println();
				}
			}

			if (!ifFound){
				System.out.println("If no course popped up, you have entered the wrong course ID or course Section");
			}	
		}
		catch(NullPointerException npe){
			System.out.println("Students registered: none");
		}
	}

	//This method will allow the admin to register a student and add them to the student ArrayList that is in the main
	//
	public Student registerAStudent(String firstName, String lastName, String userName, String passWord) { 
		Student s1 = new Student(firstName, lastName, userName, passWord);
		return s1;
	}





	//This method will allow the admin to see all the courses that are full
	//by comparing the amount of students that currently are registered for a course
	//and that course's maximum amount of students that can take the course
	public void viewFullCourses(ArrayList<Course> courseArrayL) {
		System.out.println("These are the courses that are FULL: ");
		System.out.println();
		for(int i = 0; i<courseArrayL.size(); i++){
			if ((courseArrayL.get(i).getCurrentStudents()) == ((courseArrayL.get(i).getMaxStudents()))){
				System.out.println(courseArrayL.get(i).getCourseName());
			}
		}
	}

	//This method will write to a file all the courses that are full. 
	//This is a mix of the above method and also using Professor Anasse Bari's 
	//fileWriterTest.java code from the course website.
	public void writeFileFullCourses(ArrayList<Course> courseArrayL) {
		String fileName = "FullCourses.txt";
		FileWriter fw = null;
		BufferedWriter bw = null;
		try{
			List<String> fullCourse = new ArrayList<String>();
			for (int i = 0; i<courseArrayL.size(); i++){
				if((courseArrayL.get(i).getCurrentStudents()) == ((courseArrayL.get(i).getMaxStudents()))){
					fullCourse.add(courseArrayL.get(i).getCourseName());
				}
			}
		
			bw = new BufferedWriter(new FileWriter(fileName));
			for (int i = 0; i <fullCourse.size(); i++){
				bw.write(fullCourse.get(i) + ", ");
			}
		}
		catch(IOException exk){
			System.out.println("Error writing file " + fileName);
		}
		finally {
			try{
				if(bw != null){
					bw.close();
				}
				
				if(fw != null){
					fw.close();
				}
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}

	}

	//This method will ask the admin for the course id and course section
	//it will then go through the arraylist of courses and look for the chosen course
	//Once the course is found, it will display the students registered for that course
	public void viewRegisteredStudents(ArrayList<Course> courseArrayL) { 
		System.out.println();
		System.out.println("Enter the [String] course id and [number] course section of the course" 
				+ " that you would like to know ."); 
		System.out.println("Press Enter key after each value typed!");
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));

		String iD = " ";
		int cSection = 0;
		boolean ifFound = false;
		try{

			iD = in.readLine();			
			cSection = Integer.parseInt(in.readLine());

		}
		catch (IOException e){
			System.out.println("Wrong input!");
			e.printStackTrace();
		}
		catch(NumberFormatException nex){
			System.out.println("You have entered a string instead of a number for the course section!!");
			System.out.println("You can only enter a number for course section");
			System.out.println();
		}
		try{	
			for (int i=0; i<courseArrayL.size(); i++){
				if (iD.equals(courseArrayL.get(i).getCourseID()) && (cSection == courseArrayL.get(i).getCourseSection())){
					ifFound = true;
					System.out.print("Students registered: ");
					for (String tempStudent : courseArrayL.get(i).getStudentsRegistered()){
						System.out.print(tempStudent + ", ");
					}
					System.out.println();
				}
			}

			if (!ifFound){
				System.out.println("If no course popped up, you have entered the wrong course ID or course Section");
			}	
		}
		catch(NullPointerException npe){
			System.out.println("Students registered: none");
		}
	}

	//This method will take a students full name, and then compare it to all course's registered students looking for a match
	//It will then print out what course the student is taking to the screen. 
	public void viewStudentsCourses(ArrayList<Course> courseArrayL) { 
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
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//This method will sort the course ArrayList in the main in DESCENDING order. 
	//Courses with the most registered students will be first and courses with the smallest amount of students
	//will be printed at the end. 
	//Resources for this method were used from the JAVA API, as well as YouTube video called "Sort ArrayList of Objects" by
	//a user named Greg Anderson.
	public void sortCourses(ArrayList<Course> courseArrayL) { //sort courses based on number of students registered.
		Collections.sort(courseArrayL, new Comparator<Course>()
				{
					public int compare (Course c1, Course c2){
						return Integer.valueOf(c2.getCurrentStudents()).compareTo(c1.getCurrentStudents());
					}
				});
		
		for (int i = 0; i<courseArrayL.size(); i++){
			System.out.println("Course Name: " + courseArrayL.get(i).getCourseName());
			System.out.println("Number of Students Registered: "+ courseArrayL.get(i).getCurrentStudents());
			System.out.println();
		}
	}
	
	//This method overrides the User's exit method to display an Admin specific log off message.
	@Override
	public void exit() {
		System.out.println("Admin successfully logged out!");
		System.out.println();
	}
	
	//This method overrides the User's viewCourses method to add more information for when an 
	//Admin uses it as comapred to a student calling it. The admin sees more information by overriding the User's method.
	@Override
	public void viewCourses(ArrayList<Course> courseArrayList) {
		System.out.println("Here are all the courses: ");
		System.out.println();
		
		for (int i = 0; i<courseArrayList.size(); i++){
			System.out.println("Course Name: " + courseArrayList.get(i).getCourseName());
			System.out.println("Course ID: " + courseArrayList.get(i).getCourseID());
			System.out.println("Number of students registered: " + courseArrayList.get(i).getCurrentStudents());
			System.out.println("Maximum number of students allowed to be registered: " + courseArrayList.get(i).getMaxStudents());
			System.out.println("Course Instructor: " + courseArrayList.get(i).getCourseInstructor());
			System.out.println();
		}
	}//ends viewCourses method

	//This method simply prints the Admin Menu of options once an Admin logs into the system.
	public void printMenu() {
		System.out.println();
		System.out.println("Courses Management: ");
		System.out.println();
		System.out.println("1. Create a new course");
		System.out.println("2. Delete a course");
		System.out.println("3. Edit a course");
		System.out.println("4. Display information for a given course");
		System.out.println("5. Register a student");
		System.out.println();
		System.out.println("Reports: ");
		System.out.println();
		System.out.println("6. View all courses");
		System.out.println("7. View all courses that are FULL");
		System.out.println("8. Write to a file the list of courses that are FULL");
		System.out.println("9. View the names of the students being registered in a specific course");
		System.out.println("10. View the list of courses that a given student is being registered on");
		System.out.println("11. Sort courses based on the current number of students registered");
		System.out.println("12. Exit");
	}
}
