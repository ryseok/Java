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
   JScrollPane scroll; //��ũ�ѹٸ� �����ϴ� �г� ==> ���̰����ϴ� �����Ͱ� ������ ����� �����
   
   /*
     <�̺�Ʈ ó��>
    1. �������� ����� �߰�, ���� ?  ===> �̺�Ʈ�ҽ�  ===> �ڷ���?
       mor,after,eve    apple,straw,banana
      ---------------   -------------------
       JRadioButton         JCheckBox         ===> add~Listener()�޼ҵ� ã��
      -------------------------------------
        addItemListener, addActionListener   
     
    2. ActionListener(�������̽�)���
        --->�޼ҵ� ����---> public void actionPerformed(ActionEvent e){} 
        ===> �̺�Ʈ �ڵ鷯 (��� �߰�,����)
        
    3. ���� ������ ���!!   (�̺�Ʈ�ҽ�   ---����---  �̺�Ʈ�ڵ鷯)    
            �̺�Ʈ�ҽ���.add~Listener(�̺�Ʈ�ڵ鷯��ġ);
    */
   ButtonGroup bg;
   
   public MenuChoiceTest() {
	 setTitle("Menu Choice");
	 mor = new JRadioButton("��ħ",true);   
	 after = new JRadioButton("����");   
	 eve = new JRadioButton("����");
	 
	 bg = new ButtonGroup();
	   bg.add(mor);
	   bg.add(after);
	   bg.add(eve);
	   
	 bg.getSelection();
	 bg.getButtonCount();
	 bg.getElements();
	 
	 
	 apple = new JCheckBox("���");
	 straw = new JCheckBox("����");
	 banana = new JCheckBox("�ٳ���");
	 
	 ta = new JTextArea();
	   
	 //scroll = new JScrollPane(��ũ�ѹٸ� �ʿ���ϴ� ������Ʈ);
	 scroll = new JScrollPane(ta); //��ũ�ѹٸ� �����ϴ� JTextArea!!
	 
	 //ta.setText(""); //�����
	 //ta.append(""); //���� text�� �̾��
	 
	 /*ta.setText("\n\n\t*** ��ħ ***");
	 ta.append("\n\t1.���: true");
	 ta.append("\n\t2.����: false");
	 ta.append("\n\t3.�ٳ���: false");
	 
	 ta.setText("\n\n\t*** ���� ***");
	 ta.append("\n\t1.���: true");
	 ta.append("\n\t2.����: false");
	 ta.append("\n\t3.�ٳ���: false");*/
	 
	 
	 combo = new JComboBox<>();
	  combo.addItem("��ħ");
	  combo.addItem("����");
	  combo.addItem("����");
	  
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
	       
              // x   y  ����  ����  	     
	  setBounds(300,200,350,300);
	  setVisible(true);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  
	  //������(������) ���
	  
	  eventUp();
   }//����
   
   private void eventUp() {//�̺�Ʈ �ҽ� ���!!	   
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
	   System.out.println("action");//üũ�ڽ�,������ư ���õ� ���� action!!	 
       //���� �ٸ� ������Ʈ(�̺�Ʈ�ҽ�)�� actionPerformed�� ���� ȣ���ϰ� ���� �ٸ� ��ɼ���� ���� �ʿ�.
	   Object ob = e.getSource();//ob������ actionPerformed�� ȣ���� ������Ʈ�� �ּҰ� ����!!
	   
	   if(ob == combo) {//�޺��ڽ� ����(����)��
		   String item = (String) combo.getSelectedItem();//item = "��ħ" "����"  "����"
		   if(item.equals("��ħ")) {
			   mor.setSelected(true);
		   }else if(item.equals("����")) {
			   after.setSelected(true);
		   }else {
			   eve.setSelected(true);
		   }
	   }
	   
	   String title="";
		   /*if(ob==eve) {
			   title="����";	    
		   }else if(ob==after) {	
			   title="����";
		   }else {//if(ob==mor) {//��ħ�� �����ߴٸ�
			   title="��ħ";
		   }*/
		   
	   Enumeration<AbstractButton> enu = bg.getElements();//ButtonGroup�� ���� Button����(���) ������	   
	   //Enumeration:������ �������̽�  enu =[mor,after,eve];	   
		   
	   while(enu.hasMoreElements()) {
		   AbstractButton bt = enu.nextElement();
		   if(bt.isSelected()) {			   
		      System.out.println("���õ� ������ư ��:"+ bt.getText());
		      title = bt.getText();
		      break;
		   }
	   }
	   
	   ta.setText("\n\n\t*** "+ title +" ***");	//clear + text�߰�  : �����
	     ta.append("\n\t1.���: "+ apple.isSelected());//����text�� �̾ text�߰�
		 ta.append("\n\t2.����: "+ straw.isSelected());
		 ta.append("\n\t3.�ٳ���: "+ banana.isSelected());
	   
	   //�޺��ڽ� ����
	   combo.setSelectedItem(title);	 
		 
   }//actionPerformed
   
   public static void main(String[] args) {
	  new MenuChoiceTest();
   }
}




