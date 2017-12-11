package registrationScheduler.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * File read/write utility.
 * @author rthosar1
 *
 */
public class FileProcessor {
	
	
	/**
	 * This function takes filename as input, and returns the contents as list of strings
	 * 
	 * <p>
	 * If it does not find file, it will exit program.
	 * If specified file empty, it will exit program
	 * </p>
	 * 
	 * @param fileName name of file to read
	 * @return contents of file in list of strings
	 */
	public List<String> loadFile(String fileName) {
		List<String> strings = new ArrayList<>();
		Scanner s=null;
		int count=0;
		try {
			s = new Scanner(new File(fileName));
			while (s.hasNextLine() && count <50) {
				strings.add(s.nextLine());
				count++;
			}
			if(strings.size()==0){
				System.err.println("Input file empty: "+fileName+". Terminating program.");
				System.exit(1);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(fileName+ " : Specified file not found. Terminating program.");
			e.printStackTrace();
			System.exit(1);
			throw new RuntimeException(e);
			
		}
		finally{
			s.close();
		}
		return strings;
	}
	
	/**
	 * Takes output file name, list of students to print and average allocation score as inputs to be printed in file.
	 * 
	 *  
	 * @param fileName name of file to be created
	 * @param studentList list of students with allocated courses to be written to file
	 * @param avgAllocScore sum(totalAllocationScore)/totalStudents
	 * @return
	 */
	public int writeFile(String fileName,List<Student> studentList,double avgAllocScore){
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

			for(Student student : studentList){
				String text = String.format("%1$s %2$c %3$c %4$c %5$c %6$d\n",student.getStudName(),student.getAllocdFirst(),student.getAllocdSecond(),student.getAllocdThird(),student.getAllocdFourth(),student.getAllocScore());
				bw.write(text);
			}
			bw.write(String.format("\nAverage preference_score is: %.1f",avgAllocScore));
		} catch (IOException e) {
			System.err.println("Error while writing to file: "+fileName);
			e.printStackTrace();
			System.exit(1);
		}finally{
			//bw.close();
		}
		
		return 1;
	}
}
