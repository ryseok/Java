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
    
	DocumentBuilderFactory factory;//����
	DocumentBuilder builder;//�ϲ�
	
	//------------ DOM���α׷� ���� --------------
	Document doc;	
	
	public DOMTest5() {
        try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			//���(XML����)����
			doc = builder.parse("0628/books3.xml");
			//xml������ �����ϴ� ��ҵ� -------> �޸��Ҵ�
			
			System.out.println("DOM�Ľ�(�޸��Ҵ�) ����~!!");
		
			//--------DOM Programming(�޸𸮿� ���� ���α׷�)���� ------
/*
    �̼ǡ�: books.xml�� DOM Parsing�Ͽ� ��� å������ ȭ�鿡 ����Ͻÿ�.
     
      ���ȭ��)
       #���� ���
          JavaProgramming
          OracleSQL
          JavaScript
          XMLBible
 

*/
	    System.out.println("#�������");
	    
	    NodeList titleList= doc.getElementsByTagName("title");
	    //list [<title> <title> <title> <title>]
	    //����      item(0) item(1) item(2) item(3)
	    for(int i=0; i<titleList.getLength(); i++) {
	    	//Node titleNode = titleList.item(i);
	    	//titleNode.getTextContent();
	    	System.out.println
	    	  (" "+titleList.item(i).getTextContent());
	    }

/*
  �̼�2) books.xml�� DOM Parsing�Ͽ� ��� å������ ȭ�鿡 ���.
  
   ���ȭ��)
    #��ü ��������
  	 JavaProgramming(ȫ�浿) : 28000��
     OracleSQL(�����) : 32000��
     JavaScript(���ֿ�) : 29000��
     XMLBible(ȫ�浿) : 33000��
*/
       NodeList authorList = doc.getElementsByTagName("author");
	   NodeList priceList = doc.getElementsByTagName("price");
	    
	   System.out.println("===================");
	   System.out.println("#��ü ��������");
	   for(int i=0; i<titleList.getLength(); i++) {
		  System.out.println(" "+titleList.item(i).getTextContent()+"("+
				  authorList.item(i).getTextContent()+") : "+
				  priceList.item(i).getTextContent()+"��"); 
	   }
/*
 �̼�3) books.xml�� DOM Parsing�Ͽ� ���� 'ȫ�浿'�� å������ ȭ�鿡 ����Ͻÿ�.
   ���ȭ��)
     #���� ����(����:ȫ�浿)
       JavaProgramming[28000��]
       XMLBible[33000��]	    
 */
	   System.out.println("===================");
	   String searchAuthor = "���ֿ�";
	   System.out.println("#��������(����:"+searchAuthor+")");
	   for(int i=0; i<titleList.getLength(); i++) {
		 String authorName = authorList.item(i).getTextContent();
		   
		 if(authorName.equals(searchAuthor)) {//���ڰ� ȫ�浿  
		  System.out.println(" "+titleList.item(i).getTextContent()+"["+
				  priceList.item(i).getTextContent()+"��]");
		 }//if
	   }//for
	    
	   
	    Element t1 =doc.getElementById("t1");
	    //t1 ---> null
	    Node n = t1.getFirstChild();
	    //n: TextNode  ----> nodeValue(�ؽ�Ʈ ��)
	    String textValue = n.getNodeValue();
	    String s1 = t1.getFirstChild().getNodeValue();
	    //���� t1�� ������Ʈ�̰� text�� �ڽ����� ������ �ִٸ�
	    String s2 = t1.getTextContent();
			
	    System.out.println("id='t1' ������Ʈ�� ���� >>>"+textValue);
        
        } catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        		
	}//������
	
	
	
	public static void main(String[] args) {
		new DOMTest5();
	}
	
}
