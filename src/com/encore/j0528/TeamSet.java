package com.encore.j0528;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TeamSet extends JFrame implements ActionListener{
    
	JLabel la_team1,la_team2,la_team3;
	JButton [] bt;
	JTextField tf;
	Random r;
	String entry="�������������ȯ����������������ȯ����ȯ�̼����̿�����쿵";
	int count;
	
	public TeamSet() {
	   setTitle("1������������Ʈ");	
		
	   r = new Random();
	   tf = new JTextField();
	   tf.setFont(new Font("����", Font.BOLD, 30));
	   
	   la_team1 = new JLabel("<1��>");
	     la_team1.setFont(new Font("����", Font.BOLD, 20));
	   la_team2 = new JLabel("<2��>");
	     la_team2.setFont(new Font("����", Font.BOLD, 20));
	   la_team3 = new JLabel("<3��>");
	     la_team3.setFont(new Font("����", Font.BOLD, 20));
	   
	   bt = new JButton[9];
	   
	   int x=120,y=45, width=110, height=40;
	   for (int i = 0; i < bt.length; i++) {
		  bt[i] = new JButton("");
		  bt[i].setFont(new Font("����", Font.BOLD, 25));
		  
		 if(i<3) { 
		  bt[i].setBounds(x, y, width, height);
		  bt[i].setBackground(Color.orange);
		   x+=120;
		 }else if(i<6) {
			if(i==3) {x=120; y+=70;} 
			else {
				x+=120;
			}
			bt[i].setBounds(x, y, width, height);
			bt[i].setBackground(Color.green);
		 }else {
			 if(i==6) {x=120; y+=70;} 
			 else {
				 x+=120;
			 }
			 bt[i].setBounds(x, y, width, height);
			 bt[i].setBackground(Color.yellow);
		 }		  
		  add(bt[i]);
	   }//for
	   
	   la_team1.setBounds(30, 50, 70, 30);
	   la_team2.setBounds(30, 120, 70, 30);
	   la_team3.setBounds(30, 190, 70, 30);
	   
	   tf.setBounds(180, 250, 200, 50);
	   
	   setLayout(null);
	   
	   add(la_team1);
	   add(la_team2);
	   add(la_team3);
	   add(tf);
	   
	   setBounds(300,200,520, 400);
	   setVisible(true);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   
	   tf.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
       String name = tf.getText();
       
       
       
       /*if(entry.contains(name)) {
    	  JOptionPane.showMessageDialog(this, "�����ϴ� �̸�!!");
       }else {
          JOptionPane.showMessageDialog(this, "�������� �ʴ� �̸�!!");
       }*/
       
       if(!entry.contains(name)) {
    	   JOptionPane.showMessageDialog(this, "�������� �ʴ� �̸��Դϴ�!!");
     	  tf.setText("");
     	  return;
        }
       

       if(count==9) {
    	   JOptionPane.showMessageDialog(this, "������ �������ϴ�^^*!!"); 
    	   tf.setText("");
      	   return;
       }
       
       while(true) {
         int idx = r.nextInt(9);         
         if (bt[idx].getText().equals("")) {
        	 bt[idx].setText(name); //bt[0]~ bt[8]
        	 count++;
        	 break;
         }
       }
       
       tf.setText("");
	}
	public static void main(String[] args) {
		new TeamSet();
	}

}

















