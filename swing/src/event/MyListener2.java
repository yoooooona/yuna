package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyListener2 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		/*System.out.println(e.getSource());
		System.out.println(e.getActionCommand());*/
		JButton btn=(JButton) e.getSource();
		//EventListener2�� setLabelText(String str) ȣ���ϱ�
		//��ư�� Ŭ���Ǿ��� 
		
		
	}
}
