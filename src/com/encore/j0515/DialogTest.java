package com.encore.j0515;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogTest extends JFrame implements ActionListener{
   //대화상자: 메시지대화상자, 입력대화상자, 확인대화상자
   
   JButton bt1,bt2,bt3;	
	
   public DialogTest() {
	  setTitle("대화상자테스트");
	  
	  bt1 = new JButton("메시지창");
	  bt2 = new JButton("입력창");
	  bt3 = new JButton("확인창");
	  
	  setLayout(new FlowLayout());
	  add(bt1);
	  add(bt2);
	  add(bt3);

	  setBounds(300,200, 300,300);//위치, 크기
	  setVisible(true);
	  
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  
	  bt1.addActionListener(this);
	  bt2.addActionListener(this);
	  bt3.addActionListener(this);
   }//생성자
   
   @Override
   public void actionPerformed(ActionEvent e) {
	  Object ob = e.getSource();
	  if(ob==bt1) {//'메시지창'버튼 클릭시
		//JOptionPane.showMessageDialog(Component parentComponent,Object message); 
		//parentComponent: 띄울 창의 위치 , message: 전달하고자 하는 메시지);
		//JOptionPane.showMessageDialog(bt1, "오늘 낮은 덥습니다~!!");
		JOptionPane.showMessageDialog(this , "오늘 낮은 덥습니다~!!");
		
	  }else if(ob==bt2) {//'입력창'버튼 클릭시
		 //JOptionPane.showInputDialog(Component parentComponent,Object message)
		 String str = JOptionPane.showInputDialog(this,"저녁에 뭐 먹니?");
		 System.out.println("STR="+str);
		 //확인, 취소, X ---> 입력값 또는 빈문자열, null, null
		 JOptionPane.showMessageDialog(this , "["+str+"]좋아요~^O^!!");
	  }else if(ob==bt3) {//'확인창'버튼 클릭시
		//JOptionPane.showConfirmDialog(Component parentComponent,Object message)
		 int t = JOptionPane.showConfirmDialog(this, "정말삭제하시겠습니까?");//재확인,중간체크 용도
		 System.out.println("T="+ t);
		 //예, 아니오, 취소, X  ---> 0,1,2,-1
		 if(t==0) {
			 System.out.println("삭제처리 되었습니다~!!");
		 }
	  }
   }//actionPerformed
   
   public static void main(String[] args) {
	  new DialogTest();
   }

	
}

