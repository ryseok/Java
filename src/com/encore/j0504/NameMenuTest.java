package com.encore.j0504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameMenuTest {
   public static void main(String[] args) throws IOException {
	 //���α׷� ����, (�ݺ����� �޴�)ȭ�����
	boolean flag=true;
	BufferedReader in = new BufferedReader
			    (new InputStreamReader(System.in));
	NameMenu menu = new NameMenu();
	
	do{   
	 System.out.println("<�̸��޴�>");  
	 System.out.println("1.�߰� 2.�˻� 3.���� 4.���� 5.����");  
	 System.out.print("��ȣ�Է�==> ");
	 String no = in.readLine(); //�Է½���     
	 
	 //no ������ �˻� ====> #��ȣ�� �Է��ϼ���!!
	 //no="123"
	 
	 if(!no.matches("[0-9]+")) {
		 System.out.println("#��ȣ�� �Է��ϼ���!!");
	 }
	 /*for(int i=0; i<no.length(); i++) {//no���ڿ��� �ε��� ǥ��
		 char ch = no.charAt(i);
		 //���ڿ� ���� ���ڹ��� �˻�  '0'~'9'
		  //����: ch>='0' && ch<='9'  ���ھƴѰ�: ch<'0' || ch>'9'
		 if(ch<'0' || ch>'9') {//0~9 �ƴ� ���� �߽߰�	
			 System.out.println("#��ȣ�� �Է��ϼ���!!");
	         break;
		 }
	 }*/
	 
	 
	 
	 
	 //no="1" "2" "3" "4" "5"
	 //int no = Integer.parseInt(in.readLine());  
	 //if(no.equals("1")){insert();}else if(no.equals("2")){select();}   
	    switch(no) {
	       case "1":
	       {
	    	       System.out.print("�̸��Է�: ");
	    	       String name=in.readLine();
	    	       
	    	        if(menu.existNameCheck(name)) {
	    	        	System.out.println("#�̹� �Էµ� �̸��Դϴ�!!");
	    	        	break;
	    	        }else if(menu.cnt == 5) {
	    	        	System.out.println("#�� �̻� �Է��� �� �����ϴ�\r\n" + 
	    	        			"  �� �� �̻��� �̸��� ���� ������ �� �Է��ϼ���!!");
	    	        	break;
	    	        }
	    	       
	    	        
	    	        menu.insert(name);
	       }
	    	        break;
	       case "2": menu.select();
	                break;
	       case "3":
	    	   System.out.print("�����̸��Է�: ");
	    	   String oldName = in.readLine();//�Է½���
	    	   System.out.print("�����̸��Է�: ");
	    	   String newName = in.readLine();
	    	   
	    	   if(menu.existNameCheck(oldName)) {//oldName�� �����Ѵٸ�
	    		   menu.update(oldName,newName);
	    	   }else {
	    		   System.out.println("#�������� �ʴ� �̸��Դϴ�!!");
	    	   }    
	                break;
	       case "4": 
	    	   System.out.print("�����̸��Է�: ");
    	       String delName = in.readLine();
    	       if(!menu.existNameCheck(delName)) {//delName�� �������� �ʴ´ٸ�
    	    	   System.out.println("#�������� �ʴ� �̸��Դϴ�!!");
    	    	   break;
    	       }
	    	         menu.delete(delName);	       
	    	         break;
	       case "5": flag=false;
	    }//switch
	 
	    System.out.println();
	 }while(flag);//while(do������ �ݺ��� ���ǽ�);
	
	 System.out.print("-- END --");
   }//main
}





