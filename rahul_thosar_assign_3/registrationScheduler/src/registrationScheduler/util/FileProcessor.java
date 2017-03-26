
package registrationScheduler.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;

public class FileProcessor {
	
    private BufferedReader in;
    private String outfilename;
    
    public FileProcessor(BufferedReader bufReaderIn){
	Logger.writeMessage("In FileProcessor, BufferedReader constructor", Logger.DebugLevel.CONSTRUCTOR);
	// code to handle argument
    }
    public FileProcessor(String outFileNameIn){
	Logger.writeMessage("In FileProcessor, String Parameter constructor", Logger.DebugLevel.CONSTRUCTOR);
	// code to handle argument
    }
    
    /**
     * @return String
     */
    public synchronized String readLineFromFile(){
	// Code to read file line by line
	return null;
    }
    
    // similarly a method to writeLineToFile().
    // other helper methods
}
