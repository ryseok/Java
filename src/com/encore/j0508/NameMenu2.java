package com.encore.j0508;

import java.util.Vector;

public class NameMenu2 {
   Vector<String> names;//(�̸�)������ �����
   //Vector names=null;
   int cnt;//�Էµ� �̸��� ����ŭ ����
   
   public NameMenu2() {
	  names = new Vector<>();
   }//������
   
   public void insert(String name) {//������ �Է�
	  names.add(name);
   }//insert
   public void select() {//������ �˻�
	 System.out.println("\n#�̸����");  
	 for(int i=0; i<names.size(); i++) {//������ ��ü �ε���
		 System.out.println(" "+ names.get(i)); 
	 }
   }//select
   public void update(String oldName, String newName) {//������ ����
	   
	  for(int i=0; i<names.size(); i++) {//�迭0~4 : ��ü
			if(oldName.equals(names.get(i))) {
				//������ ���� �̸��� ã�Ҵٸ�!!
				//names.set(int index,String element)//�̸� ����
				names.set(i, newName);
				break;
			}
		
	  }//for
   }//update
   public void delete(String delName) {//������ ����
	     names.remove(delName);//�ߺ��� �̸��� ���°��
	  /*for(int i=0; i<names.size(); i++) {//�ߺ��� �̸��� �����ϰ� ��ġ�ϴ� �̸� ��θ� ����
		 //����ǥ��: ������[����÷��]=null;
		 if(delName.equals(names.get(i))) {
	     //������ �̸� ã�� 
		  names.remove(i);
		  cnt--;
		 }
	  }//for
*/   }//delete
   
   //public void duplicateNameCheck() {//�ߺ��� �̸� ����
   public boolean existNameCheck(String name) {//�����ϴ� �̸� üũ
	  if(names.contains(name))return true;
	  return false;
   }//existNameCheck
}









