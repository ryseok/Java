package com.encore.j0629;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class TemperatureTest {
 /*
  �̼�) ȭ�鿡 �Ʒ��� ���� ����Ͻÿ�.
  
  ���� ���ʱ� ����1��: 15�� ����� 27.0�� �Դϴ�.
 ===> ���� �ְ��� 28.0��, ������� 22.0�� �Դϴ�.
 
 http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1165051000
 
 */
	 //Java���� DOM�Ľ� �غ�
	 DocumentBuilderFactory factory;
	 DocumentBuilder builder;
	 
	 //DOM ���α׷� ����
	 Document doc;

	 public TemperatureTest() {
	    try {	 
	     factory = DocumentBuilderFactory.newInstance();
	     builder = factory.newDocumentBuilder();
	     
	     doc = builder.parse("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1165051000");
	     /*
	       <hour>6</hour>
           <day>1</day>
           <temp>23.0</temp>
           <tmx>28.0</tmx>
           <tmn>22.0</tmn>
	     */
	     
	     NodeList hourList = doc.getElementsByTagName("hour");
	                        //�ð�����(3�ð� ����: 12��, 15��, 18��)
	     NodeList dayList = doc.getElementsByTagName("day");
	                        //��¥: 0(����)  1(����)  2(��)
	     NodeList tempList = doc.getElementsByTagName("temp");//Ư���ð��� �µ�
	     NodeList maxT = doc.getElementsByTagName("tmx");//�׳��� �ְ���
	     NodeList minT = doc.getElementsByTagName("tmn");//�׳��� �������
	     
	     String searchHour = 21+"";//"15"
	     
	     for(int i=0; i<dayList.getLength(); i++) {
	    	 String dayStr = dayList.item(i).getTextContent();//"0" "1" "2"
	    	 String hourStr = hourList.item(i).getTextContent();
	    	 
	    	 if(dayStr.equals("1") && hourStr.equals(searchHour)) {//����, ����3��
	    		  //���� ���ʱ� ����1��: 15�� ����� 27.0�� �Դϴ�.
	    	  System.out.println("���� ���ʱ� ����1��: "+searchHour+
	    	     "�� ����� "+ tempList.item(i).getTextContent() +"�� �Դϴ�.");
	    		  //===> ���� �ְ��� 28.0��, ������� 22.0�� �Դϴ�.	
	    	  System.out.println("���� �ְ��� "+ maxT.item(i).getTextContent()
	    		  +"��, ������� "+minT.item(i).getTextContent()+"�� �Դϴ�.");
	    	 }
	     }
	     
	     
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	 }//������
	
	
	 public static void main(String[] args) {
		 new TemperatureTest();
	}
}
