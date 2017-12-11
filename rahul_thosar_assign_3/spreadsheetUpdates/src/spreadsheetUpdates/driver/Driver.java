
package spreadsheetUpdates.driver;

import spreadsheetUpdates.spreadsheet.Processor;
import spreadsheetUpdates.util.Logger;

public class Driver{

	
	public static void main(String args[]) {
	    Driver dr = new Driver();
	    dr.validateArgs(args);
	    Processor lineProcessor = new Processor();
	    lineProcessor.lineRead(args[0]);
	    lineProcessor.writeToFile(args[1]);

	} // end main(...)
	/*MEthod to validate input params
	 * @param 
	 */
	private void validateArgs(String args[]){
		//validate number of arguments
		if(args.length==3){
		    // get file names
			if(!args[0].equals("${arg0}")&& !args[1].equals("${arg1}") && !args[2].equals("${arg2}")){

			try{
			    Integer.parseInt(args[2]);
			    int debugLevel=Integer.parseInt(args[2]);
			    
			    //validate range of threads and debug level
			    if (debugLevel < 0 || debugLevel > 4) {
					System.err.println("debugLevel arg2 should be between 0 & 4. Terminating program");
					System.exit(1);
				}
			    // Set the Logger level
			    Logger.setDebugValue(debugLevel);
			    // return 

			}catch(IllegalArgumentException ex){
				System.err.println("NumberFormatException-Cannot parse to integer.");
				ex.printStackTrace();
				System.exit(1);
			}finally{
				
			}
			}else{
				System.err.println("Invalid number of arguments. Expected 3. Please refer README");
				System.exit(1);
			}
		}else{
			System.err.println("Invalid number of arguments. Expected 3. Please refer README");
			System.exit(1);
		}
	}

}

