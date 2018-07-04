package com.encore.j0629;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class SAXTest extends DefaultHandler{//implements ContentHandler{
   //SAX: 이벤트기반의 파서
  
   SAXParserFactory factory;
   SAXParser parser;
	
   public SAXTest() {
	 try {  
	   factory = SAXParserFactory.newInstance();
	   parser = factory.newSAXParser();
	   
	   //parser.parse("0629/root.xml", this);
	   parser.parse("0628/books.xml", this);
	   	   
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
   }//생성자
   
   @Override
	public void startElement(String uri, 
			                 String localName, 
			                 String qName, 
			                 Attributes attrs) throws SAXException {
	    //qName: 태그명
	    System.out.print("<"+qName);
	    
	    //속성출력
	    for(int i=0; i<attrs.getLength(); i++) {
	    	//태그내의 속성인덱스
	       String attrName = attrs.getQName(i);//속성명
	      String attrValue = attrs.getValue(i);//속성값
	    	
	      System.out.print(" "+attrName+"='"+
	                           attrValue+"'");
	    }
	    
	    System.out.print(">");
	}
   
   @Override
	public void endElement(String uri, 
			               String localName, 
			               String qName) throws SAXException {
	   System.out.print("</"+qName+">");
	}
   
   @Override
	public void characters(char[] ch, 
			               int start, 
			               int length) throws SAXException {
		//System.out.println(ch);
		//System.out.println(start);
		//System.out.println(length);
	   String str = new String(ch,start,length);
	   System.out.print(str);
	}
   
   public static void main(String[] args) {
	  new SAXTest();
   }

/*
@Override
public void setDocumentLocator(Locator locator) {
	System.out.println("setDocumentLocator");
}
@Override
public void startDocument() throws SAXException {
	System.out.println("startDocument");
}

@Override
public void endDocument() throws SAXException {
	System.out.println("endDocument");
}

@Override
public void startPrefixMapping(String prefix, String uri) throws SAXException {
	System.out.println("startPrefixMapping");
}


@Override
public void endPrefixMapping(String prefix) throws SAXException {
	System.out.println("endPrefixMapping");
}


@Override
public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
	System.out.println("startElement");
}


@Override
public void endElement(String uri, String localName, String qName) throws SAXException {
	System.out.println("endElement");
}


@Override
public void characters(char[] ch, int start, int length) throws SAXException {
	System.out.println("characters");
}


@Override
public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
	System.out.println("ignorableWhitespace");
}


@Override
public void processingInstruction(String target, String data) throws SAXException {
	System.out.println("processingInstruction");
}


@Override
public void skippedEntity(String name) throws SAXException {
	System.out.println("skippedEntity");
}*/

}//class end




