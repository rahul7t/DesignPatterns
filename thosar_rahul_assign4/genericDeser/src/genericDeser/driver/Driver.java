package genericDeser.driver;

import genericDeser.fileOperations.FileProcessor;
import genericDeser.util.Logger;
import genericDeser.util.PopulateObjects;

public class Driver {

	public static void main(String[] args) {
		Driver dr = new Driver();
		dr.validateArgs(args);
		Logger.writeMessage("Processor lineRead method called", Logger.DebugLevel.IN_RESULTS);
		FileProcessor fp = new FileProcessor("input2.txt");
		PopulateObjects po = new PopulateObjects(fp);
		po.deserObjects();
		po.counterFirst();
		po.counterSecond();
	}

	/**
	 * Method for input argument validation
	 * 
	 * @param args
	 */
	private void validateArgs(String args[]) {
		// validate number of arguments
		if (args.length == 2) {
			// get file names
			if (!args[0].equals("${arg0}") && !args[1].equals("${arg1}")) {

				try {
					Integer.parseInt(args[1]);
					int debugLevel = Integer.parseInt(args[1]);

					// validate range of threads and debug level
					if (debugLevel < 0 || debugLevel > 4) {
						System.err.println("debugLevel arg1 should be between 0 & 4. Terminating program");
						System.exit(1);
					}
					// Set the Logger level
					Logger.setDebugValue(debugLevel);
					// return

				} catch (IllegalArgumentException ex) {
					System.err.println("NumberFormatException-Cannot parse to integer.");
					ex.printStackTrace();
					System.exit(1);
				} finally {

				}
			} else {
				System.err.println("Invalid number of arguments. Expected 2. Please refer README");
				System.exit(1);
			}
		} else {
			System.err.println("Invalid number of arguments. Expected 3. Please refer README");
			System.exit(1);
		}
	}

}
