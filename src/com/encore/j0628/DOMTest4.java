package com.encore.j0628;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DOMTest4 {
    
	DocumentBuilderFactory factory;//공장
	DocumentBuilder builder;//일꾼
	
	//------------  DOM표준, DOM프로그램 시작 --------------
	Document doc;	
	
	public DOMTest4() {
        try {
			factory = DocumentBuilderFactory.newInstance();
			
			factory.setIgnoringElementContentWhitespace(true);//공백무시 설정
			
			builder = factory.newDocumentBuilder();
			
			//재료(XML문서)전달
			doc = builder.parse("0628/books3.xml");
			
			System.out.println("DOM파싱 성공~!!");//text XML분석 ---> 메모리 로딩
		
			//-----------DOM Programming시작 ----------------------
			
			/*
미션) books.xml을 DOM Parsing하여 첫번째 book의 title을 화면에 출력하시오.
     ===> 결과화면: JavaProgramming
     
     ===> 단, 부모              자식           형제               관계를 통해 문제를 해결하시오.
             parent    child    sibling
             
  doc----> books -----> book ----> title ---> TextNode("JavaProgramming")            
			*/
	   Element root = doc.getDocumentElement();//root: books
	   System.out.println("루트 엘리먼트명: "+ root.getTagName());
		
	   //첫번째<book>의 책제목을 출력
	   
	   String title = root.getFirstChild()  // <book>
	                      .getFirstChild()  // <title>
	                      .getFirstChild()  // TextNode
	                      .getNodeValue();  // 텍스트 값
      
	   /*
	   String title = root.getFirstChild()  //공백
			              .getNextSibling()  //<book>
			              .getFirstChild()  //공백
			              .getNextSibling()  //<title>
			              .getFirstChild()  // TextNode
			              .getNodeValue();  //텍스트 값
       */	   
	   System.out.println("책제목="+ title);
	   
        } catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        		
	}//생성자
	
	
	
	public static void main(String[] args) {
		new DOMTest4();
	}
	
}
