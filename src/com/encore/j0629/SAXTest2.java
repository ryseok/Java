package com.encore.j0629;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;



public class SAXTest2 extends DefaultHandler{//implements ErrorHandler{
   //SAX: �̺�Ʈ����� �ļ�
  
   SAXParserFactory factory;
   SAXParser parser;
	
   public SAXTest2() {
	 try {  
	   factory = SAXParserFactory.newInstance();
	   factory.setValidating(true);
	   //valid(DTD�� ��������)üũ�� �ϰڴ�!!
	   
	   parser = factory.newSAXParser();
	   
	   //parser.parse("0628/books.xml", this);
	   parser.parse("0628/books3.xml", this);
	   	   
	   System.out.println("SAX�Ľ� ����!!");
	 }catch(Exception e) {
		 //e.printStackTrace();
	 }
   }//������
   
   @Override
	public void fatalError(SAXParseException e) throws SAXException {
	   //well-formed���� ����(������ ��߳�) XML���� �Ľ��� �Ͽ����� ȣ��
	   System.out.println("fatalError ---> XML������ ��߳�!!");
	   System.out.println(e.getMessage());
	}
   
   @Override
	public void error(SAXParseException e) throws SAXException {
	   //valid���� ����(DTD�Ǵ� XMLSchema�� �ٸ�) XML���� �Ľ����� �� ȣ��
	   System.out.println("error --> "
	   		+ "���������� DTD �Ǵ� XMLSchema�� ��ġ���� ����!!");
	   System.out.println(e.getMessage());
	}
      
   public static void main(String[] args) {
	  new SAXTest2();
   }

}//class end




