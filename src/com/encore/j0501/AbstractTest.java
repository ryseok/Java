package com.encore.j0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class AbstractTest {
   public static void main(String[] args) throws IOException {
	 //추상클래스는 'new'키워드 사용X
	 //Shape s = new Shape();
	   Shape s;
	     
	      s = new Circle();
	      s = new Rectangle(); 
	      s = new Triangle();
	      
	   s.draw();
     //-----------------------------------------------
	   //BufferedReader in = new 생성자();
	   //BufferedReader(Reader in)
	   //BufferedReader(Reader in, int sz)
	   //InputStreamReader(InputStream in)
	   InputStream is=System.in;
	   Reader r = new InputStreamReader(is); //new Reader(); 
	   BufferedReader in = new BufferedReader(r);
	   
	   String str = in.readLine();	   
	   
   }//main
}










