package com.encore.j0516;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGame2 extends JFrame implements ActionListener{
   JTextArea ta;
   JScrollPane scroll_ta;
   
   JButton bt_new, bt_clear, bt_dap, bt_hint, bt_exit ;
   JLabel la;
   JTextField tf;
   
   JPanel panel;
   
   //난수를 저장할 공간 --> int[]com 배열, 사용자 입력데이터 저장 공간 --> int[] user
   int[] com, user; 
   Random r;
   
   int count;
   boolean start;//게임 시작 상태표현
   
   public BaseBallGame2() {
	 setTitle("숫자야구게임");
	 
	 com = new int[3];//int[]com = {0,0,0}
	 user = new int[3];//int[]user = {0,0,0}  ==> 텍스트필드를 통해 입력된 데이터를 저장할 공간
	 
	 r = new Random();		
	 
	 ta = new JTextArea();
	 scroll_ta = new JScrollPane(ta);
	 
	 bt_new = new JButton("새게임");
	 bt_clear = new JButton("지우기");
	 bt_dap = new JButton("정답");
	 bt_hint = new JButton("힌트");
	 bt_exit = new JButton("종료");
	 
	 la = new JLabel("입력:");
	 tf = new JTextField();
	 

	 scroll_ta.setBounds(10, 10, 350, 300);
	 bt_new.setBounds(380,30,90,40);//x,y,가로,세로
	 bt_clear.setBounds(380,90,90,40);
	 bt_dap.setBounds(380,150,90,40);
	 bt_hint.setBounds(380,210,90,40);
	 bt_exit.setBounds(380,270,90,40);
	 
	 la.setBounds(10, 320, 30,30);
	 tf.setBounds(50, 320, 310,30);
	 
	 panel = new JPanel();
	  panel.setLayout(null);
	  panel.setBackground(Color.ORANGE);
	  panel.add(scroll_ta);//(ta);
	  panel.add(bt_new);
	  panel.add(bt_clear);
	  panel.add(bt_dap);
	  panel.add(bt_hint);
	  panel.add(bt_exit);
	  panel.add(la);
	  panel.add(tf);
	 
	 add(panel);
	 
	 setBounds(300,300, 500,410);//(x,y,width,height)
	 setVisible(true);
	 setResizable(false);//사이즈 재조정 불가!!
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 
	 ta.setLineWrap(true);//TextArea에 자동 줄바꿈(가로사이즈를 벗어나는 텍스트 발생시)
	 
	 //new Font(String name,int style,int size)
	 ta.setFont(new Font("굴림체", Font.BOLD , 17));
	 /*
	    clas Font{
	       public static final int BOLD=1; 
	    }
	  */
	 
	 
	 //쓰기금지
	 ta.setEditable(false);
	 //ta.setEnabled(false);//비활성화
	 tf.setEnabled(false);//게임 시작전 입력금지
	 
	 //게임시작전 '정답', '힌트' 비활성화
	 bt_dap.setEnabled(false);	 
	 bt_hint.setEnabled(false);	 
	 
	 ruleDescription();
	 	 
	 eventUp();//감시자 등록 메소드 호출!!
   }//생성자

   private void eventUp() {
	  //tf.addMouseListener(MouseListener ml); 
	   
	  tf.addMouseListener(new MouseAdapter() {
		              // class A extends MouseAdapter{}
		  @Override
		  public void mousePressed(MouseEvent e) {
		     if(!start) //if(start) ===> start == true , if(!start) ==> start ==false
		      JOptionPane.showMessageDialog(tf, "게임시작을 위해 [새게임]버튼을 클릭!!");    
		     //JOptionPane.showMessageDialog  (this, "게임시작을 위해 [새게임]버튼을 클릭!!");  
		     showMsg("게임시작을 위해 [새게임]버튼을 클릭!!");    
		  }
	  }); 
	   
	  tf.addActionListener(this);
	  
	  bt_new.addActionListener(this); 
	  bt_clear.addActionListener(this); 
	  bt_dap.addActionListener(this); 
	  bt_hint.addActionListener(this); 
	  bt_exit.addActionListener(this); 
   }//eventUp
   
   
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
	  System.out.println("▣ 정답은 "+com[0]+com[1]+com[2]);
   }//createNum
   
   public void ruleDescription() {
	   ta.setText("\n\n\t<숫자야구게임>");
	   ta.append("\n1. 게임시작을 위해서 새게임버튼을 클릭");
	   ta.append("\n2. 입력에 중복되지않는 세자리수를 입력 후 엔터");
	   ta.append("\n3. 숫자와 자릿수를 맞추면 Strike, 숫자만 맞추면 Ball이 추가됩니다.");
	   ta.append("\n4. 정답을 보고 싶으면 정답버튼을 클릭");
	   ta.append("\n5. 기타 문의사항이 있으면 관리자에게 연락바람(02-754-7302)");
   }//게임설명
   
   public void initText() {//텍스트컴포넌트 초기화(빈문자열 설정)
	  ta.setText("");
	  tf.setText("");
	  tf.requestFocus();//텍스트필드에 포커스
   }
   
   public void startGame() {	  
	   count=0;
	   start=true;
	  //비활성화 컴포넌트 ---> 활성화
	   bt_dap.setEnabled(true);
	   bt_hint.setEnabled(true);
	   tf.setEnabled(true);	
	   
	   initText();
   }//게임초기화(게임시작) ---> 새게임
   public void endGame() {//한 게임 종료(정답을 맞추거나 '정답'버튼을 클릭했을때)
	   start=false;
	  
	   //활성화 컴포넌트 ---> 비활성화
	   bt_dap.setEnabled(false);
	   bt_hint.setEnabled(false);
	   tf.setEnabled(false);
	   
   }
   
   public boolean validCheck(String str) {//사용자가 입력한 데이터에 대한 검사(3자리 숫자)
	   //str ==> tf.getText()
	  if(str.matches("[0-9]{3}")) {//세자리 숫자 검사
		  return true;//유효한(적당한) 데이터 일때 true 리턴!!
	  }	  
    return false;
   }
   
   
   public boolean duplicateCheck(int user[]) {//사용자가 입력한 숫자에 대한 중복 검사      예) 3  2  3
	  //user[0] user[1] user[2]
	   
	  /*if( user[0]==user[1] || user[0]==user[2] || user[1]==user[2]) { //중복비교
		 return true; 
	  }*/
	  
	  for(int i=0; i<user.length-1; i++) {//0~1
		 for(int j=i+1; j<user.length; j++) {//1~2
			 if(user[i] == user[j]) return true;//중복된 값 발견시 true리턴
		 }
	  }
	  
	return false;
   }
   
   
   public void showMsg(String msg) {
	   JOptionPane.showMessageDialog(this,msg);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {//이벤트처리부 <== 사건 발생시 할일 정의!!

	 Object ob = e.getSource();//이벤트소스의 레퍼런스 정보
	 
	 if(ob==tf) {
		 //사용자가 입력한 TextField값과 com배열의 값을 비교하여 화면(TextArea)에 결과 출력!!
		 
	   String str = tf.getText();//"369"
	   //만약 com[]배열을 String으로 변환한다면   ""+com[0]+com[1]+com[2] ---> "327"
	   
	   if(!validCheck(str)) {//str에 부적절한 데이터가 입력되었다면!!
		   //!validCheck(str) ===> validCheck(str)==false
		  showMsg("세자리 수를 입력!!"); 
		  tf.setText(""); 
		 return;//더이상 진행하지 않겠음!!
	   }
	   
	   for(int i=0; i<user.length; i++) {
		   user[i]=str.charAt(i)-48;
	   }
	   //==> com배열과 비교할수 있는 대등한 int[]my배열 값이 생성
	   
	   
	   if(duplicateCheck(user)) {   //사용자가 입력한 숫자의 중복체크
		 //중복된 숫자 발견시
		   showMsg("중복된 수를 입력할 수 없습니다!!");
		   tf.setText("");
		   return;
	   }
	   
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
		 endGame();
	   }else {
	     ta.append( count+": "+str+" ▶ "+strike+"Strike "+ball+"Ball\n");
	   }
	   tf.setText("");
	   
	   
	   
	 }else if(ob==bt_new) {
	    //com배열에 중복되지않는 0~9의 수를 입력		 
		 createNum();
		 startGame();
	 }else if(ob==bt_clear) {
		//TextComponent내용 삭제 ----> JTextArea, JTextField 내용 지우기
		ta.setText("");
		tf.setText("");
	 }else if(ob==bt_dap) {
		//com난수의 값을 출력!! 
		ta.append("▣ 정답은 ["+com[0]+com[1]+com[2]+"]입니다.\n");
		endGame();
	 }else if(ob == bt_hint) {//힌트버튼을 클릭했다면
		showMsg("힌트 수==> "+ com[r.nextInt(3)]);//com[0]);
		bt_hint.setEnabled(false);
	 }else if(ob==bt_exit) {
		//응용프로그램 종료
		 System.exit(0);
	 }
	   
   }//actionPerformed
   
   public static void main(String[] args) {
	 new BaseBallGame2();
   }
}
