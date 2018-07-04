package com.encore.j0515;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 <이벤트 처리>
 1. 이벤트 소스: bt_new, bt_clear, bt_dap, bt_exit, tf
    ---> 버튼이 눌렸을때, 텍스트필드에 엔터가 입력되었을때 ---> Action이벤트!!
    
 2. implements ActionListener
    actionPerformed구현
    
 3. 연결자 등록
    버튼.addActionListener(this);        
    텍스트필드.addActionListener(this);        
  
 */
public class BaseBallGame extends JFrame implements ActionListener{
   JTextArea ta;
   JButton bt_new, bt_clear, bt_dap, bt_exit;
   JLabel la;
   JTextField tf;
   //JScrollPane: 범위를 벗어나는 데이터를 표현(JTextArea, JList, JTable)
   JScrollPane scroll_ta;
   
   JPanel panel;
   
   //난수를 저장할 공간 --> int 배열
   int[] com, user; 
   Random r;
   
   int count;
   
   public BaseBallGame() {
	 setTitle("숫자야구게임");
	 
	 com = new int[3];//int[]com = {0,0,0}
	 user = new int[3];//int[]user = {0,0,0}  ==> 텍스트필드를 통해 입력된 데이터를 저장할 공간
	 
	 r = new Random();		
	 
	 ta = new JTextArea();
	 //scroll_ta = new JScrollPane(스크롤바를 필요로 하는 컴포넌트);
	 scroll_ta = new JScrollPane(ta);
	 
	 bt_new = new JButton("새게임");
	 bt_clear = new JButton("지우기");
	 bt_dap = new JButton("정답");
	 bt_exit = new JButton("종료");
	 
	 la = new JLabel("입력:");
	 tf = new JTextField();
	 
	 //ta.setBounds(10, 10, 350, 300);
	 scroll_ta.setBounds(10, 10, 350, 300);
	 bt_new.setBounds(380,60,90,40);
	 bt_clear.setBounds(380,120,90,40);
	 bt_dap.setBounds(380,180,90,40);
	 bt_exit.setBounds(380,240,90,40);
	 
	 la.setBounds(10, 320, 30,30);
	 tf.setBounds(50, 320, 310,30);
	 
	 panel = new JPanel();
	  panel.setLayout(null);
	  panel.setBackground(Color.ORANGE);
	  panel.add(scroll_ta);//(ta);
	  panel.add(bt_new);
	  panel.add(bt_clear);
	  panel.add(bt_dap);
	  panel.add(bt_exit);
	  panel.add(la);
	  panel.add(tf);
	 
	 add(panel);
	 setBounds(300,300, 500,410);
	 setVisible(true);
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 createNum();
	 
	 
	 eventUp();//감시자 등록 메소드 호출!!
   }//생성자

   private void eventUp() {
	  tf.addActionListener(this);
	  
	  bt_new.addActionListener(this); 
	  bt_clear.addActionListener(this); 
	  bt_dap.addActionListener(this); 
	  bt_exit.addActionListener(this); 
   }
   
   public void createNum() {
	  for(int i=0; i<com.length; i++) {//생성
		  com[i]=r.nextInt(10);//0~9
		  for(int j=i-1; j>-1; j--) {//중복검사   i=[1]와 j=[0]    i=[2]와 j=[1] j=[0]
			 if(com[i] == com[j]) {//중복된 수를 발견
			     i--;
			     break;
			 }
		  }//for
	  }//for
	   
	   /*com[0]=r.nextInt(10);
		do { 
		 com[1]=r.nextInt(10);
		}while(com[1] == com[0]);
		
		do {
		 com[2]=r.nextInt(10);
		}while(com[2] == com[1] || com[2] == com[0]);*/
   }//createNum
   
   @Override
   public void actionPerformed(ActionEvent e) {//이벤트처리부 <== 사건 발생시 할일 정의!!
      //ta.append("1: 123 ▶ 1Strike 1Ball\n");
	 Object ob = e.getSource();//이벤트소스의 레퍼런스 정보
	 
	 //우선순위 : bt_exit, bt_clear, bt_dap, bt_new, tf
	 
	 if(ob==tf) {
		 //사용자가 입력한 TextField값과 com배열의 값을 비교하여 화면(TextArea)에 결과 출력!!
		 
	   String str = tf.getText();//"369"
	   //만약 com[]배열을 String으로 변환한다면   ""+com[0]+com[1]+com[2] ---> "327"
	   
	  /*
	   int su = Integer.parseInt(str);//"369" ----> 369
	   user[0]= su/100; //  369/100 ---> 3
	   user[1]= (su%100)/10;  // 369%100  ---> 69/10  ---> 6
	   user[2]= (su%100)%10;  // 369%100  ---> 69%10  ---> 9
      */	   
		 
	  /*
	  user[0]= str.charAt(0)-48; //user[0] = '3'-48  = 51-48 ? 
	  user[1]= str.charAt(1)-48; 
	  user[2]= str.charAt(2)-48;
	  */
	   for(int i=0; i<user.length; i++) {
		   user[i]=str.charAt(i)-48;
	   }
	   //==> com배열과 비교할수 있는 대등한 int[]my배열 값이 생성
	   
	   int strike=0, ball=0;
	   
	   for(int i=0; i<com.length; i++) {//com배열
		   for(int j=0; j<user.length; j++) {//user배열
			   //숫자값 비교!!
			   if(com[i] == user[j]) {//같은수 ---> 스트라이크 또는 볼의 후보!!
				   if(i==j) {//같은 자릿수 비교 ---> 스트라이크!!
					   strike++;
				   }else {//다른 자릿수  ---> 볼!!
					   ball++;
				   }
			   }
		   }
	   }//for
	   
	   count++;
	   if(strike==3) {
		 ta.append("♥축하합니다♥ 정답["+str+"]을 맞추셨습니다^^*\n");  
	   }else {
	     ta.append( count+": "+str+" ▶ "+strike+"Strike "+ball+"Ball\n");
	   }
	   tf.setText("");
	   
	   
	   
	 }else if(ob==bt_new) {
	    //com배열에 중복되지않는 0~9의 수를 입력
		 count=0;
		 createNum();
		
	 }else if(ob==bt_clear) {
		//TextComponent내용 삭제 ----> JTextArea, JTextField 내용 지우기
		ta.setText("");
		tf.setText("");
	 }else if(ob==bt_dap) {
		//com난수의 값을 출력!! 
		ta.append("▣ 정답은 ["+com[0]+com[1]+com[2]+"]입니다.\n");
		         //   "abc" + 0    + 7+     9
		         //   "abc0" + 7 + 9
		         //   "abc07"+9
		         //   "abc079"
		
	 }else if(ob==bt_exit) {
		//응용프로그램 종료
		 System.exit(0);
	 }
	   
   }//actionPerformed
   
   public static void main(String[] args) {
	 new BaseBallGame();
   }
}
