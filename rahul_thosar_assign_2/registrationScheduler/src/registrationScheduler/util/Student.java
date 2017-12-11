package registrationScheduler.util;

public class Student {
	String studName;
	char firstPref;
	char secondPref;
	char thirdPref;
	char fourthPref;
	char fifthPref;
	boolean isFirstPrefAlloc;
	boolean isSecondPrefAlloc;
	boolean isThirdPrefAlloc;
	boolean isFourthPrefAlloc;
	boolean isFifthPrefAlloc;
	char allocdFirst;
	char allocdSecond;
	char allocdThird;
	char allocdFourth;
	char allocdFifth;
	int allocScore;
	
	public Student(){
		Logger.writeMessage("In Student, Default constructor", Logger.DebugLevel.CONSTRUCTOR);
		this.studName="JohnWick";
		this.firstPref='-';
		this.secondPref='-';
		this.thirdPref='-';
		this.fourthPref='-';
		this.fifthPref='-';
		this.isFirstPrefAlloc = false;
		this.isSecondPrefAlloc = false;
		this.isThirdPrefAlloc = false;
		this.isFourthPrefAlloc = false;
		this.isFifthPrefAlloc = false;
		this.allocdFirst = '-';
		this.allocdSecond = '-';
		this.allocdThird = '-';
		this.allocdFourth = '-';
		this.allocdFifth = '-';
		this.allocScore = 0;
	}
	
	public synchronized char getFirstPref() {
		return firstPref;
	}
	public synchronized void setFirstPref(char firstPref) {
		this.firstPref = firstPref;
	}
	public synchronized char getSecondPref() {
		return secondPref;
	}
	public synchronized void setSecondPref(char secondPref) {
		this.secondPref = secondPref;
	}
	public synchronized char getThirdPref() {
		return thirdPref;
	}
	public synchronized void setThirdPref(char thirdPref) {
		this.thirdPref = thirdPref;
	}
	public synchronized char getFourthPref() {
		return fourthPref;
	}
	public synchronized void setFourthPref(char fourthPref) {
		this.fourthPref = fourthPref;
	}
	public synchronized String getStudName() {
		return studName;
	}
	public synchronized void setStudName(String studName) {
		this.studName = studName;
	}
		
	 public synchronized boolean isFirstPrefAlloc() {
		return isFirstPrefAlloc;
	}

	public synchronized void setFirstPrefAlloc(boolean isFirstPrefAlloc) {
		this.isFirstPrefAlloc = isFirstPrefAlloc;
	}

	public synchronized boolean isSecondPrefAlloc() {
		return isSecondPrefAlloc;
	}

	public synchronized void setSecondPrefAlloc(boolean isSecondPrefAlloc) {
		this.isSecondPrefAlloc = isSecondPrefAlloc;
	}

	public synchronized boolean isThirdPrefAlloc() {
		return isThirdPrefAlloc;
	}

	public synchronized void setThirdPrefAlloc(boolean isThirdPrefAlloc) {
		this.isThirdPrefAlloc = isThirdPrefAlloc;
	}

	public synchronized boolean isFourthPrefAlloc() {
		return isFourthPrefAlloc;
	}

	public synchronized void setFourthPrefAlloc(boolean isFourthPrefAlloc) {
		this.isFourthPrefAlloc = isFourthPrefAlloc;
	}
	

	public synchronized char getAllocdFirst() {
		return allocdFirst;
	}

	public synchronized void setAllocdFirst(char allocdFirst) {
		this.allocdFirst = allocdFirst;
	}

	public synchronized char getAllocdSecond() {
		return allocdSecond;
	}

	public synchronized void setAllocdSecond(char allocdSecond) {
		this.allocdSecond = allocdSecond;
	}

	public synchronized char getAllocdThird() {
		return allocdThird;
	}

	public synchronized void setAllocdThird(char allocdThird) {
		this.allocdThird = allocdThird;
	}

	public synchronized char getAllocdFourth() {
		return allocdFourth;
	}

	public synchronized void setAllocdFourth(char allocdFourth) {
		this.allocdFourth = allocdFourth;
	}

	public synchronized int getAllocScore() {
		return allocScore;
	}

	public synchronized void setAllocScore(int allocScore) {
		this.allocScore = allocScore;
	}

	public synchronized char getFifthPref() {
		return fifthPref;
	}

	public synchronized void setFifthPref(char fifthPref) {
		this.fifthPref = fifthPref;
	}

	public synchronized boolean isFifthPrefAlloc() {
		return isFifthPrefAlloc;
	}

	public synchronized void setFifthPrefAlloc(boolean isFifthPrefAlloc) {
		this.isFifthPrefAlloc = isFifthPrefAlloc;
	}

	public synchronized char getAllocdFifth() {
		return allocdFifth;
	}

	public synchronized void setAllocdFifth(char allocdFifth) {
		this.allocdFifth = allocdFifth;
	}

	@Override
	public String toString() {
		return "Student [" + studName + ", " + firstPref + ", " + secondPref + ", " + thirdPref + ", " + fourthPref + ", " + fifthPref
				+ ", " + isFirstPrefAlloc + ", " + isSecondPrefAlloc + ", " + isThirdPrefAlloc + ", " + isFourthPrefAlloc + ", " + isFifthPrefAlloc + ", "
				+ allocdFirst + ", " + allocdSecond + ", " + allocdThird + ", " + allocdFourth + ", " + allocdFifth + ", " + allocScore + "]";
	}

	//@Override
//	    public String toString() {
//	        return String.format("Student {%1$s\t %2$c %3$c %4$c %5$c %6$c %7$b\t %8$b\t %9$b\t %10$b\t %11$b\t %12$c %13$c %14$c %15$c %16$d}",studName,firstPref,secondPref,thirdPref,fourthPref,fifthPref,isFirstPrefAlloc,isSecondPrefAlloc,isThirdPrefAlloc,isFourthPrefAlloc,isFifthPrefAlloc,allocdFirst,allocdSecond,allocdThird,allocdFourth,allocdFifth,allocScore);
//	    }
}
