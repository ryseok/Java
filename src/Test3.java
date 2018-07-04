import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Test3 extends JFrame{
	JPanel p;
	
    public Test3() {
      p = new JPanel();
      
      p.setBounds(10, 10, 200, 200);
      //p.setBackground(Color.orange);
      p.setBorder(new BevelBorder(BevelBorder.RAISED, Color.RED, Color.RED));
      
      setLayout(null);
      add(p);
      
      setSize(300,300);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
    
    public static void main(String[] args) {
		new Test3();
	}
}
