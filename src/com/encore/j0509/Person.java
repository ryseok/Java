package com.encore.j0509;

public class Person {// 자바빈즈: 서로 관련성있는 속성들을 저장.

	private int no;
	private String name;// null
	private int age;
	private String job;
	// ==>속성을 직접 access하지 말고 public한 게터,세터,오버로딩생성자를 통한 접근!!

	public Person() {
	}

	public Person(int no, String name, int age, String job) {
		this.no = no;
		this.name = name;
		this.age = age;
		this.job = job;
	}
	


	@Override
	public String toString() {
		return no+": ["+name+","+age+","+job+"]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
