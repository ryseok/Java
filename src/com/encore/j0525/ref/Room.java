package com.encore.j0525.ref;

import java.util.Vector;

public class Room {//��ȭ���� ����ǥ�� ��ü
    String title;//������
    int count;//�� �ο���
    String boss;//����(�� ������)
    Vector<Service> userV;//userV: ���� �濡 ������ Client���� ����
                           
    public Room() {
    	userV = new Vector<>();
	} 
}
