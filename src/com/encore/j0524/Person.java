package com.encore.j0524;

import java.io.Serializable;

public class Person implements Serializable{//객체직렬화 가능 클래스!!
   String name="우리길동";
   transient int age=13;//transient: 데이터 값을 전달 하지 않을 변수
   String job="학생";
}
