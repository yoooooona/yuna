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

public class EventListener3 extends JFrame implements ActionListener{
	

	private JPanel contentPane;
	private JButton btn;
	private JLabel lbl;
	private JButton btn2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventListener3 frame = new EventListener3();
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
	public EventListener3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btn = new JButton("\uBC84\uD2BC \uD074\uB9AD");
		btn.addActionListener(this);
		contentPane.add(btn, BorderLayout.NORTH);
		
		lbl = new JLabel("New label");
		contentPane.add(lbl, BorderLayout.SOUTH);
		
		btn2 = new JButton("New button");
		btn2.addActionListener(this);
		contentPane.add(btn2, BorderLayout.WEST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn=(JButton) e.getSource();
		if(btn==this.btn)
		// ��ư�� Ŭ���Ǹ� ��ư�� �ؽ�Ʈ ����
		btn.setText("��ư�� ������");
		else if(btn==btn2)
		//��ư 2�� �������� ���� �ؽ�Ʈ ����   
		lbl.setText("��ư�� ������");
		
	}

}
