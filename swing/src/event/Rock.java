package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Rock extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	// 상수지정
	private final static int ROCK = 1;
	private final static int SCISSOR = 2;
	private final static int PAPER = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rock frame = new Rock();
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
	public Rock() {
		setTitle("\uAC00\uC704\uBC14\uC704\uBCF4\uAC8C\uC784");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel(
				"\uC544\uB798\uC758 \uBC84\uD2BC \uC911\uC5D0\uC11C \uD558\uB098\uB97C \uD074\uB9AD\uD558\uC2DC\uC624");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		textField = new JTextField();
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		btn1 = new JButton("Rock");
		panel.add(btn1);

		btn2 = new JButton("Paper");
		panel.add(btn2);

		btn3 = new JButton("Scissor");
		panel.add(btn3);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		int computer = (int) (Math.random() * 3 + 1);
		if (cmd.equals("Rock")) {
			if (computer == ROCK) {
				textField.setText("비겼습니다. 다시 게임을 진행합니다");
			} else if (computer == SCISSOR) {
				textField.setText("사용자가 이겼습니다.");
			} else {
				textField.setText("컴퓨터가 이겼습니다.");
			}
		} else if (cmd.equals("Paper")) {
			if (computer == ROCK) {
				textField.setText("사용자가 이겼습니다.");
			} else if (computer == SCISSOR) {
				textField.setText("컴퓨터가 이겼습니다.");
			} else {
				textField.setText("비겼습니다. 다시 게임을 진행합니다.");
			}
		} else {
			if (computer == ROCK) {
				textField.setText("컴퓨터가 이겼습니다.");
			} else if (computer == SCISSOR) {
				textField.setText("비겼습니다. 다시 게임을 진행합니다.");
			} else {
				textField.setText("사용자가 이겼습니다.");
			}
		}
	}
}
