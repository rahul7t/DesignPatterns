
package registrationScheduler.threadMgmt;

import registrationScheduler.objectPool.CoursePool;
import registrationScheduler.scheduler.CourseScheduler;
import registrationScheduler.store.Results;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

public class CreateWorkers {

	Results result;
	FileProcessor fProcessor1,fProcessor2,fProcessor3;
	CoursePool coursePool;
	CourseScheduler cScheduler;
	Thread[] threads;

	public CreateWorkers(Results res, FileProcessor fileProcessor1, FileProcessor fileProcessor2, FileProcessor fileProcessor3, CoursePool coursePoolObj, CourseScheduler scheduler) {
		Logger.writeMessage("In CreateWorkers, Result, FileProcessor CoursePool CourseSchaduler constructor", Logger.DebugLevel.CONSTRUCTOR);
		this.result = res;
		this.fProcessor1 = fileProcessor1;
		this.fProcessor2 = fileProcessor2;
		this.fProcessor3 = fileProcessor3;
		this.coursePool = coursePoolObj;
		this.cScheduler = scheduler;
	}
	
	/**
	 * This function is used to start the worker threads
	 * @param noOfThreads
	 */
	public void startWorkers(int noOfThreads) {
		//WorkerThread wt = new WorkerThread(fp, res, obj, assign);
		// create an array of Threads (size = noOfThreads
		threads = new Thread[noOfThreads];
		// for(int i=0;i<noOfThreads;++i){
		for (int i = 0; i < noOfThreads; i++) {
			// create a worker thread instance
			// create a Thread instance
			// start the thread
			// close the loop
			threads[i] = new Thread(new WorkerThread(result,fProcessor1,fProcessor2,fProcessor3, coursePool,cScheduler));
			threads[i].start();
		}

		// for(int j=0;j<noOfThreads;++j){
		// try {
		// // join on each thread (note you have an array of threads above
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// System.exit(1);
		// }
		// }
		for (int j = 0; j < noOfThreads; j++) {
			try {
				threads[j].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(1);
			}finally{
				
			}
		}

	}
}
