
package registrationScheduler.driver;

import java.lang.IllegalArgumentException;
import java.util.Vector;
import registrationScheduler.objectPool.CoursePool;
import registrationScheduler.scheduler.CourseScheduler;
import registrationScheduler.store.Results;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Student;

public class Driver {
	static int DEBUG_VALUE;

	public static void main(String args[]) {
//		System.out.println("\n Geting Started\n");
		Driver dr = new Driver(); // create an instance of this Driver class
		dr.validateArgs(args); // invoke validateArgs(...)
		// create instances of CreateWorkers, Results, FileProcessor, and
		// CoursePool
		Vector<Student> studentList = new Vector<Student>(80);
		// Initializing Student list
		for (int i = 0; i < 80; i++) {
			Student temp = new Student();
			temp.setStudName("Student_" + (i + 1));
			studentList.add(i, temp);
		}

		Results res = new Results(studentList);

		FileProcessor fileProcessor1 = new FileProcessor(args[0]);
		FileProcessor fileProcessor2 = new FileProcessor(args[1]);
		FileProcessor fileProcessor3 = new FileProcessor(args[2], 1);
		CoursePool coursePoolObj = CoursePool.getUniqueInstance();
		CourseScheduler scheduler = new CourseScheduler(res, coursePoolObj);
		// Pass these references to the constructor of CreateWorkers (or any
		// other way is also fine)
		CreateWorkers createworkerobj = new CreateWorkers(res, fileProcessor1, fileProcessor2, fileProcessor3,
				coursePoolObj, scheduler);
		// createworkerobj.startWorkers(noOfThreads);
		// invoke startWorkers(...) method in CreateWorkers instance
		int noOfThreads = Integer.parseInt(args[3]);
		createworkerobj.startWorkers(noOfThreads);
		// invoke writeScheduleToStdout(...) on Results reference
		res.writeScheduleToStdout();
		// invoke writeScheduleToFile(...) on Results reference
		res.writeSchedulesToFile(args[2]);

	} // end main(...)

	private void validateArgs(String args[]) {
		// validate number of arguments
		if (args.length == 5) {
			// if no args passed, ant still passes this invalidating the length
			// validation check
			if ((args[0].equalsIgnoreCase("${arg0}")) || (args[1].equalsIgnoreCase("${arg1}"))
					|| (args[2].equalsIgnoreCase("${arg2}")) || (args[3].equalsIgnoreCase("${arg3}"))
					|| (args[4].equalsIgnoreCase("${arg4}"))) {
				System.err.println("Please enter 5 Arguments as specified in README. Terminating program.");
				System.exit(1);
			}
			// get file names
			// String regPref = args[0];
			// String addDrop = args[1];
			// String outputfile = args[2];

			try {
				// use Integer.parseInt(args[3]);
				int noOfThreads = Integer.parseInt(args[3]);
				// use debuglevel=Integer.parseInt(args[4]);
				int debuglevel = Integer.parseInt(args[4]);
				// validate range of threads and debug level
				if (noOfThreads < 1 || noOfThreads > 3) {
					System.err.println("noOfThreads args3 should be between 1 & 3. Terminating program");
					System.exit(1);
				}
				if (debuglevel < 0 || debuglevel > 4) {
					System.err.println("debuglevel arg4 should be between 0 & 4. Terminating program");
					System.exit(1);
				}
				// Set the Logger level
				Logger.setDebugValue(debuglevel);
				// return

			} catch (IllegalArgumentException ex) {
				System.err.println("NumberFormatException-Cannot parse to integer. args 3&4 should be integers");
				ex.printStackTrace();
				System.exit(1);

			} finally {
				// System.err.println("Restart Program with correct
				// parameters");
			}
		} else {
			System.err.println("Invalid number of arguments. Expected 5 agruments as given in readme");
			System.exit(1);
		}
	}

} // end public class Driver