package com.encore.j0504;

public class NameMenu {
   String []names;//(�̸�)������ �����
   
   int cnt;//�Էµ� �̸��� ����ŭ ����
   
   public NameMenu() {
	  names = new String[5];
	  //names[0]����~names[4]���� �游���
	  //�� �濡�� null���� �Է�
   }//������
   
   public void insert(String name) {//������ �Է�
	 //main()���� ���޹��� �̸��� �迭�� ����!!
	 //�����(null)�� ã�Ƽ� �̸��� ����!! 
//	   if(names[0] == null)names[0]=name;
//	   else if(names[1] == null)names[1]=name; 
//	   else if(names[2] == null)names[2]=name;
	   for(int i=0; i<names.length; i++) {//0~4
		   if(names[i] == null) {//�����ã��!!
			   names[i]=name;
			   cnt++;
			   break;
		   }
	   }//for
   }//insert
   public void select() {//������ �˻�
	 System.out.println("\n#�̸����");  
	 for(int i=0; i<names.length; i++) {//�迭�� ��ü �ε���
		//System.out.print("names["+i+"]����=");
	    if(names[i] != null)	 
		 System.out.println(" "+names[i]); 
	 }
   }
   public void update(String oldName, String newName) {//������ ����
	  for(int i=0; i<names.length; i++) {//�迭0~4 : ��ü
		/*if(names[i] != null) {//���� �ƴҶ�  
		  if(names[i].equals(oldName)) {
		   //������ ���� �̸��� ã�Ҵٸ�!!
		     names[i]=newName;//�̸� ����
		     break;
		  }
		}*/
		       //"".equals("")
			if(oldName.equals(names[i])) {
				//������ ���� �̸��� ã�Ҵٸ�!!
				names[i]=newName;//�̸� ����
				break;
			}
		
	  }//for
   }//update
   public void delete(String delName) {//������ ����
	   
	  for(int i=0; i<names.length; i++) {
		 //����ǥ��: ������[����÷��]=null;
		 if(delName.equals(names[i])) {
	     //������ �̸� ã�� 
		  names[i]=null;
		  cnt--;
		  break;
		 }
	  }//for
   }//delete
   
   //public void duplicateNameCheck() {//�ߺ��� �̸� ����
   public boolean existNameCheck(String name) {//�����ϴ� �̸� üũ
	  for(int i=0; i<names.length; i++) {
		  if(name.equals(names[i])) {//��ġ�ϴ� �̸��߽߰�!!
			 return true; 
		  }
	  }
	  return false;
   }//existNameCheck
}









