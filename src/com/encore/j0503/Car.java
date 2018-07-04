package com.encore.j0503;

public class Car {//★★
   String carName;//null
   int wheelNum;//0
   int velocity;//0
	   
   public Car(String carName, int wheelNum, int velocity) {		   
	this.carName = carName;
	this.wheelNum = wheelNum;
	this.velocity = velocity;
   }

   /*@Override
   public String toString() {//to~메소드 :변환메소드, toString(): 문자열변환 메소드
	            //---> 객체의 상태를 표현하는 메소드 (필드의 값이 무엇인지를 표현)
	 String str = "이 차는 "+ this.carName+"이고 바퀴수는 "+  wheelNum+
			      ", 속도는 "+ velocity+"입니다!!";
	 return str;
   }//toString
*/	
  
   public boolean equals(Car c) {//객체내용 비교
	  /*
	    ★★ 문자열 내용 비교!!
	    String s1="java";   String s2=new String("JAVA");
	    
	    s1 == s2  : 메모리비교
        s1.equals(s2)  : 값의 비교!!	    
	   */
	   
	   
	  if(carName.equals(c.carName) &&
         wheelNum == c.wheelNum &&
         velocity == c.velocity)
	    return true;
	  else
		return false;
   }//equals
	
   @Override
   public String toString() {
	return "Car [carName=" + carName + ", wheelNum=" + wheelNum +
			", velocity=" + velocity + "]";
   }

public static void main(String[] args) {
     Car c1 = new Car("소나타", 4, 100);
	 Car c2 = new Car("소나타", 4, 100);
	 
	 System.out.println(c1.toString());
	 System.out.println(c1); //-----> c1을 출력하는 경우 내부적으로 toString()메소드를 호출!!
	 System.out.println(c2);
	 
	 //System.out.println(c2.toString());
     //c1,c2변수 ---> 참조(reference)변수
	 //★c1과 c2를 비교??
	 
	 if(c1 == c2) {//레퍼런스 비교!!
		System.out.println("객체(메모리)주소같음!!"); 
	 }else {
		 System.out.println("객체(메모리)주소다름!!");		 
	 }
	 
	 //객체내용 비교!!----> 클래스를 구성하는 필드값을 각각 비교
	 if(c1.equals(c2)) {
		 System.out.println("객체내용 같음!!");
	 }else {
		 System.out.println("객체내용 다름!!");
	 }
	   
   }//main
}



