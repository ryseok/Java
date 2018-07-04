package calc.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calc.model.Calculator;
import calc.view.CalcView;

public class CalcController implements ActionListener{
   
   //�並 ���	
   CalcView view;
	
   public CalcController() {
	  view = new CalcView();
	  
	  view.bt_calc.addActionListener(this);
   }
	
	
   @Override
   public void actionPerformed(ActionEvent e) {
	   //===> ��Ʈ�ѷ��� ���� �ڵ带 ��ġ.
	  if(e.getSource() == view.bt_calc) {//1.
		 
		 //2. ������ ���
		 String su1 = view.tf_su1.getText();
		 String su2 = view.tf_su2.getText(); 
		 String oper = view.cb_oper.getSelectedItem().toString();
		        //oper = "+" "-" "*" "/"
		  
		 //3. Model ��ü����
		 /*Calculator calc = new Calculator();
		  int result = calc.plus(
				     Integer.parseInt(su1),
				     Integer.parseInt(su2));
		  System.out.println("result="+result);*/
		 //3.
		 Calculator calc = new Calculator(
				               Integer.parseInt(su1),
			                   Integer.parseInt(su2),
			                   oper);
		 String result = calc.getResultStr();
		 view.la_result.setText(result);
	  }
	   
   }
	
   public static void main(String[] args) {
	   new CalcController();
   }




	
	
   /*
            �ڡ�<��Ʈ�ѷ��� ����> - ��ü ���α׷��� ���� �帧 ����!!
     1. (�並 ���� ���޵�)������� ��û �м�  : if(ob==bt_new)
     2. (����ڰ�)�Էµ� ������ ������       : tf.getText()
     3. ��Ŭ���� ��ü����!!            : Calculator c = new Calculator();
         - �޼ҵ� ȣ��                                               c.plus(2,3);
         - ���ϵ� �����͸� (������)����                 int result = c.plus(2,3);
     4. ������ �̵�, �̵��� ������(������) ����    f1.setVisible(false);
                                         f2.setVisible(true);
           �ؼ���)
     5. ��ȿ�� �˻�  ===> �信�� �˻��ϱ⵵ ��.
     
   */
}





