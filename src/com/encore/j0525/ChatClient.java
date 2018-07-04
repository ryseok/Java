package com.encore.j0525;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener, Runnable{
   //프레임Center ---> JTextArea(서버가 보낸 메시지를 출력)
   //프레임South  ---> JTextField(서버에게 보낼 메시지), JButton(대화명 변경)	
   JTextField tf;	
   JTextArea ta;
   JScrollPane scrol_ta;
   JButton bt;
   
   JPanel southp;
	
   BufferedReader in;//소켓읽기
   OutputStream out;//소켓쓰기
   
   public ChatClient() {
	 setTitle("대화방");
	 tf = new JTextField(15);
	 ta = new JTextArea();
	 scrol_ta = new JScrollPane(ta);
	 
	 bt = new JButton("대화명변경");
	 southp = new JPanel();
	    southp.add(tf);
	    southp.add(bt);
	 
	 add("South", southp );//tf);
	 add("Center",scrol_ta);
	 setBounds(300,200,  300,600);
	 setVisible(true);
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 
	 connectProcess();
	 new Thread(this).start();
	 
	 String nickName = JOptionPane.showInputDialog(this,"대화명:");
	 //나의 대화명을 서버에게 알리기!! ===> 데이터 보내기(쓰기)  ===> out.write()
	 toServer("100|"+nickName);
	 
	 tf.addActionListener(this);
	 bt.addActionListener(this);
	 
   }//생성자
   
   public void connectProcess() {//서버와 연결작업
	  try {
		Socket s = new Socket("192.168.0.22", 3000);//★3. 소켓서버 연결
		  
		  //★4. 소켓 입출력 객체 생성
		  out = s.getOutputStream();//상대방에게 메시지를 보내겠다.
		  InputStream is = s.getInputStream();//상대방이 보낸 메시지를 읽겠다.
		  in = new BufferedReader(new InputStreamReader(is));
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
   }//connectProcess
   
   public void run() {//스레드 사용이유? GUI와 상관없이 서버가 보낸 메시지를 대기하기 위해서
	  try {
		while(true) { 
		    String msg = in.readLine(); //★8.서버가 보낸 (소켓을 통해 전달된)메시지 읽기!!
		    ta.append(msg+"\n");
		    //ta.setCaretPosition(int position);
		    ta.setCaretPosition(ta.getText().length());
		  }
	  } catch (IOException e) {
		e.printStackTrace();
	  }
   }//run
   
   
   public void sendMsg() {//서버에게 메시지 전달	   
		String msg = tf.getText().trim();
		if(msg.length() < 1)return;//빈값 체크
		   toServer("200|"+msg);//★5. 메시지 보내기
		   tf.setText("");
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
	   Object ob = e.getSource();
	   if(ob==tf) {//서버에게 메시지 전달
		   sendMsg();
	   }else if(ob==bt) {//'대화명변경' 버튼 클릭
		  String nickName = JOptionPane.showInputDialog(this, "변경대화명:");
		  toServer("300|"+nickName);
	   }
   }
   
   
   public void toServer(String msg) {//서버에게 메시지 보내기
	   try {
		out.write( (msg+"\n").getBytes() );
	  } catch (IOException e) {
		e.printStackTrace();
	  }
   }
   
   public static void main(String[] args) {
	  new ChatClient();
   }

}





