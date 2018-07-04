package com.encore.j0516;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame{
   /*
     JFame 'Center'�� javax.swing.JTable�� add��Ű�ÿ�.
        �׸��� �Ʒ��� �����͸� JTable�� �Է�(ǥ��)�Ͻÿ�.
    
      <������>
      �̸�        ����        ����
   --------------------
    ȫ�浿        13     �л�
    �����        15     �л�
    ���ֿ�        17     �л�
          
    */
	JTable table;
	JScrollPane scroll_table;//������ ����� �����͸� ǥ�� : JTextArea, JTable, JList
	
	public JTableTest() {
		setTitle("JTable�׽�Ʈ");
		
		Object [][]rowData= {
				            //��     0      1    2
				               {"ȫ�浿", 13, "�л�"},//ù��° ��, 0��
				               {"�����", 15, "�л�"},//�ι�° ��, 1��
				               {"���ֿ�", 17, "�л�"}//����° ��,  2��				               
		                    };
		Object[] columnNames= { "�̸�", "����", "����"};//�÷�(����) Ÿ��Ʋ
		
		//table = new JTable(Object [][]rowData,  Object[] columnNames)
		//table = new JTable(rowData, columnNames);
		//table = new JTable(TableModel dm)
		     //TableModel: �������̽�  ----����---> DefaultTableModel !!
		DefaultTableModel dtm = new DefaultTableModel(rowData, columnNames);
		table = new JTable(dtm) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};//dtm���� ���̺� (��)�����͸� �߰�,����,�����Ҽ� �ִ� �޼ҵ带 ����
		
		
		
		
		//scroll_table = new JScrollPane(��ũ�ѹٸ� �ʿ�� �ϴ� ������Ʈ);
		scroll_table = new JScrollPane(table);//��ũ�ѹٸ� �����ϴ� JTable!!
		
		add(scroll_table);//(table);
		
		setBounds(300,200, 350, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
/*
      <������>
      �̸�        ����        ����
   --------------------
    ȫ�浿        13     �л�      ----> 0��
    �����        15     �л�      ----> 1��
    ���ֿ�        17     �л�      ----> 2��
 ��   0       1       2   
          
    */
		
		//����1) JTable���� '�����'�� �� (�ܼ�)ȭ�鿡 ����Ͻÿ�.
		      //table.get�޼ҵ�() ã��    : ��Ʈ===> �࿭ �ε����� ���!!
		//table.getValueAt(int row,int column) row:���ε��� ,  column:���ε���
		Object name1 = table.getValueAt(1,0);
		System.out.println("name1="+ name1);
		
		String name2 = (String) table.getValueAt(1,0);
		System.out.println("name2="+ name2);
				
		
		//����2) JTable���� '�����' ---> '������'���� ����
		      //table.set�޼ҵ�() ã��    : ��Ʈ===> �࿭ �ε����� ���!!
		  //table.setValueAt(Object aValue,int row,int column);//aValue:������ ������
		table.setValueAt("������",1,0);//aValue:������ ������
		
		//����3) JTable���� ��� ����� �̸��� (�ܼ�)ȭ�鿡 ����Ͻÿ�.
		//�̸� ---> 0��
		
		System.out.println(table.getValueAt(0,0));		
		System.out.println(table.getValueAt(1,0));		
		System.out.println(table.getValueAt(2,0));		
		System.out.println("===========================");
		//���� ���� ���� �� �ִٸ�
		//��ü���� ����: table.getRowCount();   //3
		//��ü���� ����: table.getColumnCount();   //3
		for(int i=0; i< table.getRowCount(); i++ ) {//���ε��� ǥ��
			System.out.println(table.getValueAt(i,0));
		}
		
		//����4) �� �߰�!!  ----> ["������",13,"ȭ��"]
		//table.setValueAt("������",3,0);   (X):����==> �������� �ʴ�(�����) �ε��� ����
		
		//dtm.addRow(Object[]rowData);
		Object[] data1 = {"������",13,"ȭ��"};
		dtm.addRow(data1);
		
		//dtm.addRow(Vector rowData);
		Vector<Object> data2 = new Vector<>();
		  data2.add("�̼���");
		  data2.add(23);
		  data2.add("�屺");
		dtm.addRow(data2);
		
		//����5) ���ֿ����� ���� (��Ʈ: ����°�� ---> 2��)
		dtm.removeRow(2);//����°�� ����!!
		
	}//������
	
	public static void main(String[] args) {
		new JTableTest();
	}
}






















