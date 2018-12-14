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
		// 버튼이 클릭되면 버튼의 텍스트 변경
		btn.setText("버튼이 눌러짐");
		else if(btn==btn2)
		//버튼 2가 눌러지면 라벨의 텍스트 변경   
		lbl.setText("버튼이 눌러짐");
		
	}

}
