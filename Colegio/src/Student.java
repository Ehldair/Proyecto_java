
public class Student extends Person {
	int numCourses=0;
	String[] courses= {};
	int[] grade= {};
	
	
	public Student(String name,String address) {
		super(name,address);
	}
	public void addCoursesGrade(String course, int grade) {
		
	}
	
	public void printGrades() {
		
	}
	public double getAverageGrade() {
		double d=0;
		return d;
	}
	public String toString() {
		return "Student: "+name+"("+address+")";
	}
}
