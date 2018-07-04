package com.encore.j0614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
	 
	 if(!no.matches("[0-9]+")) {
		 System.out.println("#��ȣ�� �Է��ϼ���!!");
	 }	 
	    switch(no) {
	       case "1"://�߰� ����
	       {
	    	       System.out.print("�̸��Է�: ");
	    	       String name=in.readLine();
	    	       
	    	        if(menu.existNameCheck(name)) {
	    	        	System.out.println("#�̹� �Էµ� �̸��Դϴ�!!");
	    	        	break;
	    	        }
	    	        
	    	        menu.insert(name);
	       }
	    	        break;
	       case "2"://�˻� ���� 
	    	        ArrayList<String> list = menu.select();
	    	        System.out.println("#�̸����");
	    	        for(int i=0; i<list.size(); i++) {//ArrayList�� �ε���
	    	           System.out.println(" "+ list.get(i));	
	    	        }
	                break;
	       case "3"://���� ����
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
	       case "4": //���� ����
	    	   System.out.print("�����̸��Է�: ");
    	       String delName = in.readLine();
    	       
	    	   if(!menu.delete(delName)) {
	    	      System.out.println("#�������� �ʴ� �̸��Դϴ�!!");
	    	   }
	    	         break;
	       case "5": //���� ���� 
	    	      flag=false;
	    }//switch
	 
	    System.out.println();
	 }while(flag);//while(do������ �ݺ��� ���ǽ�);
	
	 System.out.print("-- END --");
   }//main
}





