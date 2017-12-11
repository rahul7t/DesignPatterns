package registrationScheduler.util;

import registrationScheduler.util.Logger.DebugLevel;

public class CourseCounter {
	int courseACount;
	int courseBCount;
	int courseCCount;
	int courseDCount;
	int courseECount;
	int courseFCount;
	int courseGCount;
	int courseHCount;
	char courseA;
	char courseB;
	char courseC;
	char courseD;
	char courseE;
	char courseF;
	char courseG;
	char courseH;
	
	
	public CourseCounter(){
		this.courseACount=20;
		this.courseBCount=20;
		this.courseCCount=20;
		this.courseDCount=20;
		this.courseECount=20;
		this.courseFCount=20;
		this.courseGCount=20;
		this.courseHCount=20;
		this.courseA = 'A';
		this.courseB = 'B';
		this.courseC = 'C';
		this.courseD = 'D';
		this.courseE = 'E';
		this.courseF = 'F';
		this.courseG = 'G';
		this.courseH = 'H';
		Logger.writeMessage("CourseCounter constructor method invoked",DebugLevel.CONSTRUCTOR);
	}

	static public CourseCounter getUniqueInstance(){
		if(objInst == null){
			objInst = new CourseCounter();
		}
		return objInst;
	}
	public int getCourseACount() {
		return courseACount;
	}

	public void setCourseACount(int courseACount) {
		this.courseACount = courseACount;
	}

	public int getCourseBCount() {
		return courseBCount;
	}

	public void setCourseBCount(int courseBCount) {
		this.courseBCount = courseBCount;
	}

	public int getCourseCCount() {
		return courseCCount;
	}

	public void setCourseCCount(int courseCCount) {
		this.courseCCount = courseCCount;
	}

	public int getCourseDCount() {
		return courseDCount;
	}

	public void setCourseDCount(int courseDCount) {
		this.courseDCount = courseDCount;
	}

	public int getCourseECount() {
		return courseECount;
	}

	public void setCourseECount(int courseECount) {
		this.courseECount = courseECount;
	}

	public int getCourseFCount() {
		return courseFCount;
	}

	public void setCourseFCount(int courseFCount) {
		this.courseFCount = courseFCount;
	}

	public int getCourseGCount() {
		return courseGCount;
	}

	public void setCourseGCount(int courseGCount) {
		this.courseGCount = courseGCount;
	}

	public int getCourseHCount() {
		return courseHCount;
	}

	public void setCourseHCount(int courseHCount) {
		this.courseHCount = courseHCount;
	}
	
	public char getCourseA() {
		return courseA;
	}

	public void setCourseA(char courseA) {
		this.courseA = courseA;
	}

	public char getCourseB() {
		return courseB;
	}

	public void setCourseB(char courseB) {
		this.courseB = courseB;
	}

	public char getCourseC() {
		return courseC;
	}

	public void setCourseC(char courseC) {
		this.courseC = courseC;
	}

	public char getCourseD() {
		return courseD;
	}

	public void setCourseD(char courseD) {
		this.courseD = courseD;
	}

	public char getCourseE() {
		return courseE;
	}

	public void setCourseE(char courseE) {
		this.courseE = courseE;
	}

	public char getCourseF() {
		return courseF;
	}

	public void setCourseF(char courseF) {
		this.courseF = courseF;
	}

	public char getCourseG() {
		return courseG;
	}

	public void setCourseG(char courseG) {
		this.courseG = courseG;
	}

	public char getCourseH() {
		return courseH;
	}

	public void setCourseH(char courseH) {
		this.courseH = courseH;
	}

	public boolean isCourseA(){
		if(this.courseACount==0){
			return false; 
		}
		return true;
	}
	public boolean isCourseB(){
		if(this.courseBCount==0){
			return false; 
		}
		return true;
	}
	public boolean isCourseC(){
		if(this.courseCCount==0){
			return false; 
		}
		return true;
	}
	public boolean isCourseD(){
		if(this.courseDCount==0){
			return false; 
		}
		return true;
	}
	public boolean isCourseE(){
		if(this.courseECount==0){
			return false; 
		}
		return true;
	}
	public boolean isCourseF(){
		if(this.courseFCount==0){
			return false; 
		}
		return true;
	}
	public boolean isCourseG(){
		if(this.courseGCount==0){
			return false; 
		}
		return true;
	}
	public boolean isCourseH(){
		if(this.courseHCount==0){
			return false; 
		}
		return true;
	}
	
	@Override
    public String toString() {
        return String.format("CourseCounter { %1$s=%2$02d %3$s=%4$02d %5$s=%6$02d %7$s=%8$02d %9$s=%10$02d %11$s=%12$02d %13$s=%14$02d %15$s=%16$02d}",courseA,courseACount,courseB,courseBCount,courseC,courseCCount,courseD,courseDCount,courseE,courseECount,courseF,courseFCount,courseG,courseGCount,courseH,courseHCount);
    }
	
	public int getCourseCount(char inputCourse){
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
	
	public void setCourseCount(char inputCourse, int count){
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
	
	public boolean isCourse(char course){
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
}
