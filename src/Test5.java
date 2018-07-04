import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Test5 {
   public static void main(String[] args) {
	   JLabel la = new JLabel("비번");
	   JPasswordField pass = new JPasswordField(10);
	   
	   JPanel panel = new JPanel();
	       panel.add(la);
	       panel.add(pass);
	   
	  String []options= {"확인","취소"};
	  
	  JOptionPane.showOptionDialog(null, panel, "타이틀", JOptionPane.NO_OPTION,
			                    JOptionPane.PLAIN_MESSAGE, null, 
			                    options, options[1]);	  
   }
}
