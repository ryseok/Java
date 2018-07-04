package com.encore.j0523;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SimpleNotePad extends JFrame implements ActionListener{
   JTextArea ta;	
   JScrollPane scroll_ta;	
   
   JMenuBar bar;
     JMenu menu_file;
       JMenuItem item_open;
       JMenuItem item_save;
       JMenuItem item_exit;
   
     JMenu menu_help;
   
    JFileChooser chooser;
   /*
      �̺�Ʈ �ҽ�: item_open,item_save,item_exit  ===> JMenuItem : ActionListener
      
      ����,���� ��ȭ���� ===> JFileChooserŬ���� ���.     
   */
   public SimpleNotePad() {
	  setTitle("���ܸ޸���");
	  
	  chooser = new JFileChooser();
	  
	  item_open = new JMenuItem("����");
	  item_save = new JMenuItem("����");
	  item_exit = new JMenuItem("����");
	  
	  menu_file = new JMenu("����");
	    menu_file.add(item_open);
	    menu_file.add(item_save);
	    menu_file.addSeparator();
	    menu_file.add(item_exit);
	  menu_help = new JMenu("����");
	  
	  bar = new JMenuBar();
	    bar.add(menu_file);
	    bar.add(menu_help);
	  
	  //JMenuBar �����ϱ�!! 
	  setJMenuBar(bar);
	  
	  ta = new JTextArea();
	  scroll_ta = new JScrollPane(ta);
	  
	  add(scroll_ta);
	  setBounds(300,200, 600,600);
	  setVisible(true);
	  
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	 
	  //�޴������� �׼�
	  item_open.addActionListener(this);
	  item_save.addActionListener(this);
	  item_exit.addActionListener(this);
   }//������
   
   @Override
   public void actionPerformed(ActionEvent e) {
	  System.out.println("action");
	  Object ob = e.getSource();
	  
      if(ob == item_open) {
    	 openFile(); 
    	
	  }else if(ob == item_save) {
		  saveFile();
		 
		  
	  }else {//if(ob == item_exit) {
		  System.exit(0);
	  }
	   
   }//actionPerformed
   
   public void openFile() {
	 //1. �����ȭ����
	  //chooser.showOpenDialog(Component parent)//parent: ��ȭ���ڸ� ���� ������ ������!! 
	  int t = chooser.showOpenDialog(this);//parent: ��ȭ���ڸ� ���� ������ ������!!
	  System.out.println("T="+t);//����,���,X ==> 0,1,1
	  
	  try {
		if(t==JFileChooser.APPROVE_OPTION) {//if(t==0) {
			  File f = chooser.getSelectedFile();//f==> ��ο� ���ϸ�
			  System.out.println("���õ� ����: "+ f.getName());
			  
			  //2. �����б� �� ----> (����)�Է°�ü   FileInputStream  FileReader
			  FileReader fr = new FileReader(f);
			  
			  char []cbuf = new char[512];
			  int i;
			  
			  //new String(char []value,int offset, int count)
			  
			  ta.setText("");//TextArea�ʱ�ȭ (���� �ؽ�Ʈ clear!!)
			  
			  while( (i=fr.read(cbuf)) != -1 ) {
				  //3. ta����
				   ta.append(new String(cbuf,0,i));  
			  }
			  fr.close();
		  }
	}catch (IOException e) {
		e.printStackTrace();
	}
	   
		   
   }
   public void saveFile() {
	 //1. �����ȭ����   showSaveDialog()
	 //2. ta�б�          String str = ta.getText()
     //3. ���Ͼ��� ��       FileWriter  fw;    fw.write(str);
   }
   
   
   public static void main(String[] args) {
	  new SimpleNotePad();
   }
}



