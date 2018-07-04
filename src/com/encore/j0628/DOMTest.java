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
    
	DocumentBuilderFactory factory;//����
	DocumentBuilder builder;//�ϲ�
	
	//------------  DOMǥ��, DOM���α׷� ���� --------------
	Document doc;	
	
	public DOMTest() {
        try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			//���(XML����)����
			doc = builder.parse("0628/test.xml");
			
			System.out.println("DOM�Ľ� ����~!!");//text XML�м� ---> �޸� �ε�
		
			//-----------DOM Programming���� ----------------------
			
			//�������� ��Ʈ������Ʈ ������
			Element root = doc.getDocumentElement();
			System.out.println("��Ʈ ������Ʈ��: "+ root.getTagName());
			
			Node n = root.getFirstChild();
			//root: <person>
			
			//����? ����?  (1~12)
			
			System.out.println("���Ÿ��(1~12)="
			                 +n.getNodeType());//1~12
			
			System.out.println("����̸�="+ n.getNodeName());
			System.out.println("��尪="+ n.getNodeValue());
			
			
        } catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        		
	}//������
	
	
	
	public static void main(String[] args) {
		new DOMTest();
	}
	
}
