package registrationScheduler.store;

import java.util.List;

import registrationScheduler.util.Student;

public interface FileDisplayInterface {
	public void writeResultsToFile(List<Student> studentList);
}
