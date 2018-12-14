package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		/*System.out.println(e.getSource());
		System.out.println(e.getActionCommand());*/
		JButton btn=(JButton) e.getSource();
		//System.out.println(btn.getText());
		btn.setText("버튼이 눌러짐");
		
	}
}
