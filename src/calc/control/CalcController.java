package calc.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calc.model.Calculator;
import calc.view.CalcView;

public class CalcController implements ActionListener{
   
   //뷰를 등록	
   CalcView view;
	
   public CalcController() {
	  view = new CalcView();
	  
	  view.bt_calc.addActionListener(this);
   }
	
	
   @Override
   public void actionPerformed(ActionEvent e) {
	   //===> 컨트롤러의 역할 코드를 위치.
	  if(e.getSource() == view.bt_calc) {//1.
		 
		 //2. 데이터 얻기
		 String su1 = view.tf_su1.getText();
		 String su2 = view.tf_su2.getText(); 
		 String oper = view.cb_oper.getSelectedItem().toString();
		        //oper = "+" "-" "*" "/"
		  
		 //3. Model 객체생성
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
            ★★<컨트롤러의 역할> - 전체 프로그램에 대한 흐름 제어!!
     1. (뷰를 통해 전달된)사용자의 요청 분석  : if(ob==bt_new)
     2. (사용자가)입력된 데이터 얻어오기       : tf.getText()
     3. 모델클래스 객체생성!!            : Calculator c = new Calculator();
         - 메소드 호출                                               c.plus(2,3);
         - 리턴된 데이터를 (변수에)저장                 int result = c.plus(2,3);
     4. 페이지 이동, 이동할 페이지(프레임) 선택    f1.setVisible(false);
                                         f2.setVisible(true);
           ※선택)
     5. 유효성 검사  ===> 뷰에서 검사하기도 함.
     
   */
}





