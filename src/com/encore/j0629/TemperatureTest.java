package com.encore.j0629;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class TemperatureTest {
 /*
  미션) 화면에 아래와 같이 출력하시오.
  
  내일 서초구 서초1동: 15시 기온은 27.0도 입니다.
 ===> 내일 최고기온 28.0도, 최저기온 22.0도 입니다.
 
 http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1165051000
 
 */
	 //Java에서 DOM파싱 준비
	 DocumentBuilderFactory factory;
	 DocumentBuilder builder;
	 
	 //DOM 프로그램 시작
	 Document doc;

	 public TemperatureTest() {
	    try {	 
	     factory = DocumentBuilderFactory.newInstance();
	     builder = factory.newDocumentBuilder();
	     
	     doc = builder.parse("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1165051000");
	     /*
	       <hour>6</hour>
           <day>1</day>
           <temp>23.0</temp>
           <tmx>28.0</tmx>
           <tmn>22.0</tmn>
	     */
	     
	     NodeList hourList = doc.getElementsByTagName("hour");
	                        //시간정보(3시간 단위: 12시, 15시, 18시)
	     NodeList dayList = doc.getElementsByTagName("day");
	                        //날짜: 0(오늘)  1(내일)  2(모레)
	     NodeList tempList = doc.getElementsByTagName("temp");//특정시간의 온도
	     NodeList maxT = doc.getElementsByTagName("tmx");//그날의 최고기온
	     NodeList minT = doc.getElementsByTagName("tmn");//그날의 최저기온
	     
	     String searchHour = 21+"";//"15"
	     
	     for(int i=0; i<dayList.getLength(); i++) {
	    	 String dayStr = dayList.item(i).getTextContent();//"0" "1" "2"
	    	 String hourStr = hourList.item(i).getTextContent();
	    	 
	    	 if(dayStr.equals("1") && hourStr.equals(searchHour)) {//내일, 오후3시
	    		  //내일 서초구 서초1동: 15시 기온은 27.0도 입니다.
	    	  System.out.println("내일 서초구 서초1동: "+searchHour+
	    	     "시 기온은 "+ tempList.item(i).getTextContent() +"도 입니다.");
	    		  //===> 내일 최고기온 28.0도, 최저기온 22.0도 입니다.	
	    	  System.out.println("내일 최고기온 "+ maxT.item(i).getTextContent()
	    		  +"도, 최저기온 "+minT.item(i).getTextContent()+"도 입니다.");
	    	 }
	     }
	     
	     
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	 }//생성자
	
	
	 public static void main(String[] args) {
		 new TemperatureTest();
	}
}
