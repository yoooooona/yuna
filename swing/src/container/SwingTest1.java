package container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest1 {

	public static void main(String[] args) {
		JFrame frame=new JFrame("JFrame"); //창위에메세지 
		frame.setSize(300, 200); //사이즈조절
		
		JButton btn1=new JButton("버튼1");
		frame.add(btn1);
		
		frame.setVisible(true);

	}

}
