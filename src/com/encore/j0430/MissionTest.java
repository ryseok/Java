package com.encore.j0430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissionTest {
   public static void main(String[] args) throws IOException {
	   //System.in.read(); ----> ����Ű ó��
	   //br.readLine();  ----> ��ü������ ����
	  
	boolean flag=true;   
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int su=0;
	
    do{   
		 System.out.println("<<�޴�>>");
		 System.out.println("1.�˻� 2.���� 3.���� 4.����"); 
		 System.out.print("��ȣ==> ");
		 String no = br.readLine();
		 
		 switch(no) { //(����) {//���ĵ�����: ����,����, ���ڿ�
		   //���� char no; ----> case '1':   , case '2':
		   //���� int no;  ----> case 1:     , case 2:
		   //���� String no;  ----> case "1":     , case "2":        
		 
		    case "1": //���� �Ǵ� ���ҵ� ������ ���� �� 
		    	System.out.println("#�˻����:"+ su);
		    	      break;
		    case "2": //���� 1����
		    	      su++;
		    	      System.out.println("#1�����Ͽ����ϴ�.");
		    	      break;
		    case "3": //���� 1����
		    	      su--;
		    	      System.out.println("#1�����Ͽ����ϴ�.");
		    	      break;
		    case "4": flag=false;
		 }//switch
		 
		 System.out.println();
	 }while(flag);//(���ǽ�);
    
    System.out.println("-- END --");
	 
   }//main
}


