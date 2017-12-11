package registrationScheduler.objectPool;

import registrationScheduler.util.Logger;

public class CoursePool {
	
	static CoursePool coursePoolInstance;
	
	private int courseACount;
	private int courseBCount;
	private int courseCCount;
	private int courseDCount;
	private int courseECount;
	private int courseFCount;
	private int courseGCount;
	private int courseHCount;
	private char courseA;
	private char courseB;
	private char courseC;
	private char courseD;
	private char courseE;
	private char courseF;
	private char courseG;
	private char courseH;
	
	
	public CoursePool(){
		Logger.writeMessage("In CoursePool, default constructor", Logger.DebugLevel.CONSTRUCTOR);
		this.courseACount=60;
		this.courseBCount=60;
		this.courseCCount=60;
		this.courseDCount=60;
		this.courseECount=60;
		this.courseFCount=60;
		this.courseGCount=60;
		this.courseHCount=60;
		this.courseA = 'A';
		this.courseB = 'B';
		this.courseC = 'C';
		this.courseD = 'D';
		this.courseE = 'E';
		this.courseF = 'F';
		this.courseG = 'G';
		this.courseH = 'H';
	}
	
	static synchronized public CoursePool getUniqueInstance(){
		Logger.writeMessage("In CoursePool, calling unique instance", Logger.DebugLevel.CONSTRUCTOR);
		if(coursePoolInstance == null){
			coursePoolInstance = new CoursePool();
		}
		return coursePoolInstance;
	}

	public synchronized int getCourseACount() {
		return courseACount;
	}

	public synchronized void setCourseACount(int courseACount) {
		this.courseACount = courseACount;
	}

	public synchronized int getCourseBCount() {
		return courseBCount;
	}

	public synchronized void setCourseBCount(int courseBCount) {
		this.courseBCount = courseBCount;
	}

	public synchronized int getCourseCCount() {
		return courseCCount;
	}

	public synchronized void setCourseCCount(int courseCCount) {
		this.courseCCount = courseCCount;
	}

	public synchronized int getCourseDCount() {
		return courseDCount;
	}

	public synchronized void setCourseDCount(int courseDCount) {
		this.courseDCount = courseDCount;
	}

	public synchronized int getCourseECount() {
		return courseECount;
	}

	public synchronized void setCourseECount(int courseECount) {
		this.courseECount = courseECount;
	}

	public synchronized int getCourseFCount() {
		return courseFCount;
	}

	public synchronized void setCourseFCount(int courseFCount) {
		this.courseFCount = courseFCount;
	}

	public synchronized int getCourseGCount() {
		return courseGCount;
	}

	public synchronized void setCourseGCount(int courseGCount) {
		this.courseGCount = courseGCount;
	}

	public synchronized int getCourseHCount() {
		return courseHCount;
	}

	public synchronized void setCourseHCount(int courseHCount) {
		this.courseHCount = courseHCount;
	}

	public synchronized char getCourseA() {
		return courseA;
	}

	public synchronized void setCourseA(char courseA) {
		this.courseA = courseA;
	}

	public synchronized char getCourseB() {
		return courseB;
	}

	public synchronized void setCourseB(char courseB) {
		this.courseB = courseB;
	}

	public synchronized char getCourseC() {
		return courseC;
	}

	public synchronized void setCourseC(char courseC) {
		this.courseC = courseC;
	}

	public synchronized char getCourseD() {
		return courseD;
	}

	public synchronized void setCourseD(char courseD) {
		this.courseD = courseD;
	}

	public synchronized char getCourseE() {
		return courseE;
	}

	public synchronized void setCourseE(char courseE) {
		this.courseE = courseE;
	}

	public synchronized char getCourseF() {
		return courseF;
	}

	public synchronized void setCourseF(char courseF) {
		this.courseF = courseF;
	}

	public synchronized char getCourseG() {
		return courseG;
	}

	public synchronized void setCourseG(char courseG) {
		this.courseG = courseG;
	}

	public synchronized char getCourseH() {
		return courseH;
	}

	public synchronized void setCourseH(char courseH) {
		this.courseH = courseH;
	}
	
	public synchronized boolean isCourseAvailable(char course){
		if(course == 'A'){
			if(this.courseACount == 0){
				return false;
			}
		}
		if(course == 'B'){
			if(this.courseBCount == 0){
				return false;
			}
		}
		if(course == 'C'){
			if(this.courseCCount == 0){
				return false;
			}
		}
		if(course == 'D'){
			if(this.courseDCount == 0){
				return false;
			}
		}
		if(course == 'E'){
			if(this.courseECount == 0){
				return false;
			}
		}
		if(course == 'F'){
			if(this.courseFCount == 0){
				return false;
			}
		}
		if(course == 'G'){
			if(this.courseGCount == 0){
				return false;
			}
		}
		if(course == 'H'){
			if(this.courseHCount == 0){
				return false;
			}
		}
		return true;	
	}
	
	public synchronized boolean isCourseA(){
		if(this.courseACount==0){
			return false; 
		}
		return true;
	}
	public synchronized boolean isCourseB(){
		if(this.courseBCount==0){
			return false; 
		}
		return true;
	}
	public synchronized boolean isCourseC(){
		if(this.courseCCount==0){
			return false; 
		}
		return true;
	}
	public synchronized boolean isCourseD(){
		if(this.courseDCount==0){
			return false; 
		}
		return true;
	}
	public synchronized boolean isCourseE(){
		if(this.courseECount==0){
			return false; 
		}
		return true;
	}
	public synchronized boolean isCourseF(){
		if(this.courseFCount==0){
			return false; 
		}
		return true;
	}
	public synchronized boolean isCourseG(){
		if(this.courseGCount==0){
			return false; 
		}
		return true;
	}
	public synchronized boolean isCourseH(){
		if(this.courseHCount==0){
			return false; 
		}
		return true;
	}
	
	public synchronized int getCourseCount(char inputCourse){
		switch(inputCourse){
		case 'A':
			return this.courseACount;
		case 'B':
			return this.courseBCount;
		case 'C':
			return this.courseCCount;
		case 'D':
			return this.courseDCount;
		case 'E':
			return this.courseECount;
		case 'F':
			return this.courseFCount;
		case 'G':
			return this.courseGCount;
		case 'H':
			return this.courseHCount;
		}
		return 99;
	}
	
	public synchronized void setCourseCount(char inputCourse, int count){
		switch(inputCourse){
		case 'A':
			this.courseACount = count;
			break;
		case 'B':
			this.courseBCount = count;
			break;
		case 'C':
			this.courseCCount = count;
			break;
		case 'D':
			this.courseDCount = count;
			break;
		case 'E':
			this.courseECount = count;
			break;
		case 'F':
			this.courseFCount = count;
			break;
		case 'G':
			this.courseGCount = count;
			break;
		case 'H':
			this.courseHCount = count;
			break;
		}
	}

	@Override
	public String toString() {
		return "CoursePool statsLeft [" + courseA + "=" + courseACount + ", " + courseB + "=" + courseBCount + ", " + courseC + "=" + courseCCount + ", " + courseD + "=" + courseDCount
				+ ", " + courseE + "=" + courseECount + ", " + courseF + "=" + courseFCount + ", " + courseG + "=" + courseGCount + ", " + courseH + "=" + courseHCount + "]";
	}
	
	
	
}
