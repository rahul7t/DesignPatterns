package genericDeser.fileOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import genericDeser.util.Logger;

public class FileProcessor {
	private Scanner sc = null;

	/**
	 * constructor with buffered reader
	 * 
	 * @param bufferedReader object
	 */
	public FileProcessor(String fileName) {
		Logger.writeMessage("In FileProcessor constructor", Logger.DebugLevel.CONSTRUCTOR);
		File f = new File(fileName);
		try {
			this.sc = new Scanner(f);
			this.sc = this.sc.useDelimiter("\\s\\n");
		} catch (FileNotFoundException e) {
			System.err.println("File not found! : "+fileName);
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			
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
			if(line.trim().isEmpty()){
				System.err.println("Empty line in file(possiblly new line character). Please check");
				System.exit(1);
			}
			return line;
		}
		if(sc == null){
			sc.close();
		}
		return null;
	}
}
