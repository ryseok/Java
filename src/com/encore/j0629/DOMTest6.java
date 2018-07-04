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
    //특정 XML문서를 읽지 않고(로드하지 않고) 새로운 XML문서를 메모리에 생성(DOM트리 생성)
	//메모리 ----확인----> 파일저장.
	
	DocumentBuilderFactory factory;//공장
	DocumentBuilder builder;//일꾼
	FileWriter out;
	
	//------------ DOM프로그램 시작 --------------
	Document doc;	
	
	
	public DOMTest6() {
        try {
        	
        	out = new FileWriter("0629/root.xml");
        	
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			doc = builder.newDocument(); //builder.parse("0628/books3.xml");
			          //특정 XML파일읽기 --> 메모리 로딩
			System.out.println("DOM파싱(메모리할당) 성공~!!");
			
			//doc: Document객체 ----> 생성관련 메소드 (엘리먼트,텍스트,주석)
           
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
	        
	        
	        //1.추가(뒤에): 부모노드.appendChild(자식노드);
	        doc.appendChild(root);
	        
	        a.appendChild(c);//<A><C></C></A>
	          c.appendChild(t1);//<A><C>Hello</C></A>
            b.appendChild(t2);//<B>GoodBye</B>
            d.appendChild(t3);//<D>GoodDay</D>
            
            root.appendChild(a);
            root.appendChild(b);
            
          //2.추가(끼워넣기):
          //부모노드.insertBefore(새로운 노드, 참조노드);
            root.insertBefore(d, b);
            
            //3.삭제: 부모노드.removeChild(삭제노드);
            //root.removeChild(b);//b엘리먼트 삭제
            
            //만약, b태그를 삭제하고 싶은데 부모를 모를 경우?
            b.getParentNode().removeChild(b);
            
            //4.수정(대체): 
            //부모노드.replaceChild(새노드,기존노드);
            //d태그  ----> e태그 대체!!
            root.replaceChild(e, d);
            
            //5.복제: 복제할노드.cloneNode(깊이deep상태);
            //Node aClone = a.cloneNode(true);//a엘리먼트의 자식까지 복제
            Node aClone = a.cloneNode(false);//a엘리먼트만 복제
            root.appendChild(aClone);
            
            //6.기타
            String data="나&데이터3<4";
            //data = data.replace("<", "&lt;")
            //           .replace("&", "&amp;");
            Text newTxt = doc.createTextNode(data);
            CDATASection cdata = doc.createCDATASection(data);
            Comment comm = doc.createComment("나주석");
            
            //e엘리먼트에 text추가
            //e.appendChild(newTxt);
            e.appendChild(cdata);
            e.appendChild(comm);
            
	        
	        processNode(doc);//메모리 ---> 파일
	        
	        out.close();
	        System.out.println("DOM트리(메모리)를 파일로 옮기기 성공");
        }  catch (Exception e) {
			e.printStackTrace();
		} 
        		
	}//생성자
	
	//메모리 DOM ---> 파일 쓰기
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
		       break;
		    case Node.CDATA_SECTION_NODE:
		    	out.write("<![CDATA["+n.getNodeValue()+"]]>");
		  }//switch	
			
     }//processNode
	
	
	public static void main(String[] args) {
		new DOMTest6();
	}
	
}
