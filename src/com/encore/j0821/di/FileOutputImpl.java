package com.encore.j0821.di;

import java.io.FileWriter;

public class FileOutputImpl implements FileOutput{

	@Override
	public void output(String str) {
      try {
	   FileWriter fw = new FileWriter("hello2.txt"); //파일생성
	    fw.write(str); //파일에 내용 쓰기
	    
	    fw.close();
      }catch(Exception e) {e.printStackTrace();}
	}

}