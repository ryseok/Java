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
    
	//Java���α׷����� DOM�Ľ��� ���� DocumentBuilder, 
	//DocumentBuilderFactory����.
	DocumentBuilderFactory factory;//����
	DocumentBuilder builder;//�ϲ�
	
	//------------  DOMǥ��, DOM���α׷� ���� --------------
	Document doc;	
	
	public DOMTest2() {
        try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			//���(XML����)����
			doc = builder.parse("0628/books.xml");
			//������ �����ϴ� ��ҿ� ���� Ʈ�������� �޸��Ҵ�.
			
			System.out.println("DOM�Ľ� ����~!!");
		
			//-----------DOM Programming���� (�޸� ���)------------------
			//�̼�: ��ü ����(books.xml) �����ϱ�!! (�������� ---> ȭ�� �ֿܼ� ���)
			
			//�������� ��Ʈ������Ʈ ������
			Element root = doc.getDocumentElement();
						
			//processNode(root);//��Ʈ������Ʈ�� ���������� �ϴ� ���� �����ϱ�
			processNode(doc);//Document�� ���������� �ϴ� ���� �����ϱ�
			
        } catch (Exception e) {
        	e.printStackTrace();
        }
        		
	}//������
	
	        //n(books)  list: [<book>,<book>,<book>,<book>]
			//n(book)   list: [<title>,<author>,<price>]
			//n(title)  list: ["JavaProgramming"]
			//n(�ؽ�Ʈ)  list: []
			
			//n(author)  list: ["ȫ�浿"]
			//n(�ؽ�Ʈ)  list: []
			
			//n(price)  list: ["23000"]
			//n(�ؽ�Ʈ)  list: []	
	
	public void processNode(Node n) {//�������� ��ü��� �����ϱ�
		
	  switch(n.getNodeType()) {//1~12 (XML������ �����ϴ� ��Ҹ� �ĺ��ϱ� ���� ��ȣ)
	    //��) 1:Element, 2:Attribute, 3:Text
	    case Node.ELEMENT_NODE:{ //���޵� n�� Element���
		   String tagName = n.getNodeName(); //�±��̸� ���
		   System.out.print("<"+tagName);
		   
		   NamedNodeMap map = n.getAttributes(); //�Ӽ����ϱ�
		     //n: books������   map[a,b,c]
		   for(int i=0; i<map.getLength(); i++) {
			   Node attr = map.item(i);
			   String attrName = attr.getNodeName();//�Ӽ���
			   String attrValue = attr.getNodeValue(); //�Ӽ���
			   System.out.print(" "+attrName +"='"+ attrValue+"'" );
		   }
		   
		   System.out.print(">");
		   
		   NodeList list = n.getChildNodes();//�ڽĿ�ҵ� ���ϱ�(�Ӽ��� ����!!)
		   
		   for(int i=0; i<list.getLength(); i++) {//NodeList�� �ε��� ǥ��
			//item(0):ù��° �ڽ�  item(1):�ι�° �ڽĿ�ȣ
			Node node = list.item(i);
			processNode(node);//�ڽĿ�� ���ϱ�
		   }
		   System.out.print("</"+tagName+">");
	       }
		   break;
	      
	    case Node.TEXT_NODE: //case 3: ���޵� n�� Text���
	       String content = n.getNodeValue(); //content :������ ����
	       System.out.print(content);
	       break;
	       
	    case Node.COMMENT_NODE:
	       System.out.print("<!--"+n.getNodeValue()+"-->");
	       break;
	       
	    case Node.DOCUMENT_NODE:
	       NodeList list = n.getChildNodes();//��Ʈ books, ���ּ�
	       for(int i=0; i<list.getLength(); i++) {
	    	   processNode(list.item(i));
	       }
	  }//switch	
		
	}//processNode
	
	
	public static void main(String[] args) {
		new DOMTest2();
	}
	
}
