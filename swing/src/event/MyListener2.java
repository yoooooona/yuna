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
		//EventListener2의 setLabelText(String str) 호출하기
		//버튼이 클릭되었음 
		
		
	}
}
