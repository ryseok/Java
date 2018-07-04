package com.encore.j0430;

public class My {
	
	static int su=13;
	
    static void m1() {
      System.out.println("m1()");
    }//m1
    
    void m2() {
      System.out.println("m2()");	
    }//m2
    
    void m3(int age) {
    	System.out.println("m3(): "+ age);	
    }//m3
    
    void m4(String name) {
       System.out.println("m4()");
       System.out.println("전달이름:"+ name);
    }//m4
    
    void m5(String name, int age) {
       System.out.println("m5()");
       System.out.println("이름:"+name+
    		             ", 나이:"+age);
    }
    
    void m6(A a) {
    	System.out.println("m6()");
    	a.hello();
    }
    
    void m7(String name1, String name2,
    		String name3) {
      System.out.println("m7()");
      System.out.println("name1:"+name1);
      if(true) {return;}
      System.out.println("name2:"+name2);
      System.out.println("name3:"+name3);
    }//m7
    void m7_2(String names[]) {
      System.out.println("m7_2()");
//      System.out.println("names[0]="+names[0]);
//      System.out.println("names[1]="+names[1]);
//      System.out.println("names[2]="+names[2]);
      
      //배열명.length ===> 배열요소 갯수, 배열크기
      System.out.println("이름 갯수(names.length): "+
                          names.length);
      
      for(int i=0; i<names.length; i++) {//0~2 (배열의 인덱스)
        System.out.println("names["+i+"]="+names[i]);
      }
      
      return;//void인 경우는 생략 가능!!
    }//m7_2
    
    //반환 자료형(반환 데이터)이 있는 경우
    int m11() {
       int su1=10;
       int su2=20;
       int sum= su1 + su2;
       
       //return 정수데이터; ===> 생략 불가능!!
       return sum;
    }//m11
    
    String m12() {
       return "m12안녕~!!";	
    }//m12
    
    A m13(){    	
      return new A();  	
    }
    
    //int,int,int,int m14(){ 반환자료형은 한개만 명시!!
    int[] m14(){
       int su1=11;
       int su2=22;
       int su3=33;
       int su4=44;
       
       //위의 4개의 정수를 호출하는 main에게 전달하고 싶다!!
       int []su = {su1,su2,su3,su4};
       
       return su;
    }//m14
    
}//class My

class A{
   void hello() {
	   System.out.println("A클래스 안녕~!!");
   }
}




