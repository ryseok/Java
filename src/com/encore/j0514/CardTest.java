package com.encore.j0514;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardTest extends Frame implements ActionListener{
	
	//색깔 패널
	Panel redp, bluep, greenp;
	//'다음' 버튼
	Button b1,b2,b3;//<=== 이벤트 소스!! : Button  : add~Listener() : addActionListener()
	
	//카드표현 패널
	Panel p1,p2,p3;
	
	CardLayout card;
	
	public CardTest() {
	   setTitle("카드레이아웃");
		
       redp = new Panel();   
         redp.setBackground(Color.red);
       bluep = new Panel();   
         bluep.setBackground(Color.blue);
       greenp = new Panel();
         greenp.setBackground(Color.green);
       
       b1 = new Button("다음");
       b2 = new Button("다음");
       b3 = new Button("다음");
       
       p1 = new Panel();//패널 기본레이아웃 : FlowLayout
        p1.setLayout(new BorderLayout());
        p1.add("Center",redp);
        p1.add("South",b1);
        
       p2 = new Panel();//패널 기본레이아웃 : FlowLayout
        p2.setLayout(new BorderLayout());
        p2.add("Center",bluep);
        p2.add("South",b2);
        
       p3 = new Panel();//패널 기본레이아웃 : FlowLayout
        p3.setLayout(new BorderLayout());
        p3.add("Center",greenp);
        p3.add("South",b3);
        
        
      card = new CardLayout();  
      setLayout(card); //같은 위치에 컴포넌트(p1,p2,p3) 배치!!
      //카드레이아웃의 경우 '별명(alias)'을 함께 지정
      
       add("a1",p1); //가장 먼저 add된 카드가 프로그램 시작시 보임!!
       add("a2",p2); 
       add("a3",p3);
       //"a1","a2","a3" ----> 별명
       
      //프로그램 시작시 녹색 카드가 보이고 싶다!! ---> CardLayout의 show()메소드 사용..
       
      //card.show (Container parent,String name);
      // 를     보여라                    어디에              무엇을
      card.show(this, "a3");
       
       
      setSize(350,450);
      setVisible(true);
      
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//사건(이벤트)발생시 호출될 메소드 : 이벤트 핸들러 (기능추가)
	   Object ob = e.getSource();//이벤트소스의 주소정보	
		
	   if(ob==b1) {// p1 빨강카드밑 다음버튼 b1 클릭시
		   card.show(this, "a2");
	   }else if(ob==b2) {//p2 파랑카드밑 다음버튼 b2 클릭시
		   card.show(this, "a3");
	   }else {//p3 초록카드밑 다음버튼 b3 클릭시
		   card.show(this, "a1");
	   }
		
	}//actionPerformed
	
	public static void main(String[] args) {
		new CardTest();
	}


}



