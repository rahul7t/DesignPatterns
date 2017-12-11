
package registrationScheduler.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileProcessor {

	private String outfilename;
	private String inputFile;
	private Scanner s;
	private FileWriter fw;
	private BufferedWriter bw;
	private PrintWriter writer;

	// public FileProcessor(BufferedReader bufReaderIn) {
	// Logger.writeMessage("In FileProcessor, BufferedReader constructor",
	// Logger.DebugLevel.CONSTRUCTOR);
	// // code to handle argument
	// this.in=bufReaderIn;
	// }
	public FileProcessor(String inFile) {
		Logger.writeMessage("In FileProcessor, String input file constructor", Logger.DebugLevel.CONSTRUCTOR);
		this.inputFile = inFile;
		try {
			s = new Scanner(new File(inputFile));
			s.useDelimiter("\\s\\n");
		} catch (FileNotFoundException e) {
			System.err.println(inputFile + " : Specified file not found. Terminating program.");
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
	}

	public FileProcessor(String outFileNameIn, int mode) {
		Logger.writeMessage("In FileProcessor, String Parameter constructor", Logger.DebugLevel.CONSTRUCTOR);
		// code to handle argument
		this.outfilename = outFileNameIn;
		try {
			this.fw = new FileWriter(outFileNameIn);
			this.bw = new BufferedWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error while writing to file: " + outFileNameIn);
			e.printStackTrace();
			System.exit(1);
		} finally {

		}

	}

	public FileProcessor() {
		Logger.writeMessage("In FileProcessor, empty constructor", Logger.DebugLevel.CONSTRUCTOR);
	}
/**
 * This function takes output file name as input to help write to file.
 * It creates a file if not already present.
 * @param outFileNameIn
 */
	public synchronized void writerFile(String outFileNameIn) {
		try {
			// this.writer = new PrintWriter(outFileNameIn, "UTF-8");
			fw = new FileWriter(outFileNameIn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
	}

	/**
	 * This function reads a line from file
	 * @return String
	 */
	public synchronized String readLineFromFile() {
		// Code to read file line by line
		if (s.hasNextLine()) {
			return s.nextLine();
		}
		return null;
	}
	/**
	 * This function closes the scanner object
	 */
	public void finalize() {
		s.close();
	}

	// similarly a method to writeLineToFile().
	// other helper methods
	/**
	 * This function writes line to file
	 * @param lineToFile
	 * @return returns null
	 */
	public synchronized String writeLineToFile(String lineToFile) {
		//System.out.println(lineToFile);
		if (lineToFile != null) {
			try {
				fw.write(lineToFile);
				fw.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
			}
		}
		return null;
	}
	/**
	 * This function is used to close the file writer
	 */
	public void closeFile() {
		try {
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
	}
}
