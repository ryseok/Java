package com.encore.j0508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameMenuTest2 {
   public static void main(String[] args) throws IOException {
	 //���α׷� ����, (�ݺ����� �޴�)ȭ�����
	boolean flag=true;
	BufferedReader in = new BufferedReader
			    (new InputStreamReader(System.in));
	NameMenu2 menu = new NameMenu2();
	
	do{   
	 System.out.println("<�̸��޴�2>");  
	 System.out.println("1.�߰� 2.�˻� 3.���� 4.���� 5.����");  
	 System.out.print("��ȣ�Է�==> ");
	 String no = in.readLine(); //�Է½���     
	 
	 //no ������ �˻� ====> #��ȣ�� �Է��ϼ���!!
	 //no="123"
	 
	 if(!no.matches("[0-9]+")) {
		 System.out.println("#��ȣ�� �Է��ϼ���!!");
	 }
	 
	    switch(no) {
	       case "1":
	       {
	    	       System.out.print("�̸��Է�: ");
	    	       String name=in.readLine();
	    	       
	    	        if(menu.existNameCheck(name)) {
	    	        	System.out.println("#�̹� �Էµ� �̸��Դϴ�!!");
	    	        	break;
	    	        }else if(menu.names.size() == 5) {
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





