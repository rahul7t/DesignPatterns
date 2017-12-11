package registrationScheduler.scheduler;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import registrationScheduler.util.CourseCounter;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Student;
import registrationScheduler.util.Logger.DebugLevel;

/**
 * Class for scheduling the students courses based on preferences
 * 
 * @author rthosar1
 *
 */
public class Scheduler implements SchedulerInterface {
	
	public Scheduler(){
		Logger.writeMessage("Scheduler constructor method invoked",DebugLevel.CONSTRUCTOR);
	}

	
	/**
	 * Returns the list of students with course allocated according to their preference.
	 * The list is sorted according reg-time.
	 * 
	 * <p>
	 * Course allocation strategy used: Assign 1st preference to each student, then 2nd preference,
	 * till 4th. If course A is full, then B, if B is full, then C and so on till H.
	 * - means no course allocated.
	 * Score calculation: 
	 * If the student requests A B E F and gets A B E F, then the total preference score for that student is: 1 + 2 + 3 + 4 = 10
	 * If the student requests A B E F and gets A B G, then the total preference score for that student is: 1 + 2 + 5 + 6 = 14
	 * </p>
	 * 
	 * @author rthosar1
	 * @param studentList contains the list of students with preferences and reg-times
	 * @return List of students with course allocated according to preference. List is sorted according to reg-time given. 
	 */
	public List<Student> scheduleStudents(List<Student> studentList) {

		CourseCounter courseCountObj = new CourseCounter();
		Collections.sort(studentList, new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return s1.getRegTime() - s2.getRegTime(); // Ascending
			}
		});
		// Scheduling strategy
		//First preference allocation
		for (Student student : studentList) {
			if (student.isFirstPrefAlloc() == false) {
				int temp1; //stores course count
				char t = student.getFirstPref();
				if (courseCountObj.isCourse(t)) { //if students 1st pref is available, then allocate it
					student.setAllocdFirst(t);
					temp1 = courseCountObj.getCourseCount(t);
					temp1--;
					courseCountObj.setCourseCount(t, temp1);
					student.setFirstPrefAlloc(true);
					student.setAllocScore(student.getAllocScore() + 1);
				} else {        				//else allocate the next alphabetically available course, provided its not in the next preferences
					char selectedAltCourse = '0';
					if (courseCountObj.isCourseA()) {
						selectedAltCourse = 'A';
						if (selectedAltCourse == student.getSecondPref() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseB() && selectedAltCourse == '0') {
						selectedAltCourse = 'B';
						if (selectedAltCourse == student.getSecondPref() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseC() && selectedAltCourse == '0') {
						selectedAltCourse = 'C';
						if (selectedAltCourse == student.getSecondPref() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseD() && selectedAltCourse == '0') {
						selectedAltCourse = 'D';
						if (selectedAltCourse == student.getSecondPref() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseE() && selectedAltCourse == '0') {
						selectedAltCourse = 'E';
						if (selectedAltCourse == student.getSecondPref() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseF() && selectedAltCourse == '0') {
						selectedAltCourse = 'F';
						if (selectedAltCourse == student.getSecondPref() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseG() && selectedAltCourse == '0') {
						selectedAltCourse = 'G';
						if (selectedAltCourse == student.getSecondPref() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseH() && selectedAltCourse == '0') {
						selectedAltCourse = 'H';
						if (selectedAltCourse == student.getSecondPref() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (selectedAltCourse != '0') {
						student.setAllocdFirst(selectedAltCourse);
						temp1 = courseCountObj.getCourseCount(selectedAltCourse);
						temp1--;
						courseCountObj.setCourseCount(selectedAltCourse, temp1);
						student.setFirstPrefAlloc(true);
						student.setAllocScore(student.getAllocScore() + 5);
					}
				}
				if (student.getAllocdFirst() == '-') {
					student.setAllocScore(student.getAllocScore() + 6);
				}
			}
		}
		// Allocation of second preference
		for (Student student : studentList) {
			// System.out.println(student);
			if (student.isSecondPrefAlloc() == false) {
				int temp2;
				char t = student.getSecondPref();
				if (courseCountObj.isCourse(t)) {
					student.setAllocdSecond(t);
					temp2 = courseCountObj.getCourseCount(t);
					temp2--;
					courseCountObj.setCourseCount(t, temp2);
					student.setSecondPrefAlloc(true);
					student.setAllocScore(student.getAllocScore() + 2);
				} else {
					char selectedAltCourse = '0';
					if (courseCountObj.isCourseA()) {
						selectedAltCourse = 'A';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getAllocdFirst()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseB() && selectedAltCourse == '0') {
						selectedAltCourse = 'B';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getAllocdFirst()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseC() && selectedAltCourse == '0') {
						selectedAltCourse = 'C';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getAllocdFirst()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseD() && selectedAltCourse == '0') {
						selectedAltCourse = 'D';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getAllocdFirst()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseE() && selectedAltCourse == '0') {
						selectedAltCourse = 'E';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getAllocdFirst()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseF() && selectedAltCourse == '0') {
						selectedAltCourse = 'F';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getAllocdFirst()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseG() && selectedAltCourse == '0') {
						selectedAltCourse = 'G';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getAllocdFirst()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseH() && selectedAltCourse == '0') {
						selectedAltCourse = 'H';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getAllocdFirst()) {
							selectedAltCourse = '0';
						}
					}
					if (selectedAltCourse != '0') {
						student.setAllocdSecond(selectedAltCourse);
						temp2 = courseCountObj.getCourseCount(selectedAltCourse);
						temp2--;
						courseCountObj.setCourseCount(selectedAltCourse, temp2);
						student.setSecondPrefAlloc(true);
						student.setAllocScore(student.getAllocScore() + 5);
					}
				}
				if (student.getAllocdSecond() == '-') {
					student.setAllocScore(student.getAllocScore() + 6);
				}
			}
		}
		// FOR 3RD COURSE
		for (Student student : studentList) {
			if (student.isThirdPrefAlloc() == false) {
				int temp3;
				char t = student.getThirdPref();
				if (courseCountObj.isCourse(t)) {
					student.setAllocdThird(t);
					temp3 = courseCountObj.getCourseCount(t);
					temp3--;
					courseCountObj.setCourseCount(t, temp3);
					student.setThirdPrefAlloc(true);
					student.setAllocScore(student.getAllocScore() + 3);
				} else {
					char selectedAltCourse = '0';
					if (courseCountObj.isCourseA()) {
						selectedAltCourse = 'A';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getSecondPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseB() && selectedAltCourse == '0') {
						selectedAltCourse = 'B';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getSecondPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseC() && selectedAltCourse == '0') {
						selectedAltCourse = 'C';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getSecondPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseD() && selectedAltCourse == '0') {
						selectedAltCourse = 'D';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getSecondPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseE() && selectedAltCourse == '0') {
						selectedAltCourse = 'E';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getSecondPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseF() && selectedAltCourse == '0') {
						selectedAltCourse = 'F';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getSecondPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseG() && selectedAltCourse == '0') {
						selectedAltCourse = 'G';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getSecondPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseH() && selectedAltCourse == '0') {
						selectedAltCourse = 'H';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getSecondPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()) {
							selectedAltCourse = '0';
						}
					}
					if (selectedAltCourse != '0') {
						student.setAllocdThird(selectedAltCourse);
						temp3 = courseCountObj.getCourseCount(selectedAltCourse);
						temp3--;
						courseCountObj.setCourseCount(selectedAltCourse, temp3);
						student.setThirdPrefAlloc(true);
						student.setAllocScore(student.getAllocScore() + 5);
					}
				}

				if (student.getAllocdThird() == '-') {
					student.setAllocScore(student.getAllocScore() + 6);
				}
			}
		}

		// FOR 4TH COURSE
		for (Student student : studentList) {
			if (student.isFourthPrefAlloc() == false) {
				int temp4;
				char t = student.getFourthPref();
				if (courseCountObj.isCourse(t)) {
					student.setAllocdFourth(t);
					temp4 = courseCountObj.getCourseCount(t);
					temp4--;
					courseCountObj.setCourseCount(t, temp4);
					student.setFourthPrefAlloc(true);
					student.setAllocScore(student.getAllocScore() + 4);
				} else {
					char selectedAltCourse = '0';
					if (courseCountObj.isCourseA()) {
						selectedAltCourse = 'A';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getSecondPref()
								|| selectedAltCourse == student.getThirdPref() || selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond() || selectedAltCourse == student.getAllocdThird()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseB() && selectedAltCourse == '0') {
						selectedAltCourse = 'B';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getSecondPref()
								|| selectedAltCourse == student.getThirdPref()|| selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond() || selectedAltCourse == student.getAllocdThird()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseC() && selectedAltCourse == '0') {
						selectedAltCourse = 'C';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getSecondPref()
								|| selectedAltCourse == student.getThirdPref()|| selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond() || selectedAltCourse == student.getAllocdThird()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseD() && selectedAltCourse == '0') {
						selectedAltCourse = 'D';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getSecondPref()
								|| selectedAltCourse == student.getThirdPref()|| selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond() || selectedAltCourse == student.getAllocdThird()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseE() && selectedAltCourse == '0') {
						selectedAltCourse = 'E';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getSecondPref()
								|| selectedAltCourse == student.getThirdPref()|| selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond() || selectedAltCourse == student.getAllocdThird()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseF() && selectedAltCourse == '0') {
						selectedAltCourse = 'F';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getSecondPref()
								|| selectedAltCourse == student.getThirdPref()|| selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond() || selectedAltCourse == student.getAllocdThird()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseG() && selectedAltCourse == '0') {
						selectedAltCourse = 'G';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getSecondPref()
								|| selectedAltCourse == student.getThirdPref()|| selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond() || selectedAltCourse == student.getAllocdThird()) {
							selectedAltCourse = '0';
						}
					}
					if (courseCountObj.isCourseH() && selectedAltCourse == '0') {
						selectedAltCourse = 'H';
						if (selectedAltCourse == student.getFirstPref() || selectedAltCourse == student.getSecondPref()
								|| selectedAltCourse == student.getThirdPref() || selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond() || selectedAltCourse == student.getAllocdThird()) {
							selectedAltCourse = '0';
						}
					}
					if (selectedAltCourse != '0') {
						student.setAllocdFourth(selectedAltCourse);
						temp4 = courseCountObj.getCourseCount(selectedAltCourse);
						temp4--;
						courseCountObj.setCourseCount(selectedAltCourse, temp4);
						student.setFourthPrefAlloc(true);
						student.setAllocScore(student.getAllocScore() + 5);
					}
				}
				if (student.getAllocdFourth() == '-') {
					student.setAllocScore(student.getAllocScore() + 6);
				}
			}
		}

		Logger.writeMessage(" disp"+courseCountObj, DebugLevel.RESULT);
		Collections.sort(studentList, new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				// return s1.getStudName().compareTo(s2.getStudName());
				return Integer.parseInt(s1.getStudName().replaceAll("[^0-9]", ""))
						- Integer.parseInt(s2.getStudName().replaceAll("[^0-9]", "")); // Ascending

			}
		});
		
		for(Student student: studentList){
			Logger.writeMessage(" disp:"+student,DebugLevel.RESULT);
		}

		return studentList;

	}

	/**
	 * Calculates the average allocation score
	 * 
	 * @author rthosar1
	 * @param studentList list of students with course allocated
	 * @return avgAllocScore sum(totalAllocationScore)/totalStudents
	 */
	public double calcAvgAllocScore(List<Student> studentList) {
		double avgAllocScore = 0;
		int totalAllocScore = 0;

		for (Student student : studentList) {
			//System.out.println(student);
			totalAllocScore = totalAllocScore + student.getAllocScore();
		}
		avgAllocScore = (double) totalAllocScore / (double) studentList.size();
		Logger.writeMessage(" calc:"+totalAllocScore + " " + studentList.size(),DebugLevel.CALC);
		Logger.writeMessage("avg score: " + avgAllocScore,DebugLevel.CALC);

		return avgAllocScore;
	}
}
