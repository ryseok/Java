package calc.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalcView extends JFrame{
   public JTextField tf_su1,tf_su2;
   public JComboBox<String> cb_oper;
   public JButton bt_calc;
   public JLabel la_result;
   
   public CalcView() {
	 setTitle("MVC계산기");  
	   
	 tf_su1 = new JTextField(5);
	 tf_su2 = new JTextField(5);
	 cb_oper = new JComboBox<>();
	   cb_oper.addItem("+");
	   cb_oper.addItem("-");
	   cb_oper.addItem("*");
	   cb_oper.addItem("/");
	 bt_calc = new JButton("계산");
	 la_result = new JLabel();
	 
	 setLayout(new FlowLayout());
	 add(tf_su1);
	 add(cb_oper);
	 add(tf_su2);
	 add(bt_calc);
	 add(la_result);
	 
	 setBounds(300,200, 320,120);
	 setVisible(true);
	 setResizable(false);
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
   }//생성자
   

}




