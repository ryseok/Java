package com.encore.j0629;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class DOMTest6 {
    //Ư�� XML������ ���� �ʰ�(�ε����� �ʰ�) ���ο� XML������ �޸𸮿� ����(DOMƮ�� ����)
	//�޸� ----Ȯ��----> ��������.
	
	DocumentBuilderFactory factory;//����
	DocumentBuilder builder;//�ϲ�
	FileWriter out;
	
	//------------ DOM���α׷� ���� --------------
	Document doc;	
	
	
	public DOMTest6() {
        try {
        	
        	out = new FileWriter("0629/root.xml");
        	
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			doc = builder.newDocument(); //builder.parse("0628/books3.xml");
			          //Ư�� XML�����б� --> �޸� �ε�
			System.out.println("DOM�Ľ�(�޸��Ҵ�) ����~!!");
			
			//doc: Document��ü ----> �������� �޼ҵ� (������Ʈ,�ؽ�Ʈ,�ּ�)
           
			//doc.createElement(String tagName);
	        Element root = doc.createElement("ROOT");//<ROOT></ROOT>
	        Element a = doc.createElement("A");//<A></A>
	        Element b = doc.createElement("B");//<B></B>
	        Element c = doc.createElement("C");//<C></C>
	        Element d = doc.createElement("D");//<D></D>
	        Element e = doc.createElement("E");//<E></E>
        
	        //doc.createTextNode(String data)
	        Text t1 = doc.createTextNode("Hello");
	        Text t2 = doc.createTextNode("GoodBye");
	        Text t3 = doc.createTextNode("GoodDay");
	        
	        
	        //1.�߰�(�ڿ�): �θ���.appendChild(�ڽĳ��);
	        doc.appendChild(root);
	        
	        a.appendChild(c);//<A><C></C></A>
	          c.appendChild(t1);//<A><C>Hello</C></A>
            b.appendChild(t2);//<B>GoodBye</B>
            d.appendChild(t3);//<D>GoodDay</D>
            
            root.appendChild(a);
            root.appendChild(b);
            
          //2.�߰�(�����ֱ�):
          //�θ���.insertBefore(���ο� ���, �������);
            root.insertBefore(d, b);
            
            //3.����: �θ���.removeChild(�������);
            //root.removeChild(b);//b������Ʈ ����
            
            //����, b�±׸� �����ϰ� ������ �θ� �� ���?
            b.getParentNode().removeChild(b);
            
            //4.����(��ü): 
            //�θ���.replaceChild(�����,�������);
            //d�±�  ----> e�±� ��ü!!
            root.replaceChild(e, d);
            
            //5.����: �����ҳ��.cloneNode(����deep����);
            //Node aClone = a.cloneNode(true);//a������Ʈ�� �ڽı��� ����
            Node aClone = a.cloneNode(false);//a������Ʈ�� ����
            root.appendChild(aClone);
            
            //6.��Ÿ
            String data="��&������3<4";
            //data = data.replace("<", "&lt;")
            //           .replace("&", "&amp;");
            Text newTxt = doc.createTextNode(data);
            CDATASection cdata = doc.createCDATASection(data);
            Comment comm = doc.createComment("���ּ�");
            
            //e������Ʈ�� text�߰�
            //e.appendChild(newTxt);
            e.appendChild(cdata);
            e.appendChild(comm);
            
	        
	        processNode(doc);//�޸� ---> ����
	        
	        out.close();
	        System.out.println("DOMƮ��(�޸�)�� ���Ϸ� �ű�� ����");
        }  catch (Exception e) {
			e.printStackTrace();
		} 
        		
	}//������
	
	//�޸� DOM ---> ���� ����
	public void processNode(Node n) throws IOException {//�������� ��ü��� �����ϱ�
		
		  switch(n.getNodeType()) {//1~12 (XML������ �����ϴ� ��Ҹ� �ĺ��ϱ� ���� ��ȣ)
		    //��) 1:Element, 2:Attribute, 3:Text
		    case Node.ELEMENT_NODE:{ //���޵� n�� Element���
			   String tagName = n.getNodeName(); //�±��̸� ���
			   out.write("<"+tagName);
			   
			   NamedNodeMap map = n.getAttributes(); //�Ӽ����ϱ�
			     //n: books������   map[a,b,c]
			   for(int i=0; i<map.getLength(); i++) {
				   Node attr = map.item(i);
				   String attrName = attr.getNodeName();//�Ӽ���
				   String attrValue = attr.getNodeValue(); //�Ӽ���
				   out.write(" "+attrName +"='"+ attrValue+"'" );
			   }
			   
			   out.write(">");
			   
			   NodeList list = n.getChildNodes();//�ڽĿ�ҵ� ���ϱ�(�Ӽ��� ����!!)
			   
			   for(int i=0; i<list.getLength(); i++) {//NodeList�� �ε��� ǥ��
				//item(0):ù��° �ڽ�  item(1):�ι�° �ڽĿ�ȣ
				Node node = list.item(i);
				processNode(node);//�ڽĿ�� ���ϱ�
			   }
			     out.write("</"+tagName+">");
		       }
			   break;
		      
		    case Node.TEXT_NODE: //case 3: ���޵� n�� Text���
		       String content = n.getNodeValue(); //content :������ ����
		       out.write(content);
		       break;
		       
		    case Node.COMMENT_NODE:
		    	out.write("<!--"+n.getNodeValue()+"-->");
		       break;
		       
		    case Node.DOCUMENT_NODE:
		        out.write("<?xml version='1.0' encoding='euc-kr' ?>");	
		    	
		       NodeList list = n.getChildNodes();//��Ʈ books, ���ּ�
		       for(int i=0; i<list.getLength(); i++) {
		    	   processNode(list.item(i));
		       }
		       break;
		    case Node.CDATA_SECTION_NODE:
		    	out.write("<![CDATA["+n.getNodeValue()+"]]>");
		  }//switch	
			
     }//processNode
	
	
	public static void main(String[] args) {
		new DOMTest6();
	}
	
}
