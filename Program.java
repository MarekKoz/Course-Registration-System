package courseRegistrationSystem;
 
import java.io.*;
import java.util.*;

public class Program {
	static ArrayList<Course> courseArray;
	static ArrayList<Student> studentArray;
	
	public static void main(String[] args) throws IOException{
	
//------------------------------------------------------------------------------------------------	
		//Deserialization or initialization of arrayLists
		
	File c = new File("Courses.ser");
	if (c.exists() && !c.isDirectory()){
		//Deserialize courseArray if .ser file exists
		try{
			FileInputStream fis = new FileInputStream("Courses.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			courseArray = (ArrayList)ois.readObject();
			ois.close();
			fis.close();

		}
		catch(IOException ioe){
			ioe.printStackTrace();
			return;
		}
		catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			return;
		}
	}//close if block	
	else{ 
		//Read csvFile and populate course array list if .ser file doesn't exist yet
		try{
			CSVReader newReader = new CSVReader();
			courseArray = newReader.openAndReadFile();

		} catch(FileNotFoundException ex){
			ex.printStackTrace();
		}
	}//closes else statement
		
	File s = new File("Students.ser");
	if (s.exists() && !s.isDirectory()){
		//deserialize studentArray at the beginning if .ser file exists
		try{
			FileInputStream fIS = new FileInputStream("Students.ser");
			ObjectInputStream oIS = new ObjectInputStream(fIS);
			studentArray = (ArrayList)oIS.readObject();
			oIS.close();
			fIS.close();			
		}
		catch(IOException iOe){
			iOe.printStackTrace();
			return;
		}
		catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			return;
		}
	}
	else {
		//create a new studentArray if .ser file doesn't exist yet
		studentArray = new ArrayList<Student>();
	}
//----------------------------------------------------------------------------------------------------------		
		//Actual main program
		
		//Welcome the user to program and ask if student or administrator
		System.out.println("Welcome to the Course Registration System for NYU!");
		System.out.println("Are you an Admin or Student?");	
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		String tempInput = " ";
		
		try{
			tempInput = in.readLine();
		}
		catch (IOException e){
			System.out.println("Wrong input!");
			e.printStackTrace();
		}
//--------------------------------------------------------------------------------------------------------------		
		//Admin Account if user inputs that they are an Admin
		if (tempInput.charAt(0) == 'a' || tempInput.charAt(0) == 'A') {
			System.out.println("You are an Admin!");
			String tempUsername = " ";
			String tempPassword = " ";	
			int count = 0;
			
			System.out.println("Enter your username, press  Enter key, then enter your password and press Enter key: ");
			
			//Asks the user to input the admin password and username (Admin, Admin001)
			do{	
				if (count > 0){
					System.out.println("The username or password you have entered is incorrect! Try again: ");
				}
				try{
					tempUsername = in.readLine();
					tempPassword = in.readLine();
				}
				catch (IOException e){
					System.out.println("Wrong inputs!");
					e.printStackTrace();
				}

				count++;

			}while (!(tempUsername.equals(Admin.username)) || !(tempPassword.equals(Admin.password)));	
			
			//Once the user logs in as an Admin, print a menu of options
			//and ask the admin to make a choice of what they want to do
			System.out.println("You have logged on as an Admin!");
			Admin admin1 = new Admin();
			int choiceSelection = 0;
			
			//Keep asking the Admin for choice until they select the Exit option from the menu
			do{
				System.out.println();
				System.out.println("Choose what you would like to do "
						+ "from the menu below by entering the corresponding "
						+ "option NUMBER: ");
				System.out.println();
				admin1.printMenu();
				
				try{
					choiceSelection = Integer.parseInt(in.readLine());
				}
				catch (IOException e){
					System.out.println("Wrong inputs!");
					e.printStackTrace();
				}


				switch(choiceSelection) {
				case 1: courseArray.add(admin1.createANewCourse());
						break;

				case 2: admin1.deleteACourse(courseArray);
						break;

				case 3: admin1.editACourse(courseArray);
						break;

				case 4: admin1.displayInformation(courseArray);
						break;

				case 5: System.out.println("What is the student's first name, last name, username, and password? ");
				System.out.println("After you type in a value, press the Enter key on your keyboard!");
				String firstName = " ";
				String lastName = " ";
				String userName = " ";
				String passWord = " ";
				try{
					firstName = in.readLine();
					lastName = in.readLine();
					userName = in.readLine();
					passWord = in.readLine();
				}
				catch (IOException e){
					System.out.println("Wrong inputs!");
					e.printStackTrace();
				}
				studentArray.add(admin1.registerAStudent(firstName, lastName, userName, passWord));
						break;

				case 6: admin1.viewCourses(courseArray);
						break;

				case 7: admin1.viewFullCourses(courseArray);
						break;

				case 8: admin1.writeFileFullCourses(courseArray);
						break;

				case 9: admin1.viewRegisteredStudents(courseArray);
						break;

				case 10: admin1.viewStudentsCourses(courseArray); 
						break;

				case 11: admin1.sortCourses(courseArray);
						break;

				case 12: admin1.exit();
						break;
				} //ends switch statement block 
			}while(choiceSelection != 12);	
			in.close();
		}//closes Admin account
		
		
		
//------------------------------------------------------------------------------------------------------------------		
		//Student Account if User selects that they want to log in as a student
		else {
			//Ask user for student name and login credentials 
			System.out.println("You Are A Student!");
			System.out.println("What is your first name, last name, username, and password? ");
			System.out.println("After you type in a value, press the Enter key on your keyboard!");
			String firstName = " ";
			String lastName = " ";
			String userName = " ";
			String passWord = " ";
			
			//Ask user for first name, last name, username, and password
			try{
					firstName = in.readLine();
					lastName = in.readLine();
					userName = in.readLine();
					passWord = in.readLine();
				}
				catch (IOException e){
						System.out.println("Wrong inputs!");
							e.printStackTrace();
				}
			
			//Create a student object and add them to the student array list 
			Student s1 = new Student(firstName, lastName, userName, passWord);
			studentArray.add(s1);
			int choiceSelection = 0;
			
			//Loop student menu until student chooses Exit option
			do{
				System.out.println("Choose what you would like to do "
						+ "from the menu below by entering the corresponding "
						+ "option NUMBER: ");
				System.out.println();
				s1.printMenu();
			
				try{
					choiceSelection = Integer.parseInt(in.readLine());
				}
				catch (IOException e){
					System.out.println("Wrong input!");
					e.printStackTrace();
				}


				switch(choiceSelection){
				case 1: s1.viewCourses(courseArray);
						break;

				case 2: s1.viewNotFullCourses(courseArray);
						break;

				case 3: s1.registerForCourse(courseArray);
						break;

				case 4: s1.withdrawFromCourse(courseArray);
						break;

				case 5: s1.viewMyCourses(courseArray);
						break;

				case 6: s1.exit();
						break;
				}//closes switch statement
		
			}while(choiceSelection != 6);
			in.close();
		} //closes student account
		
		
//------------------------------------------------------------------------------------------------------------------		
		//Serialize ArrayLists at the end 
		//Saves the state of both the course array list and student array list
		
		//serialize courseArray at the end
		try{
			FileOutputStream fos = new FileOutputStream("Courses.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(courseArray);

			oos.close();
			fos.close();
			System.out.println();
			System.out.println("Serialization of Courses Complete!");
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}

		//serialize studentArray at the end
		try{
			FileOutputStream fOS = new FileOutputStream("Students.ser");
			ObjectOutputStream oOS = new ObjectOutputStream(fOS);
			oOS.writeObject(studentArray);
			oOS.close();
			fOS.close();
			System.out.println("Serializtion of Students Complete!");
		}
		catch (IOException iOE){
			iOE.printStackTrace();
		}
		
	}

}
