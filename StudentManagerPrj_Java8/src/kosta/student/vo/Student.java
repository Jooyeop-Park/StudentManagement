package kosta.student.vo;

public class Student {
	private int num;
	private String name;
	private String address;
	private String gender;
	private String clss;
	private double height;
	private int age;
	private int score;
	private int year;
	
	public Student(int num, String name, String address, String gender, String clss, double height, int age, int score,
			int year) {
		super();
		this.num = num;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.clss = clss;
		this.height = height;
		this.age = age;
		this.score = score;
		this.year = year;
	}
	
	//학점 변환
	public String getGrade(){
		return "";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getClss() {
		return clss;
	}
	public void setClss(String clss) {
		this.clss = clss;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", address=" + address + ", gender=" + gender + ", clss="
				+ clss + ", height=" + height + ", age=" + age + ", score=" + score + ", year=" + year + "]";
	}
	
} // end of class


