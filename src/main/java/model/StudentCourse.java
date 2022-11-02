package model;

public class StudentCourse 
{
	private int courseId;
	private int studentId;
	
	public StudentCourse() {}
	
	public StudentCourse(int courseId, int studentId) {
		super();
		this.courseId = courseId;
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}
