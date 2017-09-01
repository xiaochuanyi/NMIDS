package homework;

public class Student {
	private String studentname;
	private String studentid;
	private String age;
	private String majors;
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentId() {
		return studentid;
	}
	public void setStudentId(String studentid) {
		this.studentid = studentid;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMajors() {
		return majors;
	}
	public void setMajors(String majors) {
		this.majors = majors;
	}
	public Student(String studentname, String studentId, String age, String majors) {
		super();
		this.studentname = studentname;
		this.studentid = studentId;
		this.age = age;
		this.majors = majors;
	}

	public String toString() {
		return "Student [studentname=" + studentname + ", studentId=" + studentid + ", age=" + age + ", majors="
				+ majors + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}