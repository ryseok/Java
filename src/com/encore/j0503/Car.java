package com.encore.j0503;

public class Car {//�ڡ�
   String carName;//null
   int wheelNum;//0
   int velocity;//0
	   
   public Car(String carName, int wheelNum, int velocity) {		   
	this.carName = carName;
	this.wheelNum = wheelNum;
	this.velocity = velocity;
   }

   /*@Override
   public String toString() {//to~�޼ҵ� :��ȯ�޼ҵ�, toString(): ���ڿ���ȯ �޼ҵ�
	            //---> ��ü�� ���¸� ǥ���ϴ� �޼ҵ� (�ʵ��� ���� ���������� ǥ��)
	 String str = "�� ���� "+ this.carName+"�̰� �������� "+  wheelNum+
			      ", �ӵ��� "+ velocity+"�Դϴ�!!";
	 return str;
   }//toString
*/	
  
   public boolean equals(Car c) {//��ü���� ��
	  /*
	    �ڡ� ���ڿ� ���� ��!!
	    String s1="java";   String s2=new String("JAVA");
	    
	    s1 == s2  : �޸𸮺�
        s1.equals(s2)  : ���� ��!!	    
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
     Car c1 = new Car("�ҳ�Ÿ", 4, 100);
	 Car c2 = new Car("�ҳ�Ÿ", 4, 100);
	 
	 System.out.println(c1.toString());
	 System.out.println(c1); //-----> c1�� ����ϴ� ��� ���������� toString()�޼ҵ带 ȣ��!!
	 System.out.println(c2);
	 
	 //System.out.println(c2.toString());
     //c1,c2���� ---> ����(reference)����
	 //��c1�� c2�� ��??
	 
	 if(c1 == c2) {//���۷��� ��!!
		System.out.println("��ü(�޸�)�ּҰ���!!"); 
	 }else {
		 System.out.println("��ü(�޸�)�ּҴٸ�!!");		 
	 }
	 
	 //��ü���� ��!!----> Ŭ������ �����ϴ� �ʵ尪�� ���� ��
	 if(c1.equals(c2)) {
		 System.out.println("��ü���� ����!!");
	 }else {
		 System.out.println("��ü���� �ٸ�!!");
	 }
	   
   }//main
}



