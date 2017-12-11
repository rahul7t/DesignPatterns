package genericSerDeser.fileOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import genericSerDeser.util.Logger;

public class FileProcessor {
	private Scanner sc = null;
	private FileWriter fw = null;

	/**
	 * constructor with buffered reader
	 * 
	 * @param bufferedReader
	 *            object
	 */
	public FileProcessor(String fileName) {
		Logger.writeMessage("In input FileProcessor constructor, String "+fileName+" Parameter constructor", Logger.DebugLevel.CONSTRUCTOR);
		File f = new File(fileName);
		try {
			this.sc = new Scanner(f);
			this.sc = this.sc.useDelimiter("\\s\\n");
		} catch (FileNotFoundException e) {
			System.err.println("File not found! : " + fileName);
			System.err.println("Terminating program");
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
	}

	/****
	 * constructor for output file
	 * 
	 * @param outFileNameIn
	 * @param op
	 */
	public FileProcessor(String outFileNameIn, String op) {
		Logger.writeMessage("In output FileProcessor, String "+outFileNameIn+" String "+op+" Parameter constructor", Logger.DebugLevel.CONSTRUCTOR);
		// code to handle argument
		try {
			fw = new FileWriter(outFileNameIn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error while creating output file : " + outFileNameIn);
			System.err.println("Terminating program");
			e.printStackTrace();
			System.exit(1);
		}finally{
			
		}
	}

	/**
	 * method for reading a line from file
	 * 
	 * @return String
	 */
	public String readLineFromFile() {
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (line.trim().isEmpty()) {
				System.err.println("Empty line in file(possiblly new line character). Please check");
				System.err.println("Terminating program");
				System.exit(1);
			}
			return line;
		}
		if (sc == null) {
			sc.close();
		}
		return null;
	}

	/*
	 * Method for writing to file
	 * 
	 * @return String
	 */
	public String writeLineToFile(String lineToFile) {
		// System.out.println(lineToFile);
		if (lineToFile != null) {
			try {
				fw.write(lineToFile);
				// fw.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("Error while writing line to output file : " + lineToFile);
				System.err.println("Terminating program");
				e.printStackTrace();
				System.exit(1);
			} finally {

			}
		}
		return null;
	}

	/*
	 * Method to close file
	 */
	public void closeFile() {
		try {
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error while writing closing output file" );
			System.err.println("Terminating program");
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
	}
}
