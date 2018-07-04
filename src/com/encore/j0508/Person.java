package com.encore.j0508;

public class Person {// JavaBeans : 서로관련성 있는 속성들의 묶어주는 클래스
	private int no;
	private String name;// null
	private int age;
	private String job;

	public Person() {
	}

	public Person(int no, String name, int age, String job) {
		this.no = no;
		this.name = name;
		this.age = age;
		this.job = job;
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

	/*
	 * public void setName(String name) { //값을 주겠다,전달하겠다,설정하겠다!! this.name=name; }
	 * 
	 * public String getName() { //값을 가지고 오겠다, 얻어 오겠다!! return name; }
	 */
}


