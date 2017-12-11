package registrationScheduler.scheduler;

import java.util.List;

import registrationScheduler.util.Student;

public interface SchedulerInterface {

	public List<Student> scheduleStudents(List<Student> studentList);
	public double calcAvgAllocScore(List<Student> studentList);

}