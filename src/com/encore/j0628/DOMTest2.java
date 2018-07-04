package com.encore.j0628;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest2 {
    
	//Java프로그램에서 DOM파싱을 위해 DocumentBuilder, 
	//DocumentBuilderFactory지원.
	DocumentBuilderFactory factory;//공장
	DocumentBuilder builder;//일꾼
	
	//------------  DOM표준, DOM프로그램 시작 --------------
	Document doc;	
	
	public DOMTest2() {
        try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			//재료(XML문서)전달
			doc = builder.parse("0628/books.xml");
			//문서를 구성하는 요소에 대해 트리형태의 메모리할당.
			
			System.out.println("DOM파싱 성공~!!");
		
			//-----------DOM Programming시작 (메모리 사용)------------------
			//미션: 전체 문서(books.xml) 여행하기!! (문서내용 ---> 화면 콘솔에 출력)
			
			//문서상의 루트엘리먼트 얻어오기
			Element root = doc.getDocumentElement();
						
			//processNode(root);//루트엘리먼트를 시작점으로 하는 문서 여행하기
			processNode(doc);//Document를 시작점으로 하는 문서 여행하기
			
        } catch (Exception e) {
        	e.printStackTrace();
        }
        		
	}//생성자
	
	        //n(books)  list: [<book>,<book>,<book>,<book>]
			//n(book)   list: [<title>,<author>,<price>]
			//n(title)  list: ["JavaProgramming"]
			//n(텍스트)  list: []
			
			//n(author)  list: ["홍길동"]
			//n(텍스트)  list: []
			
			//n(price)  list: ["23000"]
			//n(텍스트)  list: []	
	
	public void processNode(Node n) {//문서내의 전체노드 여행하기
		
	  switch(n.getNodeType()) {//1~12 (XML문서를 구성하는 요소를 식별하기 위한 번호)
	    //예) 1:Element, 2:Attribute, 3:Text
	    case Node.ELEMENT_NODE:{ //전달된 n이 Element라면
		   String tagName = n.getNodeName(); //태그이름 얻기
		   System.out.print("<"+tagName);
		   
		   NamedNodeMap map = n.getAttributes(); //속성구하기
		     //n: books였을때   map[a,b,c]
		   for(int i=0; i<map.getLength(); i++) {
			   Node attr = map.item(i);
			   String attrName = attr.getNodeName();//속성명
			   String attrValue = attr.getNodeValue(); //속성값
			   System.out.print(" "+attrName +"='"+ attrValue+"'" );
		   }
		   
		   System.out.print(">");
		   
		   NodeList list = n.getChildNodes();//자식요소들 구하기(속성은 제외!!)
		   
		   for(int i=0; i<list.getLength(); i++) {//NodeList의 인덱스 표현
			//item(0):첫번째 자식  item(1):두번째 자식요호
			Node node = list.item(i);
			processNode(node);//자식요소 구하기
		   }
		   System.out.print("</"+tagName+">");
	       }
		   break;
	      
	    case Node.TEXT_NODE: //case 3: 전달된 n이 Text라면
	       String content = n.getNodeValue(); //content :데이터 내용
	       System.out.print(content);
	       break;
	       
	    case Node.COMMENT_NODE:
	       System.out.print("<!--"+n.getNodeValue()+"-->");
	       break;
	       
	    case Node.DOCUMENT_NODE:
	       NodeList list = n.getChildNodes();//루트 books, 너주석
	       for(int i=0; i<list.getLength(); i++) {
	    	   processNode(list.item(i));
	       }
	  }//switch	
		
	}//processNode
	
	
	public static void main(String[] args) {
		new DOMTest2();
	}
	
}
