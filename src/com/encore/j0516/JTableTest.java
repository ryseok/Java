package com.encore.j0516;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame{
   /*
     JFame 'Center'에 javax.swing.JTable을 add시키시오.
        그리고 아래의 데이터를 JTable에 입력(표시)하시오.
    
      <데이터>
      이름        나이        직업
   --------------------
    홍길동        13     학생
    길라임        15     학생
    김주원        17     학생
          
    */
	JTable table;
	JScrollPane scroll_table;//범위를 벗어나는 데이터를 표현 : JTextArea, JTable, JList
	
	public JTableTest() {
		setTitle("JTable테스트");
		
		Object [][]rowData= {
				            //열     0      1    2
				               {"홍길동", 13, "학생"},//첫번째 행, 0행
				               {"길라임", 15, "학생"},//두번째 행, 1행
				               {"김주원", 17, "학생"}//세번째 행,  2행				               
		                    };
		Object[] columnNames= { "이름", "나이", "직업"};//컬럼(세로) 타이틀
		
		//table = new JTable(Object [][]rowData,  Object[] columnNames)
		//table = new JTable(rowData, columnNames);
		//table = new JTable(TableModel dm)
		     //TableModel: 인터페이스  ----구현---> DefaultTableModel !!
		DefaultTableModel dtm = new DefaultTableModel(rowData, columnNames);
		table = new JTable(dtm) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};//dtm에는 테이블에 (행)데이터를 추가,삭제,수정할수 있는 메소드를 지원
		
		
		
		
		//scroll_table = new JScrollPane(스크롤바를 필요로 하는 컴포넌트);
		scroll_table = new JScrollPane(table);//스크롤바를 지원하는 JTable!!
		
		add(scroll_table);//(table);
		
		setBounds(300,200, 350, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
/*
      <데이터>
      이름        나이        직업
   --------------------
    홍길동        13     학생      ----> 0행
    길라임        15     학생      ----> 1행
    김주원        17     학생      ----> 2행
 열   0       1       2   
          
    */
		
		//문제1) JTable내의 '길라임'을 얻어서 (콘솔)화면에 출력하시오.
		      //table.get메소드() 찾기    : 힌트===> 행열 인덱스를 사용!!
		//table.getValueAt(int row,int column) row:행인덱스 ,  column:열인덱스
		Object name1 = table.getValueAt(1,0);
		System.out.println("name1="+ name1);
		
		String name2 = (String) table.getValueAt(1,0);
		System.out.println("name2="+ name2);
				
		
		//문제2) JTable내의 '길라임' ---> '차라임'으로 변경
		      //table.set메소드() 찾기    : 힌트===> 행열 인덱스를 사용!!
		  //table.setValueAt(Object aValue,int row,int column);//aValue:변경할 데이터
		table.setValueAt("차라임",1,0);//aValue:변경할 데이터
		
		//문제3) JTable내의 모든 사람의 이름을 (콘솔)화면에 출력하시오.
		//이름 ---> 0열
		
		System.out.println(table.getValueAt(0,0));		
		System.out.println(table.getValueAt(1,0));		
		System.out.println(table.getValueAt(2,0));		
		System.out.println("===========================");
		//행의 길이 얻을 수 있다면
		//전체행의 갯수: table.getRowCount();   //3
		//전체열의 갯수: table.getColumnCount();   //3
		for(int i=0; i< table.getRowCount(); i++ ) {//행인덱스 표현
			System.out.println(table.getValueAt(i,0));
		}
		
		//문제4) 행 추가!!  ----> ["김유신",13,"화랑"]
		//table.setValueAt("김유신",3,0);   (X):에러==> 존재하지 않는(벗어나는) 인덱스 참조
		
		//dtm.addRow(Object[]rowData);
		Object[] data1 = {"김유신",13,"화랑"};
		dtm.addRow(data1);
		
		//dtm.addRow(Vector rowData);
		Vector<Object> data2 = new Vector<>();
		  data2.add("이순신");
		  data2.add(23);
		  data2.add("장군");
		dtm.addRow(data2);
		
		//문제5) 김주원행을 삭제 (힌트: 세번째행 ---> 2행)
		dtm.removeRow(2);//세번째행 삭제!!
		
	}//생성자
	
	public static void main(String[] args) {
		new JTableTest();
	}
}






















