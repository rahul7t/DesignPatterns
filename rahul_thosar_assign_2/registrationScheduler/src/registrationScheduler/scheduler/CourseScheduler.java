package registrationScheduler.scheduler;

import java.util.Vector;

import registrationScheduler.objectPool.CoursePool;
import registrationScheduler.store.Results;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Student;

public class CourseScheduler {
	private Results result;
	private CoursePool coursePool;
	
	
	public CourseScheduler(Results res, CoursePool coursePoolObj) {
		Logger.writeMessage("In CourseScheduler, Result CoursePool constructor", Logger.DebugLevel.CONSTRUCTOR);
		this.result = res;
		this.coursePool = coursePoolObj;
	}

	/**
	 * This function is used to schedule students. It takes input line from file and then works on scheduling
	 * @param lineFromFile
	 */
	public synchronized void scheduleStudents(String lineFromFile){
		String [] token = lineFromFile.split("\\s+");
		//System.out.println("***"+token[0]+token[1]+token[2]+token[3]+token[4]+token[5]);
		
		
		Vector<Student> studlist = result.getStudentList();
		for (Student student : studlist) {
			if(student.getStudName().equalsIgnoreCase(token[0])){
				student.setFirstPref(token[1].charAt(0));
				student.setSecondPref(token[2].charAt(0));
				student.setThirdPref(token[3].charAt(0));
				student.setFourthPref(token[4].charAt(0));
				student.setFifthPref(token[5].charAt(0));
			}
		}
		 
		
//		System.out.println("After adding student");
		for (Student student : studlist) {
			if(student.getFirstPref()!='-' && student.getSecondPref()!='-' && student.getThirdPref()!='-'
					&& student.getFourthPref()!='-' && student.getFifthPref()!='-'){
			if(student.isFirstPrefAlloc()==false){			//First preference allocation logic
				int temp1;
				char t = student.getFirstPref();
				if(coursePool.isCourseAvailable(t)){ 		//if students 1st pref is available, then allocate it
					student.setAllocdFirst(t);
					temp1 = coursePool.getCourseCount(t);
					temp1--;
					coursePool.setCourseCount(t, temp1);
					student.setFirstPrefAlloc(true);
					student.setAllocScore(student.getAllocScore() + 6);
					Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdFirst()+" "+student.isFirstPrefAlloc()+" "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
				}
				else{
					char selectedAltCourse='0';
					if(coursePool.isCourseA()){
						selectedAltCourse = 'A';
						if(selectedAltCourse==student.getSecondPref() || selectedAltCourse==student.getThirdPref() 
								|| selectedAltCourse==student.getFourthPref() || selectedAltCourse==student.getFifthPref()){
							selectedAltCourse='0';
						}
					}
					if(coursePool.isCourseB() && selectedAltCourse == '0'){
						selectedAltCourse = 'B';
						if(selectedAltCourse==student.getSecondPref() || selectedAltCourse==student.getThirdPref() 
								|| selectedAltCourse==student.getFourthPref() || selectedAltCourse==student.getFifthPref()){
							selectedAltCourse='0';
						}
					}
					if(coursePool.isCourseC() && selectedAltCourse == '0'){
						selectedAltCourse = 'C';
						if(selectedAltCourse==student.getSecondPref() || selectedAltCourse==student.getThirdPref() 
								|| selectedAltCourse==student.getFourthPref() || selectedAltCourse==student.getFifthPref()){
							selectedAltCourse='0';
						}
					}
					if(coursePool.isCourseD() && selectedAltCourse == '0'){
						selectedAltCourse = 'D';
						if(selectedAltCourse==student.getSecondPref() || selectedAltCourse==student.getThirdPref() 
								|| selectedAltCourse==student.getFourthPref() || selectedAltCourse==student.getFifthPref()){
							selectedAltCourse='0';
						}
					}
					if(coursePool.isCourseE() && selectedAltCourse == '0'){
						selectedAltCourse = 'E';
						if(selectedAltCourse==student.getSecondPref() || selectedAltCourse==student.getThirdPref() 
								|| selectedAltCourse==student.getFourthPref() || selectedAltCourse==student.getFifthPref()){
							selectedAltCourse='0';
						}
					}
					if(coursePool.isCourseF() && selectedAltCourse == '0'){
						selectedAltCourse = 'F';
						if(selectedAltCourse==student.getSecondPref() || selectedAltCourse==student.getThirdPref() 
								|| selectedAltCourse==student.getFourthPref() || selectedAltCourse==student.getFifthPref()){
							selectedAltCourse='0';
						}
					}
					if(coursePool.isCourseG() && selectedAltCourse == '0'){
						selectedAltCourse = 'G';
						if(selectedAltCourse==student.getSecondPref() || selectedAltCourse==student.getThirdPref() 
								|| selectedAltCourse==student.getFourthPref() || selectedAltCourse==student.getFifthPref()){
							selectedAltCourse='0';
						}
					}
					if(coursePool.isCourseH() && selectedAltCourse == '0'){
						selectedAltCourse = 'H';
						if(selectedAltCourse==student.getSecondPref() || selectedAltCourse==student.getThirdPref() 
								|| selectedAltCourse==student.getFourthPref() || selectedAltCourse==student.getFifthPref()){
							selectedAltCourse='0';
						}
					}
					if (selectedAltCourse != '0') {
						student.setAllocdFirst(selectedAltCourse);
						temp1 = coursePool.getCourseCount(selectedAltCourse);
						temp1--;
						coursePool.setCourseCount(selectedAltCourse, temp1);
						student.setFirstPrefAlloc(true);
						student.setAllocScore(student.getAllocScore() + 1);
						Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdFirst()+" "+student.isFirstPrefAlloc()+" "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
					}
					
				}
				if (student.getAllocdFirst() == '-') {
					student.setAllocScore(student.getAllocScore() + 0);
					Logger.writeMessage("In Result updated, Studlist reference updated with: "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
				}
				
			}
			
			if (student.isSecondPrefAlloc() == false) {			//Second preference allocation logic
				int temp2;
				char t = student.getSecondPref();
				if (coursePool.isCourseAvailable(t)) {
					student.setAllocdSecond(t);
					temp2 = coursePool.getCourseCount(t);
					temp2--;
					coursePool.setCourseCount(t, temp2);
					student.setSecondPrefAlloc(true);
					student.setAllocScore(student.getAllocScore() + 5);
					Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdSecond()+" "+student.isSecondPrefAlloc()+" "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
				} else {
					char selectedAltCourse = '0';
					if (coursePool.isCourseA()) {
						selectedAltCourse = 'A';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseB() && selectedAltCourse == '0') {
						selectedAltCourse = 'B';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseC() && selectedAltCourse == '0') {
						selectedAltCourse = 'C';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseD() && selectedAltCourse == '0') {
						selectedAltCourse = 'D';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseE() && selectedAltCourse == '0') {
						selectedAltCourse = 'E';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseF() && selectedAltCourse == '0') {
						selectedAltCourse = 'F';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseG() && selectedAltCourse == '0') {
						selectedAltCourse = 'G';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseH() && selectedAltCourse == '0') {
						selectedAltCourse = 'H';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getThirdPref()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (selectedAltCourse != '0') {
						student.setAllocdSecond(selectedAltCourse);
						temp2 = coursePool.getCourseCount(selectedAltCourse);
						temp2--;
						coursePool.setCourseCount(selectedAltCourse, temp2);
						student.setSecondPrefAlloc(true);
						student.setAllocScore(student.getAllocScore() + 1);
						Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdSecond()+" "+student.isSecondPrefAlloc()+" "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
					}
				}
				if (student.getAllocdFirst() == '-') {
					student.setAllocScore(student.getAllocScore() + 0);
					Logger.writeMessage("In Result updated, Studlist reference updated with: "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
				}
			}
			
			if (student.isThirdPrefAlloc() == false) {			//Third preference allocation logic
				int temp3;
				char t = student.getThirdPref();
				if (coursePool.isCourseAvailable(t)) {
					student.setAllocdThird(t);
					temp3 = coursePool.getCourseCount(t);
					temp3--;
					coursePool.setCourseCount(t, temp3);
					student.setThirdPrefAlloc(true);
					student.setAllocScore(student.getAllocScore() + 4);
					Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdThird()+" "+student.isThirdPrefAlloc()+" "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
				} else {
					char selectedAltCourse = '0';
					if (coursePool.isCourseA()) {
						selectedAltCourse = 'A';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseB() && selectedAltCourse == '0') {
						selectedAltCourse = 'B';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseC() && selectedAltCourse == '0') {
						selectedAltCourse = 'C';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseD() && selectedAltCourse == '0') {
						selectedAltCourse = 'D';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseE() && selectedAltCourse == '0') {
						selectedAltCourse = 'E';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseF() && selectedAltCourse == '0') {
						selectedAltCourse = 'F';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseG() && selectedAltCourse == '0') {
						selectedAltCourse = 'G';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseH() && selectedAltCourse == '0') {
						selectedAltCourse = 'H';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getFourthPref() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (selectedAltCourse != '0') {
						student.setAllocdThird(selectedAltCourse);
						temp3 = coursePool.getCourseCount(selectedAltCourse);
						temp3--;
						coursePool.setCourseCount(selectedAltCourse, temp3);
						student.setThirdPrefAlloc(true);
						student.setAllocScore(student.getAllocScore() + 1);
						Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdThird()+" "+student.isThirdPrefAlloc()+" "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
					}
				}
				if (student.getAllocdFirst() == '-') {
					student.setAllocScore(student.getAllocScore() + 0);
					Logger.writeMessage("In Result updated, Studlist reference updated with: "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
				}
			}
			
			if (student.isFourthPrefAlloc() == false) {				//Fourth preference allocation logic
				int temp4;
				char t = student.getFourthPref();
				if (coursePool.isCourseAvailable(t)) {
					student.setAllocdFourth(t);
					temp4 = coursePool.getCourseCount(t);
					temp4--;
					coursePool.setCourseCount(t, temp4);
					student.setFourthPrefAlloc(true);
					student.setAllocScore(student.getAllocScore() + 3);
					Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdFourth()+" "+student.isFourthPrefAlloc()+" "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
				} else {
					char selectedAltCourse = '0';
					if (coursePool.isCourseA()) {
						selectedAltCourse = 'A';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getAllocdThird() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseB() && selectedAltCourse == '0') {
						selectedAltCourse = 'B';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getAllocdThird() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseC() && selectedAltCourse == '0') {
						selectedAltCourse = 'C';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getAllocdThird() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseD() && selectedAltCourse == '0') {
						selectedAltCourse = 'D';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getAllocdThird() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseE() && selectedAltCourse == '0') {
						selectedAltCourse = 'E';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getAllocdThird() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseF() && selectedAltCourse == '0') {
						selectedAltCourse = 'F';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getAllocdThird() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseG() && selectedAltCourse == '0') {
						selectedAltCourse = 'G';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getAllocdThird() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseH() && selectedAltCourse == '0') {
						selectedAltCourse = 'H';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getAllocdThird() || selectedAltCourse == student.getFifthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (selectedAltCourse != '0') {
						student.setAllocdFourth(selectedAltCourse);
						temp4 = coursePool.getCourseCount(selectedAltCourse);
						temp4--;
						coursePool.setCourseCount(selectedAltCourse, temp4);
						student.setFourthPrefAlloc(true);
						student.setAllocScore(student.getAllocScore() + 1);
						Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdFourth()+" "+student.isFourthPrefAlloc()+" "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
					}
				}
				if (student.getAllocdFirst() == '-') {
					student.setAllocScore(student.getAllocScore() + 0);
					Logger.writeMessage("In Result updated, Studlist reference updated with: "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
				}
			}
			
			if (student.isFifthPrefAlloc() == false) {				//Fifth preference allocation logic
				int temp5;
				char t = student.getFifthPref();
				if (coursePool.isCourseAvailable(t)) {
					student.setAllocdFifth(t);
					temp5 = coursePool.getCourseCount(t);
					temp5--;
					coursePool.setCourseCount(t, temp5);
					student.setFifthPrefAlloc(true);
					student.setAllocScore(student.getAllocScore() + 2);
					Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdFifth()+" "+student.isFifthPrefAlloc()+" "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
				} else {
					char selectedAltCourse = '0';
					if (coursePool.isCourseA()) {
						selectedAltCourse = 'A';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getAllocdThird() || selectedAltCourse == student.getFourthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseB() && selectedAltCourse == '0') {
						selectedAltCourse = 'B';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getAllocdThird() || selectedAltCourse == student.getFourthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseC() && selectedAltCourse == '0') {
						selectedAltCourse = 'C';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getAllocdThird() || selectedAltCourse == student.getFourthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseD() && selectedAltCourse == '0') {
						selectedAltCourse = 'D';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getAllocdThird() || selectedAltCourse == student.getFourthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseE() && selectedAltCourse == '0') {
						selectedAltCourse = 'E';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getAllocdThird() || selectedAltCourse == student.getFourthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseF() && selectedAltCourse == '0') {
						selectedAltCourse = 'F';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getAllocdThird() || selectedAltCourse == student.getFourthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseG() && selectedAltCourse == '0') {
						selectedAltCourse = 'G';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getAllocdThird() || selectedAltCourse == student.getFourthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (coursePool.isCourseH() && selectedAltCourse == '0') {
						selectedAltCourse = 'H';
						if (selectedAltCourse == student.getAllocdFirst() || selectedAltCourse == student.getAllocdSecond()
								|| selectedAltCourse == student.getAllocdThird() || selectedAltCourse == student.getFourthPref()) {
							selectedAltCourse = '0';
						}
					}
					if (selectedAltCourse != '0') {
						student.setAllocdFifth(selectedAltCourse);
						temp5 = coursePool.getCourseCount(selectedAltCourse);
						temp5--;
						coursePool.setCourseCount(selectedAltCourse, temp5);
						student.setFifthPrefAlloc(true);
						student.setAllocScore(student.getAllocScore() + 1);
						Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdFifth()+" "+student.isFifthPrefAlloc()+" "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
					}
				}
				if (student.getAllocdFirst() == '-') {
					student.setAllocScore(student.getAllocScore() + 0);
					Logger.writeMessage("In Result updated, Studlist reference updated with: "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
				}
			}
		//	System.out.println(student);
		}
		}
		
	}
	
	/**
	 * This function performs add drop course logic based on input lines from file
	 * @param lineFromFile2
	 */
	public synchronized void courseAddDrop(String lineFromFile2){
//		System.out.println("========"+lineFromFile2);
//		System.out.println(coursePool.toString());
		String [] tokens = lineFromFile2.split("\\s+");
		Vector<Student> studlist = result.getStudentList();
//		System.out.println("***"+token[0]+token[1]+token[2]+token[3]+token[4]+token[5]);
		String studName = tokens[0];
		String addDrop = tokens[1];
		for (int i = 2; i < tokens.length; i++) {
//			System.out.print(tokens[i] + " ");
			if ("0".equalsIgnoreCase(addDrop)) { // Course drop request
				for (Student student : studlist) {
					if(student.getStudName().equalsIgnoreCase(studName)){
						int temp=0;
						//if matches with any one of students allocations, drop that course and update the course seats
						if(tokens[i].charAt(0)==student.getAllocdFirst() ){
							temp = coursePool.getCourseCount(student.getAllocdFirst());
							temp++;
							coursePool.setCourseCount(student.getAllocdFirst(), temp);
							student.setAllocdFirst('-');
							student.setFirstPrefAlloc(false);
							Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdFirst()+" "+student.isFirstPrefAlloc(), Logger.DebugLevel.IN_RESULTS);
						}
						if(tokens[i].charAt(0)==student.getAllocdSecond() ){
							temp = coursePool.getCourseCount(student.getAllocdSecond());
							temp++;
							coursePool.setCourseCount(student.getAllocdSecond(), temp);
							student.setAllocdSecond('-');
							student.setSecondPrefAlloc(false);
							Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdSecond()+" "+student.isSecondPrefAlloc(), Logger.DebugLevel.IN_RESULTS);
						}
						if(tokens[i].charAt(0)==student.getAllocdThird()){
							temp = coursePool.getCourseCount(student.getAllocdThird());
							temp++;
							coursePool.setCourseCount(student.getAllocdThird(), temp);
							student.setAllocdThird('-');
							student.setThirdPrefAlloc(false);
							Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdThird()+" "+student.isThirdPrefAlloc(), Logger.DebugLevel.IN_RESULTS);
						}
						if(tokens[i].charAt(0)==student.getAllocdFourth()){
							temp = coursePool.getCourseCount(student.getAllocdFourth());
							temp++;
							coursePool.setCourseCount(student.getAllocdFourth(), temp);
							student.setAllocdFourth('-');
							student.setFourthPrefAlloc(false);
							Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdFourth()+" "+student.isFourthPrefAlloc(), Logger.DebugLevel.IN_RESULTS);
						}
						if(tokens[i].charAt(0)==student.getAllocdFifth()){
							temp = coursePool.getCourseCount(student.getAllocdFifth());
							temp++;
							coursePool.setCourseCount(student.getAllocdFifth(), temp);
							student.setAllocdFifth('-');
							student.setFifthPrefAlloc(false);
							Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdFifth()+" "+student.isFifthPrefAlloc(), Logger.DebugLevel.IN_RESULTS);
						}		
					}
				}
			}
			if ("1".equalsIgnoreCase(addDrop)) { // Course add request
				int temp7=0;
				for (Student student : studlist) {
					if (student.getStudName().equalsIgnoreCase(studName)) {
						if (coursePool.isCourseAvailable(tokens[i].charAt(0))) {
							if (student.isFirstPrefAlloc() == false || student.isSecondPrefAlloc() == false
									|| student.isThirdPrefAlloc() == false || student.isFourthPrefAlloc() == false
									|| student.isFifthPrefAlloc() == false) {
								if (student.getAllocdFirst() != tokens[i].charAt(0)
										&& student.getAllocdSecond() != tokens[i].charAt(0)
										&& student.getAllocdThird() != tokens[i].charAt(0)
										&& student.getAllocdFourth() != tokens[i].charAt(0)
										&& student.getAllocdFifth() != tokens[i].charAt(0)) {
									// since subject to be added is not present
									// in either of allocations allocation code
									if (student.isFirstPrefAlloc() == false) {
										student.setAllocdFirst(tokens[i].charAt(0));
										temp7 = coursePool.getCourseCount(tokens[i].charAt(0));
										temp7--;
										coursePool.setCourseCount(tokens[i].charAt(0), temp7);
										student.setAllocScore(student.getAllocScore() + 1);
										student.setFirstPrefAlloc(true);
										Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdFirst()+" "+student.isFirstPrefAlloc()+" "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
									}
									else if (student.isSecondPrefAlloc() == false) {
										student.setAllocdSecond(tokens[i].charAt(0));
										temp7 = coursePool.getCourseCount(tokens[i].charAt(0));
										temp7--;
										coursePool.setCourseCount(tokens[i].charAt(0), temp7);
										student.setAllocScore(student.getAllocScore() + 1);
										student.setSecondPrefAlloc(true);
										Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdSecond()+" "+student.isSecondPrefAlloc()+" "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
									}
									else if (student.isThirdPrefAlloc() == false) {
										student.setAllocdThird(tokens[i].charAt(0));
										temp7 = coursePool.getCourseCount(tokens[i].charAt(0));
										temp7--;
										coursePool.setCourseCount(tokens[i].charAt(0), temp7);
										student.setAllocScore(student.getAllocScore() + 1);
										student.setThirdPrefAlloc(true);
										Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdThird()+" "+student.isThirdPrefAlloc()+" "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
									}
									else if (student.isFourthPrefAlloc() == false) {
										student.setAllocdFourth(tokens[i].charAt(0));
										temp7 = coursePool.getCourseCount(tokens[i].charAt(0));
										temp7--;
										coursePool.setCourseCount(tokens[i].charAt(0), temp7);
										student.setAllocScore(student.getAllocScore() + 1);
										student.setFourthPrefAlloc(true);
										Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdFourth()+" "+student.isFourthPrefAlloc()+" "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
									}
									else if (student.isFifthPrefAlloc() == false) {
										student.setAllocdFifth(tokens[i].charAt(0));
										temp7 = coursePool.getCourseCount(tokens[i].charAt(0));
										temp7--;
										coursePool.setCourseCount(tokens[i].charAt(0), temp7);
										student.setAllocScore(student.getAllocScore() + 1);
										student.setFifthPrefAlloc(true);
										Logger.writeMessage("In Result updated, Studlist reference updated with: "+student.getAllocdFifth()+" "+student.isFifthPrefAlloc()+" "+ student.getAllocScore(), Logger.DebugLevel.IN_RESULTS);
									}

								}
							}

						}
					}
				}
			}
		}
//		System.out.println("");
		
//		for (Student student : studlist) {
//			System.out.println(student);
//		}

	}

}
