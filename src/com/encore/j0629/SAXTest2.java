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
   //SAX: 이벤트기반의 파서
  
   SAXParserFactory factory;
   SAXParser parser;
	
   public SAXTest2() {
	 try {  
	   factory = SAXParserFactory.newInstance();
	   factory.setValidating(true);
	   //valid(DTD와 문서내용)체크를 하겠다!!
	   
	   parser = factory.newSAXParser();
	   
	   //parser.parse("0628/books.xml", this);
	   parser.parse("0628/books3.xml", this);
	   	   
	   System.out.println("SAX파싱 성공!!");
	 }catch(Exception e) {
		 //e.printStackTrace();
	 }
   }//생성자
   
   @Override
	public void fatalError(SAXParseException e) throws SAXException {
	   //well-formed하지 못한(문법에 어긋난) XML문서 파싱을 하였을때 호출
	   System.out.println("fatalError ---> XML문법에 어긋남!!");
	   System.out.println(e.getMessage());
	}
   
   @Override
	public void error(SAXParseException e) throws SAXException {
	   //valid하지 못한(DTD또는 XMLSchema와 다른) XML문서 파싱했을 때 호출
	   System.out.println("error --> "
	   		+ "문서내용이 DTD 또는 XMLSchema와 일치하지 않음!!");
	   System.out.println(e.getMessage());
	}
      
   public static void main(String[] args) {
	  new SAXTest2();
   }

}//class end




