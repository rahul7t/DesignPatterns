
package registrationScheduler.threadMgmt;

import registrationScheduler.objectPool.CoursePool;
import registrationScheduler.scheduler.CourseScheduler;
import registrationScheduler.store.Results;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

public class WorkerThread implements Runnable {

	Results result;
	FileProcessor fProcessor1;
	FileProcessor fProcessor2;
	FileProcessor fProcessor3;
	CoursePool coursePool;
	CourseScheduler cScheduler;

	public WorkerThread(Results res, FileProcessor fileProcessor1, FileProcessor fileProcessor2, FileProcessor fileProcessor3, CoursePool coursePoolObj, CourseScheduler scheduler) {
		Logger.writeMessage("In WorkerThread, Result, FileProcessor CoursePool CourseSchaduler constructor", Logger.DebugLevel.CONSTRUCTOR);
		this.fProcessor1=fileProcessor1;
		this.fProcessor2=fileProcessor2;
		this.fProcessor3=fileProcessor3;
		this.result = res;
		this.coursePool = coursePoolObj;
		this.cScheduler = scheduler;
	}

	/**
	 * Overridden method for Thread run
	 */
	public void run() {
		// Logger.writeMessage(...)
		Logger.writeMessage("WorkerThread run method called", Logger.DebugLevel.IN_RUN);
		
		
		String lineFromFile= fProcessor1.readLineFromFile();
		// while it is no end of registration-preference-input file
		// read a line
		// call a method in the scheudler algorithm to process it
		while(lineFromFile!=null){
			cScheduler.scheduleStudents(lineFromFile);
			lineFromFile= fProcessor1.readLineFromFile();
		}
		//System.out.println(coursePool.toString());
		
		String lineFromFile2 = fProcessor2.readLineFromFile();
//		System.out.println("+++"+lineFromFile2);
		// while it is not end of add-drop-file
		// read a line
		// call a method in the scheudler algorithm to process it
		while(lineFromFile2!=null){

			cScheduler.courseAddDrop(lineFromFile2);
			//System.out.println("Entering!");
			lineFromFile2= fProcessor2.readLineFromFile();
//			System.out.println("+++"+lineFromFile2);
		}

		

	}

}
