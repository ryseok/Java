package com.encore.j0628;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest3 {
    
	//Java프로그램에서 DOM파싱을 위해 DocumentBuilder, 
	//DocumentBuilderFactory지원.
	DocumentBuilderFactory factory;//공장
	DocumentBuilder builder;//일꾼
	
	FileWriter out;
	
	//------------  DOM표준, DOM프로그램 시작 --------------
	Document doc;	
	
	//미션) DOMTest2(XML문서 읽어 화면출력!!)
	    //---> DOMTest3(XML문서 읽어 파일출력!!)  ---> 파일명: books2.xml
	    //추가되는 클래스 : FileWriter클래스
	
	public DOMTest3() {
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
						
			out = new FileWriter("0628/books2.xml");

			processNode(doc);//XML문서를 읽어 파일출력
			
			System.out.println("파일출력 성공!!");
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	try {
				if(out != null)out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        		
	}//생성자
	
	      
	
	public void processNode(Node n) throws IOException {//문서내의 전체노드 여행하기
		
	  switch(n.getNodeType()) {//1~12 (XML문서를 구성하는 요소를 식별하기 위한 번호)
	    //예) 1:Element, 2:Attribute, 3:Text
	    case Node.ELEMENT_NODE:{ //전달된 n이 Element라면
		   String tagName = n.getNodeName(); //태그이름 얻기
		   out.write("<"+tagName);
		   
		   NamedNodeMap map = n.getAttributes(); //속성구하기
		     //n: books였을때   map[a,b,c]
		   for(int i=0; i<map.getLength(); i++) {
			   Node attr = map.item(i);
			   String attrName = attr.getNodeName();//속성명
			   String attrValue = attr.getNodeValue(); //속성값
			   out.write(" "+attrName +"='"+ attrValue+"'" );
		   }
		   
		   out.write(">");
		   
		   NodeList list = n.getChildNodes();//자식요소들 구하기(속성은 제외!!)
		   
		   for(int i=0; i<list.getLength(); i++) {//NodeList의 인덱스 표현
			//item(0):첫번째 자식  item(1):두번째 자식요호
			Node node = list.item(i);
			processNode(node);//자식요소 구하기
		   }
		     out.write("</"+tagName+">");
	       }
		   break;
	      
	    case Node.TEXT_NODE: //case 3: 전달된 n이 Text라면
	       String content = n.getNodeValue(); //content :데이터 내용
	       out.write(content);
	       break;
	       
	    case Node.COMMENT_NODE:
	    	out.write("<!--"+n.getNodeValue()+"-->");
	       break;
	       
	    case Node.DOCUMENT_NODE:
	        out.write("<?xml version='1.0' encoding='euc-kr' ?>");	
	    	
	       NodeList list = n.getChildNodes();//루트 books, 너주석
	       for(int i=0; i<list.getLength(); i++) {
	    	   processNode(list.item(i));
	       }
	  }//switch	
		
	}//processNode
	
	
	public static void main(String[] args) {
		new DOMTest3();
	}
	
}
