package container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest1 {

	public static void main(String[] args) {
		JFrame frame=new JFrame("JFrame"); //â�����޼��� 
		frame.setSize(300, 200); //����������
		
		JButton btn1=new JButton("��ư1");
		frame.add(btn1);
		
		frame.setVisible(true);

	}

}
