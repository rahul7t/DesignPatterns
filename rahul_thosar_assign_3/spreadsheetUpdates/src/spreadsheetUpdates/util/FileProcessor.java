
package spreadsheetUpdates.util;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;

public class FileProcessor {
	
    private BufferedReader in;
    private FileWriter fw;
    
    /*
     * constructor with buffered reader
     * @param bufferedReader object
     */
    public FileProcessor(BufferedReader bufReaderIn){
	Logger.writeMessage("In FileProcessor, BufferedReader constructor", Logger.DebugLevel.CONSTRUCTOR);
	this.in=bufReaderIn;
	// code to handle argument
    }
    /*
     * constructor for output file
     * @param outFileNameIn
     */
    public FileProcessor(String outFileNameIn){
	Logger.writeMessage("In FileProcessor, String Parameter constructor", Logger.DebugLevel.CONSTRUCTOR);
	// code to handle argument
	try {
		fw = new FileWriter(outFileNameIn);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
    
    /**
     * method for reading a line from file
     * @return String
     */
    public synchronized String readLineFromFile(){
	// Code to read file line by line
    	String line;
    	try {
			if((line = in.readLine())!=null){
				//if(!line.trim().isEmpty()){
				return line;
			//	}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
    /*
     * Method for writing to file
     * @return String
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
    
    /*
     * Method to close file
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
