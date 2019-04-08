package courseRegistrationSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CSVReader {
	
	//This class will read the CSV file and fill an arraylist of course objects. 
	//It will then return the course array list back to the main method. 
	
	public ArrayList<Course> openAndReadFile() throws FileNotFoundException{
		ArrayList<Course> introCourseList = new ArrayList<Course>();
	  
		try{
			ArrayList<String> studentsRegistered = new ArrayList<String>();
			String file = "MyUniversityCourses.csv";
			FileReader input = new FileReader(file);
			BufferedReader br = new BufferedReader(input);
			String line = br.readLine();
			StringTokenizer lineSplitter = new StringTokenizer(line, ","); 
		
			while ((line = br.readLine()) != null && (lineSplitter = new StringTokenizer(line, ",")) != null){
				while(lineSplitter.hasMoreTokens()){
					String courseName = lineSplitter.nextToken();
					String id = lineSplitter.nextToken();
					int maxStudents = Integer.parseInt(lineSplitter.nextToken());
					int currentStudents = Integer.parseInt(lineSplitter.nextToken());
					studentsRegistered = null; lineSplitter.nextToken();
					String courseInstructor = lineSplitter.nextToken();
					int courseSection = Integer.parseInt(lineSplitter.nextToken());
					String courseLocation = lineSplitter.nextToken();
				
					Course c = new Course(courseName, id, maxStudents, currentStudents, 
							studentsRegistered, courseInstructor, courseSection, courseLocation);
					introCourseList.add(c);	
				}//close while statement
			}	br.close();
			//close else statement
		}catch(IOException ez){
			ez.printStackTrace();
		}
		return introCourseList;
	} //close openAndReadFile method		
}//closes CSVReader class
