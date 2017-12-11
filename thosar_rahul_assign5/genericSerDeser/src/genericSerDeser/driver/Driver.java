package genericSerDeser.driver;

import genericSerDeser.driver.Driver;
import genericSerDeser.fileOperations.FileProcessor;
import genericSerDeser.strategy.SerStrategy;
import genericSerDeser.util.DPML;
import genericSerDeser.util.Logger;
import genericSerDeser.util.PopulateObjects;

public class Driver {

	public static void main(String[] args) {
		Driver dr = new Driver();
		dr.validateArgs(args);
		Logger.writeMessage("Processor lineRead method called", Logger.DebugLevel.IN_RESULTS);
		FileProcessor fp = new FileProcessor(args[0]);
		PopulateObjects po = new PopulateObjects(fp);
		SerStrategy dpmlSerializationStrateg = new DPML();
		
		po.deserObjects();
		po.serDeserObjects(args[1], dpmlSerializationStrateg);
		Logger.writeMessage(args[1]+" File created", Logger.DebugLevel.RELEASE);
	}

	/**
	 * Method for input argument validation
	 * 
	 * @param args
	 */
	private void validateArgs(String args[]) {
		// validate number of arguments
		if (args.length == 3) {
			// get file names
			if (!args[0].equals("${arg0}") && !args[1].equals("${arg1}") && !args[2].equals("${arg2}")) {

				try {
					Integer.parseInt(args[2]);
					int debugLevel = Integer.parseInt(args[2]);

					// validate range of threads and debug level
					if (debugLevel < 0 || debugLevel > 4) {
						System.err.println("debugLevel arg2 should be between 0 & 4. Terminating program");
						System.exit(1);
					}
					// Set the Logger level
					Logger.setDebugValue(debugLevel);
					// return

				} catch (IllegalArgumentException ex) {
					System.err.println("debugLevel arg2 should be number. Terminating program");
					ex.printStackTrace();
					System.exit(1);
				} finally {

				}
			} else {
				System.err.println("Invalid number of arguments. Expected 3. Please refer README");
				System.exit(1);
			}
		} else {
			System.err.println("Invalid number of arguments. Expected 3. Please refer README");
			System.exit(1);
		}
	}
}