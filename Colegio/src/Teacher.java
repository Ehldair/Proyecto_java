
public class Teacher extends Person {
	int numCourses=0;
	String[] courses= {};
	
	
	public Teacher(String name, String address) {
		super(name,address);
	}
	public boolean addCourse(String course) {
		
	}
	public boolean removeCourse(String course) {
		
	}
	public String toString() {
		return "Teacher: "+name+"("+ address+")";
	}
}
