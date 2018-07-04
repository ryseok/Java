package com.encore.j0514;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;







public class GUITest implements ActionListener{
	Button bt1,bt2,bt3;//����� �ο��ϰ� �ʹ�!!  <===  �̺�Ʈ �ҽ�
	
	Frame f;
	
    public GUITest() {
        bt1 = new Button("����ư1");
        bt2 = new Button("����ư2");
        bt3 = new Button("����ư3");
        f = new Frame("��������");
        
        //f.setLayout(new FlowLayout());
        //f.setLayout(new GridLayout(2,2));
        f.setLayout(new BorderLayout());//�������� �⺻���̾ƿ�, ����: �ٿ��� ��ġ ǥ��!!
        f.add("Center",bt1);
        f.add("North",bt2);
        f.add("South",bt3);
        
        f.setSize(350, 300);
        f.setVisible(true);
        
        //�̺�Ʈ�ҽ�(~�Ҷ�)��  �̺�Ʈ�ڵ鷯�� ����!!  ===> �̺�Ʈ�ҽ�.add�������̽���(�̺�Ʈ�ڵ鷯��ġ);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        
	}//������
    
    @Override
    public void actionPerformed(ActionEvent e) {//�̺�Ʈ ó���� <=== �������
        Object ob = e.getSource();//actionPerformed()�޼ҵ带 ȣ���� �̺�Ʈ �ҽ��� ���۷��� ���� ���!!
    	
        //���ǹ� ----> ���δٸ� �̺�Ʈ�ҽ��� ���� �޼ҵ带 ȣ���ϰ� ���� �ٸ� ����� �Ҷ� �߰�!!
    	if(ob == bt1)//bt1Ŭ����
    	   System.out.println("1");
    	else if(ob == bt2)//bt2Ŭ����
           System.out.println("2");
    	else if(ob == bt3)//bt3Ŭ����
           System.out.println("3");
    	
    }
    
    
    public static void main(String[] args) {
		new GUITest();
	}

}








