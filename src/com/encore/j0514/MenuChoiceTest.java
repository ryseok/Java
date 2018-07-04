package com.encore.j0514;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MenuChoiceTest extends JFrame implements ActionListener{
   JRadioButton mor,after,eve;
   JCheckBox apple,straw,banana;
   
   JTextArea ta;
   JComboBox<String> combo;
   
   JPanel northp,southp;
   JScrollPane scroll; //스크롤바를 지원하는 패널 ==> 보이고자하는 데이터가 정해진 사이즈를 벗어날때
   
   /*
     <이벤트 처리>
    1. 누구에게 기능을 추가, 정의 ?  ===> 이벤트소스  ===> 자료형?
       mor,after,eve    apple,straw,banana
      ---------------   -------------------
       JRadioButton         JCheckBox         ===> add~Listener()메소드 찾기
      -------------------------------------
        addItemListener, addActionListener   
     
    2. ActionListener(인터페이스)상속
        --->메소드 구현---> public void actionPerformed(ActionEvent e){} 
        ===> 이벤트 핸들러 (기능 추가,구현)
        
    3. 연결 감시자 등록!!   (이벤트소스   ---연결---  이벤트핸들러)    
            이벤트소스명.add~Listener(이벤트핸들러위치);
    */
   ButtonGroup bg;
   
   public MenuChoiceTest() {
	 setTitle("Menu Choice");
	 mor = new JRadioButton("아침",true);   
	 after = new JRadioButton("점심");   
	 eve = new JRadioButton("저녁");
	 
	 bg = new ButtonGroup();
	   bg.add(mor);
	   bg.add(after);
	   bg.add(eve);
	   
	 bg.getSelection();
	 bg.getButtonCount();
	 bg.getElements();
	 
	 
	 apple = new JCheckBox("사과");
	 straw = new JCheckBox("딸기");
	 banana = new JCheckBox("바나나");
	 
	 ta = new JTextArea();
	   
	 //scroll = new JScrollPane(스크롤바를 필요로하는 컴포넌트);
	 scroll = new JScrollPane(ta); //스크롤바를 지원하는 JTextArea!!
	 
	 //ta.setText(""); //덮어쓰기
	 //ta.append(""); //기존 text에 이어쓰기
	 
	 /*ta.setText("\n\n\t*** 아침 ***");
	 ta.append("\n\t1.사과: true");
	 ta.append("\n\t2.딸기: false");
	 ta.append("\n\t3.바나나: false");
	 
	 ta.setText("\n\n\t*** 점심 ***");
	 ta.append("\n\t1.사과: true");
	 ta.append("\n\t2.딸기: false");
	 ta.append("\n\t3.바나나: false");*/
	 
	 
	 combo = new JComboBox<>();
	  combo.addItem("아침");
	  combo.addItem("점심");
	  combo.addItem("저녁");
	  
	 northp = new JPanel();
	   northp.setLayout(new GridLayout(2, 3));
	   northp.add(mor);
	   northp.add(after);
	   northp.add(eve);
	   northp.add(apple);
	   northp.add(straw);
	   northp.add(banana);
	   
	 southp = new JPanel();
	   southp.add(combo);
	   southp.setBackground(Color.YELLOW);
	   
	  add("North",northp);
	  add("Center", scroll);//ta);
	  add("South",southp);
	       
              // x   y  가로  세로  	     
	  setBounds(300,200,350,300);
	  setVisible(true);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  
	  //감시자(연결자) 등록
	  
	  eventUp();
   }//생성
   
   private void eventUp() {//이벤트 소스 등록!!	   
	   mor.addActionListener(this);   
	   after.addActionListener(this);   
	   eve.addActionListener(this);	   
	   
	   apple.addActionListener(this);   
	   straw.addActionListener(this);   
	   banana.addActionListener(this);
	   
	   combo.addActionListener(this);   
   }
   
   
   
   @Override
   public void actionPerformed(ActionEvent e) {
	   System.out.println("action");//체크박스,라디오버튼 선택된 것을 action!!	 
       //서로 다른 컴포넌트(이벤트소스)가 actionPerformed를 같이 호출하고 서로 다른 기능수행시 구분 필요.
	   Object ob = e.getSource();//ob내에는 actionPerformed를 호출한 컴포넌트의 주소가 저장!!
	   
	   if(ob == combo) {//콤보박스 선택(변경)시
		   String item = (String) combo.getSelectedItem();//item = "아침" "점심"  "저녁"
		   if(item.equals("아침")) {
			   mor.setSelected(true);
		   }else if(item.equals("점심")) {
			   after.setSelected(true);
		   }else {
			   eve.setSelected(true);
		   }
	   }
	   
	   String title="";
		   /*if(ob==eve) {
			   title="저녁";	    
		   }else if(ob==after) {	
			   title="점심";
		   }else {//if(ob==mor) {//아침을 선택했다면
			   title="아침";
		   }*/
		   
	   Enumeration<AbstractButton> enu = bg.getElements();//ButtonGroup에 묶인 Button정보(요소) 얻어오기	   
	   //Enumeration:열거형 인터페이스  enu =[mor,after,eve];	   
		   
	   while(enu.hasMoreElements()) {
		   AbstractButton bt = enu.nextElement();
		   if(bt.isSelected()) {			   
		      System.out.println("선택된 라디오버튼 라벨:"+ bt.getText());
		      title = bt.getText();
		      break;
		   }
	   }
	   
	   ta.setText("\n\n\t*** "+ title +" ***");	//clear + text추가  : 덮어쓰기
	     ta.append("\n\t1.사과: "+ apple.isSelected());//이전text에 이어서 text추가
		 ta.append("\n\t2.딸기: "+ straw.isSelected());
		 ta.append("\n\t3.바나나: "+ banana.isSelected());
	   
	   //콤보박스 변경
	   combo.setSelectedItem(title);	 
		 
   }//actionPerformed
   
   public static void main(String[] args) {
	  new MenuChoiceTest();
   }
}




