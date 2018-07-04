package com.encore.j0524;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SimpleNotePad2 extends JFrame implements ActionListener{
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
   public SimpleNotePad2() {
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
	  
      if(ob == item_open) {//���� ����
    	//���� (FileReader)  -------> TextArea (setText(), append())  
    	  
    	//1. �����ȭ����
    	int t = chooser.showOpenDialog(this);
    	if(t==0) {//���� ������ �����߰� open��ư�� Ŭ���ߴٸ�
    	   File f = chooser.getSelectedFile();//���õ� ������ ������ ���ü� ����.

    	   //2. �����б� �� ----> (����)�Է°�ü   FileInputStream  FileReader 
    	   String str = openFile(f);//���Ͽ� ���õ� �ϸ� ����(�����б�)
    	   
    	   ta.setText("");//���� �ؽ�Ʈ �����
    	   //3. ta����
    	   ta.append(str);
    	}
    	  
    	  
    	
	  }else if(ob == item_save) {//���� ����
		//TextArea(getText())  -----> ���� (FileWriter) 
		  
		//1. �����ȭ����   showSaveDialog()
		int t = chooser.showSaveDialog(this);
		System.out.println("save T="+ t);
		if(t==0) {//��μ���, ������ ���ϸ��� �Է�, �����ư�� Ŭ��
		    File f = chooser.getSelectedFile();	
		    System.out.println("���� ������ ������ ����: "+ f.getPath());
		    
		    //2. ta�б�         
		    String str = ta.getText();
		           str = str.replace("\n", "\r\n");
		    //���� �θ�Ŭ����10    �ڽĿ���
		    //----> ���� �θ�Ŭ���� 13 10    �ڽĿ���
		    //JavaProgramming --str.replace('a','o')--> JovoProgromming !!
		    
		    //3. ���Ͼ��� ��       FileWriter  fw;    fw.write(str); 
		    saveFile(f,str);//���Ͽ� ���õ� �ϸ� ����(���Ͼ���)
		}
		  
		 
		  
	  }else {//if(ob == item_exit) {
		  System.exit(0);
	  }
	   
   }//actionPerformed
   
   
   
   
   
   public String openFile(File f) {
	 //�ٽ��ڵ�: FileReader fr = new FileReader("a.txt");
	           
	 //�ٽ��ڵ�:  File f = new File("a.txt"); 
	 //        FileReader fr = new FileReader(f); 
	 StringBuffer sb=null;
	 FileReader fr=null;
	try {
		 fr= new FileReader(f);
		 char []ch=new char[512];
		 
		 int i;//���� ���ڼ��� ����
		 
		 sb = new StringBuffer();
		 while( (i=fr.read(ch)) != -1) {//fr=="a.txt"   fr�� �о �迭ch�� ������!!
		    //char[]�迭�� String���ڿ��� ��ȯ  ===> new String(ch[])
			 String str=new String(ch,0,i);
			 sb.append(str);
		 }
		 
	  }  catch (Exception e) {
		e.printStackTrace();
	  } finally {
		  try {
			if(fr != null)fr.close();//�Է°�ü ��ȯ
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	 return sb.toString();  
   }//openFile
   
   
   public void saveFile(File f, String str) {
	  //�ٽ��ڵ�:
	   try {
		FileWriter fw = new FileWriter(f);
		    fw.write(str);
		    
		    fw.close();//��°�ü ��ȯ
	} catch (IOException e) {
		e.printStackTrace();
	}
   }
   
   
   public static void main(String[] args) {
	  new SimpleNotePad2();
   }
}



