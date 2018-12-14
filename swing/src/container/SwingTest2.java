package container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest2 extends JFrame {
	public SwingTest2() {
		
		setSize(300, 500);
		setVisible(true);
		
		JButton btn1=new JButton("버튼 1");
		add(btn1);
		
		JButton btn2=new JButton("버튼 2");
		add(btn2);
		
		JButton btn3=new JButton("버튼 3");
		add(btn3);
	}
	public static void main(String[] args) {
		SwingTest2 t=new SwingTest2();
		/*t.setSize(300, 500);
		t.setVisible(true);*/
	}
}	

	


