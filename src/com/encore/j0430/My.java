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
       System.out.println("�����̸�:"+ name);
    }//m4
    
    void m5(String name, int age) {
       System.out.println("m5()");
       System.out.println("�̸�:"+name+
    		             ", ����:"+age);
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
      
      //�迭��.length ===> �迭��� ����, �迭ũ��
      System.out.println("�̸� ����(names.length): "+
                          names.length);
      
      for(int i=0; i<names.length; i++) {//0~2 (�迭�� �ε���)
        System.out.println("names["+i+"]="+names[i]);
      }
      
      return;//void�� ���� ���� ����!!
    }//m7_2
    
    //��ȯ �ڷ���(��ȯ ������)�� �ִ� ���
    int m11() {
       int su1=10;
       int su2=20;
       int sum= su1 + su2;
       
       //return ����������; ===> ���� �Ұ���!!
       return sum;
    }//m11
    
    String m12() {
       return "m12�ȳ�~!!";	
    }//m12
    
    A m13(){    	
      return new A();  	
    }
    
    //int,int,int,int m14(){ ��ȯ�ڷ����� �Ѱ��� ���!!
    int[] m14(){
       int su1=11;
       int su2=22;
       int su3=33;
       int su4=44;
       
       //���� 4���� ������ ȣ���ϴ� main���� �����ϰ� �ʹ�!!
       int []su = {su1,su2,su3,su4};
       
       return su;
    }//m14
    
}//class My

class A{
   void hello() {
	   System.out.println("AŬ���� �ȳ�~!!");
   }
}




