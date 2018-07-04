package com.encore.j0629;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest5 {
    
	DocumentBuilderFactory factory;//공장
	DocumentBuilder builder;//일꾼
	
	//------------ DOM프로그램 시작 --------------
	Document doc;	
	
	public DOMTest5() {
        try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			//재료(XML문서)전달
			doc = builder.parse("0628/books3.xml");
			//xml문서를 구성하는 요소들 -------> 메모리할당
			
			System.out.println("DOM파싱(메모리할당) 성공~!!");
		
			//--------DOM Programming(메모리에 대한 프로그램)시작 ------
/*
    미션★: books.xml을 DOM Parsing하여 모든 책제목을 화면에 출력하시오.
     
      결과화면)
       #도서 목록
          JavaProgramming
          OracleSQL
          JavaScript
          XMLBible
 

*/
	    System.out.println("#도서목록");
	    
	    NodeList titleList= doc.getElementsByTagName("title");
	    //list [<title> <title> <title> <title>]
	    //접근      item(0) item(1) item(2) item(3)
	    for(int i=0; i<titleList.getLength(); i++) {
	    	//Node titleNode = titleList.item(i);
	    	//titleNode.getTextContent();
	    	System.out.println
	    	  (" "+titleList.item(i).getTextContent());
	    }

/*
  미션2) books.xml을 DOM Parsing하여 모든 책정보를 화면에 출력.
  
   결과화면)
    #전체 도서정보
  	 JavaProgramming(홍길동) : 28000원
     OracleSQL(길라임) : 32000원
     JavaScript(김주원) : 29000원
     XMLBible(홍길동) : 33000원
*/
       NodeList authorList = doc.getElementsByTagName("author");
	   NodeList priceList = doc.getElementsByTagName("price");
	    
	   System.out.println("===================");
	   System.out.println("#전체 도서정보");
	   for(int i=0; i<titleList.getLength(); i++) {
		  System.out.println(" "+titleList.item(i).getTextContent()+"("+
				  authorList.item(i).getTextContent()+") : "+
				  priceList.item(i).getTextContent()+"원"); 
	   }
/*
 미션3) books.xml을 DOM Parsing하여 저자 '홍길동'의 책정보를 화면에 출력하시오.
   결과화면)
     #도서 정보(저자:홍길동)
       JavaProgramming[28000원]
       XMLBible[33000원]	    
 */
	   System.out.println("===================");
	   String searchAuthor = "김주원";
	   System.out.println("#도서정보(저자:"+searchAuthor+")");
	   for(int i=0; i<titleList.getLength(); i++) {
		 String authorName = authorList.item(i).getTextContent();
		   
		 if(authorName.equals(searchAuthor)) {//저자가 홍길동  
		  System.out.println(" "+titleList.item(i).getTextContent()+"["+
				  priceList.item(i).getTextContent()+"원]");
		 }//if
	   }//for
	    
	   
	    Element t1 =doc.getElementById("t1");
	    //t1 ---> null
	    Node n = t1.getFirstChild();
	    //n: TextNode  ----> nodeValue(텍스트 값)
	    String textValue = n.getNodeValue();
	    String s1 = t1.getFirstChild().getNodeValue();
	    //만약 t1이 엘리먼트이고 text를 자식으로 가지고 있다면
	    String s2 = t1.getTextContent();
			
	    System.out.println("id='t1' 엘리먼트의 내용 >>>"+textValue);
        
        } catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        		
	}//생성자
	
	
	
	public static void main(String[] args) {
		new DOMTest5();
	}
	
}
