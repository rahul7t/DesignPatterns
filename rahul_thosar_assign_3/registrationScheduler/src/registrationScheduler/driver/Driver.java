
package registrationScheduler.driver;

import java.lang.IllegalArgumentException;

import registrationScheduler.util.Logger;

public class Driver{

	
	public static void main(String args[]) {
	    Driver dr = new Driver();
	    dr.validateArgs(args);

	    System.out.println("\n Geting Started\n");
	    // create an instance of this Driver class
	    // invoke validateArgs(...)
	    // create instances of CreateWorkers, Results, FileProcessor, and CoursePool
	    // Pass these references to the constructor of CreateWorkers (or any other way is also fine)
	    // 		createworkerobj.startWorkers(noofthreads);
	    // invoke startWorkers(...) method in CreateWorkers instance
	    // invoke  writeScheduleToStdout(...) on Results reference
	    // invoke  writeScheduleToFile(...) on Results reference

	} // end main(...)
	
	private void validateArgs(String args[]){
		//validate number of arguments
		if(args.length==5){
		    // get file names

			try{
			    // use Integer.parseInt(args[3]);
			    // use debuglevel=Integer.parseInt(args[4]);
			    //validate range of threads and debug level
			    // Set the Logger level
			    // return 

			}catch(IllegalArgumentException ex){
				System.err.println("NumberFormatException-Cannot parse to integer.");
				ex.printStackTrace();
				System.exit(1);
			}
		}else{
			System.err.println("Invalid number of arguments. Expected [FIXME: provide details here]");
			System.exit(1);
		}
	}

    

} // end public class Driver

