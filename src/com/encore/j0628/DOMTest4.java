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
    
	DocumentBuilderFactory factory;//����
	DocumentBuilder builder;//�ϲ�
	
	//------------  DOMǥ��, DOM���α׷� ���� --------------
	Document doc;	
	
	public DOMTest4() {
        try {
			factory = DocumentBuilderFactory.newInstance();
			
			factory.setIgnoringElementContentWhitespace(true);//���鹫�� ����
			
			builder = factory.newDocumentBuilder();
			
			//���(XML����)����
			doc = builder.parse("0628/books3.xml");
			
			System.out.println("DOM�Ľ� ����~!!");//text XML�м� ---> �޸� �ε�
		
			//-----------DOM Programming���� ----------------------
			
			/*
�̼�) books.xml�� DOM Parsing�Ͽ� ù��° book�� title�� ȭ�鿡 ����Ͻÿ�.
     ===> ���ȭ��: JavaProgramming
     
     ===> ��, �θ�              �ڽ�           ����               ���踦 ���� ������ �ذ��Ͻÿ�.
             parent    child    sibling
             
  doc----> books -----> book ----> title ---> TextNode("JavaProgramming")            
			*/
	   Element root = doc.getDocumentElement();//root: books
	   System.out.println("��Ʈ ������Ʈ��: "+ root.getTagName());
		
	   //ù��°<book>�� å������ ���
	   
	   String title = root.getFirstChild()  // <book>
	                      .getFirstChild()  // <title>
	                      .getFirstChild()  // TextNode
	                      .getNodeValue();  // �ؽ�Ʈ ��
      
	   /*
	   String title = root.getFirstChild()  //����
			              .getNextSibling()  //<book>
			              .getFirstChild()  //����
			              .getNextSibling()  //<title>
			              .getFirstChild()  // TextNode
			              .getNodeValue();  //�ؽ�Ʈ ��
       */	   
	   System.out.println("å����="+ title);
	   
        } catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        		
	}//������
	
	
	
	public static void main(String[] args) {
		new DOMTest4();
	}
	
}
