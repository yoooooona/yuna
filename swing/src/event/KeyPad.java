package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyPad extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	//JButton을 담을 배열 생성
	private JButton button[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyPad frame = new KeyPad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KeyPad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		button=new JButton[9];
		
		for(int i=0;i<button.length;i++) {
			//생성된 배열객체에 JButton 객체 생성 후 담기
			button[i]=new JButton((i+1)+"");
			//생성된 버튼을 패널에 붙이기
			panel.add(button[i]);	
			//버튼에 액션리스너 담기
			button[i].addActionListener(this);
	}

}
	@Override
	public void actionPerformed(ActionEvent e) {
		//textField.setText(textField.getText()+e.getActionCommand());
		JButton btn=(JButton)e.getSource();
		textField.setText(textField.getText()+btn.getText());
		
			


		
		
	}
}