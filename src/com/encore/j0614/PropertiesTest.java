package com.encore.j0614;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {
   public static void main(String[] args) {
	  Properties  pro = new Properties(); //�Ӽ� �����͸� ��� Ŭ����
	  //property(�Ӽ�)
	  
	  //������ ����(�Է�)
	  //pro.setProperty(String key,String value);
	  //key: ���� �Ǵ� �˻��� ���� ��(������ ��)
	  //     key == ������!!
	  //value: �����ϰ��� �ϴ� ���ڿ�(text) ������.
	  
	  pro.setProperty("k1", "�浿");
	  pro.setProperty("k2", "����");
	  pro.setProperty("k3", "�ֿ�");
	  
	  pro.setProperty("k3", "����");//----> k3�� "����"������ overwrite
	  
	  //������ ���(��ȸ)
	  System.out.println("k1===>"+ pro.getProperty("k1"));
	  System.out.println("k2===>"+ pro.getProperty("k2"));
	  System.out.println("k3===>"+ pro.getProperty("k3"));
	  
	  System.out.println("=========================");
      //���� Ű���� �𸣴� ���
	  Enumeration enu = pro.propertyNames(); //����� Ű���� ������
	  //Enumeration: ������ �������̽�
	  //enu = [k1,k2,k3]
	  
	  while(enu.hasMoreElements()) {
		  Object key = enu.nextElement();
		  System.out.println(key+" : "+ pro.getProperty(key.toString()));
	  }
	  
	  //test.properties���Ϸ� ���� �Ӽ������� ������!!	  
	  //pro.load(Reader reader)
	  
	  try {
		pro.load(new FileReader("src/com/encore/j0614/test.properties"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	  
	  System.out.println("�̸�: "+ pro.getProperty("name"));
	  System.out.println("����: "+ pro.getProperty("age"));
	  System.out.println("����: "+ pro.getProperty("job"));
	  System.out.println("��Ÿ: "+ pro.getProperty("etc"));
	  
	  
   }//main
}



