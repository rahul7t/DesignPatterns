
package registrationScheduler.store;

import registrationScheduler.util.StdoutDisplayInterface;
import registrationScheduler.util.Student;

import java.util.Vector;

import registrationScheduler.util.FileDisplayInterface;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

public class Results implements StdoutDisplayInterface, FileDisplayInterface {

	public Results(Vector<Student> studentList2) {
		Logger.writeMessage("In Results, Vector of Student constructor", Logger.DebugLevel.CONSTRUCTOR);
			this.studentList=studentList2;
	}

	// private data structure
	private Vector<Student> studentList = new Vector<Student>(80);

	// methods to read/write from/to the data structure
	
	/**
	 * This method writes to stdout
	 */
	public synchronized void writeScheduleToStdout() {
		Logger.writeMessage("In Results writeScheduleToStdout", Logger.DebugLevel.FROM_RESULTS);
		//System.out.println("From writeScheduleToStdout");
		double avgAllocScore = 0;
		int totalAllocScore = 0;
		for (Student student : studentList) {
			String text = String.format("%1$s %2$c %3$c %4$c %5$c %6$c %7$d",student.getStudName(),student.getAllocdFirst(),student.getAllocdSecond(),student.getAllocdThird(),student.getAllocdFourth(),student.getAllocdFifth(),student.getAllocScore());
			totalAllocScore = totalAllocScore + student.getAllocScore();
			//System.out.println(text);
			Logger.writeMessage(text, Logger.DebugLevel.FROM_RESULTS);
		}
		avgAllocScore = (double) totalAllocScore / (double) studentList.size();
		String text2 = String.format("\nAverage preference_score is: %.1f",avgAllocScore);
//		System.out.println(text2);
		Logger.writeMessage(text2, Logger.DebugLevel.FROM_RESULTS);
		String text3 = String.format("The average preference value is: %.1f",avgAllocScore);
		Logger.writeMessage(text3, Logger.DebugLevel.RELEASE);
//		System.out.println("exiting writeScheduleToStdout");
	}

	public synchronized Vector<Student> getStudentList() {
		return studentList;
	}

	public synchronized void setStudentList(Vector<Student> studentList) {
		this.studentList = studentList;
	}

	/**
	 * This method writes to file as specified by input parameter
	 * @param	outFileName
	 */
	@Override
	public synchronized void writeSchedulesToFile(String outFileName) {
//		System.out.println("From writeSchedulesToFile");
		double avgAllocScore = 0;
		int totalAllocScore = 0;
		FileProcessor fp = new FileProcessor();
		fp.writerFile(outFileName);
		for (Student student : studentList) {
			String text = String.format("%1$s %2$c %3$c %4$c %5$c %6$c %7$d",student.getStudName(),student.getAllocdFirst(),student.getAllocdSecond(),student.getAllocdThird(),student.getAllocdFourth(),student.getAllocdFifth(),student.getAllocScore());
			fp.writeLineToFile(text);
			totalAllocScore = totalAllocScore + student.getAllocScore();
//			System.out.println(student.toString());
		}
		avgAllocScore = (double) totalAllocScore / (double) studentList.size();
		String text2 = String.format("Average preference_score is: %.1f",avgAllocScore);
		fp.writeLineToFile("\n"+text2);
//		System.out.println("exiting after wards");
		fp.closeFile();
		
	}

	// other methods
}