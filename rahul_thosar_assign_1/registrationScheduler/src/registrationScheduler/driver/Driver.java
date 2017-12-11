
package registrationScheduler.driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import registrationScheduler.scheduler.Scheduler;
import registrationScheduler.scheduler.SchedulerInterface;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Student;
import registrationScheduler.util.Logger;

public class Driver {
	static int DEBUG_VALUE;
	
	public static void main(String args[]) {
		List<String> strings = new ArrayList<String>();
		Student studentObj = null;
		// CourseCounter courseCountObj = new CourseCounter();
		List<Student> studentList = new ArrayList<Student>();
		List<Student> studentListAllocd = new ArrayList<Student>();
		SchedulerInterface schedulerObj = new Scheduler();
		System.out.println("\n The args[0] is: " + args[0]);
		System.out.println("\n The args[1] is: " + args[1]);
		System.out.println("\n The args[2] is: " + args[2]);
		System.out.println("\n The args[3] is: " + args[3]);
		//System.out.println("Length args: " + args.length);
		if (args.length != 4) {
			System.err.println("Please enter 4 Arguments as specified in README. Terminating program.");
			System.exit(1);
		}
		try {
			if (Integer.parseInt(args[3]) < 0 || Integer.parseInt(args[3]) > 4) {
				System.err.println("Argument debug level should be a Number between [0 - 4]. Terminating program.");
				System.exit(1);
			}
			else{
				DEBUG_VALUE = Integer.parseInt(args[3]);
			}
		} catch (NumberFormatException e) {
			System.err.println("Argument debug level should be a Number. Terminating program.");
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
		if ((args[0].equalsIgnoreCase("${arg0}")) || (args[1].equalsIgnoreCase("${arg1}"))
				|| (args[2].equalsIgnoreCase("${arg2}")) || (args[3].equalsIgnoreCase("${arg3}"))) {
			System.err.println("Please enter 4 Arguments as specified in README. Terminating program.");
			System.exit(0);
		} else {
			Logger.setDebugValue(Integer.parseInt(args[3]));
			FileProcessor f = new FileProcessor();
			strings = f.loadFile(args[1]);

			Iterator<String> stringsItr = strings.iterator();
			while (stringsItr.hasNext()) {
				String[] token = stringsItr.next().split(" ");
				studentObj = new Student();
				studentObj.setRegTime(Integer.parseInt((token[1].replaceAll("[^A-Za-z0-9_]", ""))));
				studentObj.setStudName((token[0].replaceAll("[^A-Za-z0-9_]", "")));
				studentList.add(studentObj);
			}
			// System.out.println("stud list size: " + studentList.size());

			strings = f.loadFile(args[0]);
			stringsItr = strings.iterator();
			while (stringsItr.hasNext()) {
				String[] token = stringsItr.next().split(" ");
				for (Student student : studentList) {
					if (student.getStudName().equalsIgnoreCase(token[0])) {
						student.setFirstPref(token[1].charAt(0));
						student.setSecondPref(token[2].charAt(0));
						student.setThirdPref(token[3].charAt(0));
						student.setFourthPref(token[4].charAt(0));
					}
				}
			}
			studentListAllocd = schedulerObj.scheduleStudents(studentList);

			double avgAllocScore = schedulerObj.calcAvgAllocScore(studentListAllocd);
			f.writeFile(args[2], studentListAllocd, avgAllocScore);

			//////
		}

	} // end main(...)

} // end public class Driver
