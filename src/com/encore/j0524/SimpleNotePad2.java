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
      이벤트 소스: item_open,item_save,item_exit  ===> JMenuItem : ActionListener
      
      열기,저장 대화상자 ===> JFileChooser클래스 사용.     
   */
   public SimpleNotePad2() {
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
	  
      if(ob == item_open) {//열기 선택
    	//파일 (FileReader)  -------> TextArea (setText(), append())  
    	  
    	//1. 열기대화상자
    	int t = chooser.showOpenDialog(this);
    	if(t==0) {//읽을 파일을 선택했고 open버튼을 클릭했다면
    	   File f = chooser.getSelectedFile();//선택된 파일의 정보를 얻어올수 있음.

    	   //2. 파일읽기 ★ ----> (파일)입력객체   FileInputStream  FileReader 
    	   String str = openFile(f);//파일에 관련된 일만 전담(파일읽기)
    	   
    	   ta.setText("");//기존 텍스트 지우기
    	   //3. ta쓰기
    	   ta.append(str);
    	}
    	  
    	  
    	
	  }else if(ob == item_save) {//저장 선택
		//TextArea(getText())  -----> 파일 (FileWriter) 
		  
		//1. 저장대화상자   showSaveDialog()
		int t = chooser.showSaveDialog(this);
		System.out.println("save T="+ t);
		if(t==0) {//경로선택, 저장할 파일명을 입력, 저장버튼을 클릭
		    File f = chooser.getSelectedFile();	
		    System.out.println("새로 생성될 파일의 정보: "+ f.getPath());
		    
		    //2. ta읽기         
		    String str = ta.getText();
		           str = str.replace("\n", "\r\n");
		    //나는 부모클래스10    자식에게
		    //----> 나는 부모클래스 13 10    자식에게
		    //JavaProgramming --str.replace('a','o')--> JovoProgromming !!
		    
		    //3. 파일쓰기 ★       FileWriter  fw;    fw.write(str); 
		    saveFile(f,str);//파일에 관련된 일만 전담(파일쓰기)
		}
		  
		 
		  
	  }else {//if(ob == item_exit) {
		  System.exit(0);
	  }
	   
   }//actionPerformed
   
   
   
   
   
   public String openFile(File f) {
	 //핵심코드: FileReader fr = new FileReader("a.txt");
	           
	 //핵심코드:  File f = new File("a.txt"); 
	 //        FileReader fr = new FileReader(f); 
	 StringBuffer sb=null;
	 FileReader fr=null;
	try {
		 fr= new FileReader(f);
		 char []ch=new char[512];
		 
		 int i;//읽은 문자수를 저장
		 
		 sb = new StringBuffer();
		 while( (i=fr.read(ch)) != -1) {//fr=="a.txt"   fr을 읽어서 배열ch에 값복사!!
		    //char[]배열을 String문자열로 변환  ===> new String(ch[])
			 String str=new String(ch,0,i);
			 sb.append(str);
		 }
		 
	  }  catch (Exception e) {
		e.printStackTrace();
	  } finally {
		  try {
			if(fr != null)fr.close();//입력객체 반환
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	 return sb.toString();  
   }//openFile
   
   
   public void saveFile(File f, String str) {
	  //핵심코드:
	   try {
		FileWriter fw = new FileWriter(f);
		    fw.write(str);
		    
		    fw.close();//출력객체 반환
	} catch (IOException e) {
		e.printStackTrace();
	}
   }
   
   
   public static void main(String[] args) {
	  new SimpleNotePad2();
   }
}



