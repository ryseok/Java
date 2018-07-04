package com.encore.j0628;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DOMTest {
    
	DocumentBuilderFactory factory;//공장
	DocumentBuilder builder;//일꾼
	
	//------------  DOM표준, DOM프로그램 시작 --------------
	Document doc;	
	
	public DOMTest() {
        try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			//재료(XML문서)전달
			doc = builder.parse("0628/test.xml");
			
			System.out.println("DOM파싱 성공~!!");//text XML분석 ---> 메모리 로딩
		
			//-----------DOM Programming시작 ----------------------
			
			//문서상의 루트엘리먼트 얻어오기
			Element root = doc.getDocumentElement();
			System.out.println("루트 엘리먼트명: "+ root.getTagName());
			
			Node n = root.getFirstChild();
			//root: <person>
			
			//누구? 어떤요소?  (1~12)
			
			System.out.println("노드타입(1~12)="
			                 +n.getNodeType());//1~12
			
			System.out.println("노드이름="+ n.getNodeName());
			System.out.println("노드값="+ n.getNodeValue());
			
			
        } catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        		
	}//생성자
	
	
	
	public static void main(String[] args) {
		new DOMTest();
	}
	
}
