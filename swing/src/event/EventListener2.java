package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class EventListener2 extends JFrame {
	//필드, 멤버변수 
	private JPanel contentPane;
	private JLabel lblNewLabel;

	//내부클래스 
	private class MyListener3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			lblNewLabel.setText("버튼이 눌렸음");
		}
		
	}
	
	public void setLabelText(String str) {
		lblNewLabel.setText(str);
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventListener2 frame = new EventListener2();
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
	public EventListener2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\uBC84\uD2BC \uD074\uB9AD");
		btnNewButton.addActionListener(new MyListener3());
		contentPane.add(btnNewButton, BorderLayout.NORTH);
		
		 lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel, BorderLayout.SOUTH);
	}

}
