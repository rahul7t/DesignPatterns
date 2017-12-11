package registrationScheduler.util;

import registrationScheduler.util.Logger.DebugLevel;

public class Student {
	int regTime;
	char firstPref;
	char secondPref;
	char thirdPref;
	char fourthPref;
	String studName;
	boolean isFirstPrefAlloc;
	boolean isSecondPrefAlloc;
	boolean isThirdPrefAlloc;
	boolean isFourthPrefAlloc;
	char allocdFirst;
	char allocdSecond;
	char allocdThird;
	char allocdFourth;
	int allocScore;
	
	public Student(){
		this.studName="JohnWick";
		this.regTime=0;
		this.firstPref='-';
		this.secondPref='-';
		this.thirdPref='-';
		this.fourthPref='-';
		this.isFirstPrefAlloc = false;
		this.isSecondPrefAlloc = false;
		this.isThirdPrefAlloc = false;
		this.isFourthPrefAlloc = false;
		this.allocdFirst = '-';
		this.allocdSecond = '-';
		this.allocdThird = '-';
		this.allocdFourth = '-';	
		this.allocScore = 0;
		Logger.writeMessage("Student constructor method invoked",DebugLevel.CONSTRUCTOR);
	}
	
	public int getRegTime() {
		return regTime;
	}
	public void setRegTime(int regTime) {
		this.regTime = regTime;
	}
	public char getFirstPref() {
		return firstPref;
	}
	public void setFirstPref(char firstPref) {
		this.firstPref = firstPref;
	}
	public char getSecondPref() {
		return secondPref;
	}
	public void setSecondPref(char secondPref) {
		this.secondPref = secondPref;
	}
	public char getThirdPref() {
		return thirdPref;
	}
	public void setThirdPref(char thirdPref) {
		this.thirdPref = thirdPref;
	}
	public char getFourthPref() {
		return fourthPref;
	}
	public void setFourthPref(char fourthPref) {
		this.fourthPref = fourthPref;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
		
	 public boolean isFirstPrefAlloc() {
		return isFirstPrefAlloc;
	}

	public void setFirstPrefAlloc(boolean isFirstPrefAlloc) {
		this.isFirstPrefAlloc = isFirstPrefAlloc;
	}

	public boolean isSecondPrefAlloc() {
		return isSecondPrefAlloc;
	}

	public void setSecondPrefAlloc(boolean isSecondPrefAlloc) {
		this.isSecondPrefAlloc = isSecondPrefAlloc;
	}

	public boolean isThirdPrefAlloc() {
		return isThirdPrefAlloc;
	}

	public void setThirdPrefAlloc(boolean isThirdPrefAlloc) {
		this.isThirdPrefAlloc = isThirdPrefAlloc;
	}

	public boolean isFourthPrefAlloc() {
		return isFourthPrefAlloc;
	}

	public void setFourthPrefAlloc(boolean isFourthPrefAlloc) {
		this.isFourthPrefAlloc = isFourthPrefAlloc;
	}
	

	public char getAllocdFirst() {
		return allocdFirst;
	}

	public void setAllocdFirst(char allocdFirst) {
		this.allocdFirst = allocdFirst;
	}

	public char getAllocdSecond() {
		return allocdSecond;
	}

	public void setAllocdSecond(char allocdSecond) {
		this.allocdSecond = allocdSecond;
	}

	public char getAllocdThird() {
		return allocdThird;
	}

	public void setAllocdThird(char allocdThird) {
		this.allocdThird = allocdThird;
	}

	public char getAllocdFourth() {
		return allocdFourth;
	}

	public void setAllocdFourth(char allocdFourth) {
		this.allocdFourth = allocdFourth;
	}

	public int getAllocScore() {
		return allocScore;
	}

	public void setAllocScore(int allocScore) {
		this.allocScore = allocScore;
	}

	@Override
	    public String toString() {
	        return String.format("Student {%1$s\t %2$02d %3$c %4$c %5$c %6$c %7$b\t %8$b\t %9$b\t %10$b\t %11$c %12$c %13$c %14$c %15$d}",studName,regTime,firstPref,secondPref,thirdPref,fourthPref,isFirstPrefAlloc,isSecondPrefAlloc,isThirdPrefAlloc,isFourthPrefAlloc,allocdFirst,allocdSecond,allocdThird,allocdFourth,allocScore);
	    }
}
