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
      이벤트 소스: item_open,item_save,item_exit  ===> JMenuItem : ActionListener
      
      열기,저장 대화상자 ===> JFileChooser클래스 사용.     
   */
   public SimpleNotePad() {
	  setTitle("간단메모장");
	  
	  chooser = new JFileChooser();
	  
	  item_open = new JMenuItem("열기");
	  item_save = new JMenuItem("저장");
	  item_exit = new JMenuItem("종료");
	  
	  menu_file = new JMenu("파일");
	    menu_file.add(item_open);
	    menu_file.add(item_save);
	    menu_file.addSeparator();
	    menu_file.add(item_exit);
	  menu_help = new JMenu("도움말");
	  
	  bar = new JMenuBar();
	    bar.add(menu_file);
	    bar.add(menu_help);
	  
	  //JMenuBar 설정하기!! 
	  setJMenuBar(bar);
	  
	  ta = new JTextArea();
	  scroll_ta = new JScrollPane(ta);
	  
	  add(scroll_ta);
	  setBounds(300,200, 600,600);
	  setVisible(true);
	  
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	 
	  //메뉴아이템 액션
	  item_open.addActionListener(this);
	  item_save.addActionListener(this);
	  item_exit.addActionListener(this);
   }//생성자
   
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
	 //1. 열기대화상자
	  //chooser.showOpenDialog(Component parent)//parent: 대화상자를 누구 위에서 보일지!! 
	  int t = chooser.showOpenDialog(this);//parent: 대화상자를 누구 위에서 보일지!!
	  System.out.println("T="+t);//열기,취소,X ==> 0,1,1
	  
	  try {
		if(t==JFileChooser.APPROVE_OPTION) {//if(t==0) {
			  File f = chooser.getSelectedFile();//f==> 경로와 파일명
			  System.out.println("선택된 파일: "+ f.getName());
			  
			  //2. 파일읽기 ★ ----> (파일)입력객체   FileInputStream  FileReader
			  FileReader fr = new FileReader(f);
			  
			  char []cbuf = new char[512];
			  int i;
			  
			  //new String(char []value,int offset, int count)
			  
			  ta.setText("");//TextArea초기화 (이전 텍스트 clear!!)
			  
			  while( (i=fr.read(cbuf)) != -1 ) {
				  //3. ta쓰기
				   ta.append(new String(cbuf,0,i));  
			  }
			  fr.close();
		  }
	}catch (IOException e) {
		e.printStackTrace();
	}
	   
		   
   }
   public void saveFile() {
	 //1. 저장대화상자   showSaveDialog()
	 //2. ta읽기          String str = ta.getText()
     //3. 파일쓰기 ★       FileWriter  fw;    fw.write(str);
   }
   
   
   public static void main(String[] args) {
	  new SimpleNotePad();
   }
}



