package com.encore.j0509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersonMenuTest {
   public static void main(String[] args) throws IOException {
	  //�ݺ����� �޴� ���, ������ �Է�, �޴����� �޼ҵ� ȣ��
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));   
	PersonMenu menu = new PersonMenu();	
	boolean flag=true;//boolean: ���¸� ǥ���ϴ� �ڷ���
	int no=0;//�Էµ� Person�� �ο��� ��ȣ ǥ��
	
	do {   
     System.out.println("<�̸��޴�>");
     System.out.println("1.�߰� 2.�˻� 3.���� 4.���� 5.����");
     System.out.print("��ȣ�Է�==>");
     String num = in.readLine();//num="1" "2" "3" "4"  "5"
     
     System.out.println();
     switch(num) {
        case "1": //���Ϳ� �߰��� �̸�,����,������ �Է¹ޱ�
                 {
        	      System.out.print("�̸�: ");
        	      String name = in.readLine();//���� �Է½���
        	      
        	      System.out.print("����: ");
        	      int age = Integer.parseInt(in.readLine());
        	      
        	      System.out.print("����: ");
        	      String job = in.readLine();
        	      
        	      //menu.insert(name,age,job);
        	      //Person p = new Person(int no,String name,int age,String job)
        	       no++;
        	      Person p = new Person(no, name, age, job);
        	      //no,name,age,job 4���� ���������͸�  p������ ǥ��!!
        	      menu.insert(p);
                 }
                  break;     
                  
        case "2": menu.select();
        	      break;
        	      
        case "3": {
        	//������ �ʿ��� 3���� ������ �Է�
        	    System.out.print("������ ��ȣ: ");
		         int upNo =	Integer.parseInt(in.readLine());
		         
		         System.out.print("����: "); 
		         int age = Integer.parseInt(in.readLine());
		         
		         System.out.print("����: ");
		         String job =in.readLine();
        	      //menu.update(upNo, age, job);
		         
		         //upNo,age,job�� �Ѱ��� ������(upPerson)���� ����
		   Person upPerson = new Person(upNo, null, age, job);
		          menu.update(upPerson);
                 }
        	      break; 
        	      
        case "4": 
        	 //������ ���� �Է� ----> �ߺ����� �ʴ� ������: ��ȣ
        	     System.out.print("������ ��ȣ: ");
        	     int delNo = Integer.parseInt(in.readLine());
        	      menu.delete(delNo);
                  break;
                  
        case "5": flag=false;   
     }//switch
       System.out.println();
	}while(flag);
	
	System.out.println("-- END --");
   }//main
}







