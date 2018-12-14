package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyButton extends JButton {
	static int count = 0;
	int index;

	public MyButton(String str) {
		super(str);
		index = count++;
	}
}

public class Puzzle extends JFrame implements ActionListener {

	private JPanel contentPane;
	private MyButton btn[]; // MyButton =JButton

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Puzzle frame = new Puzzle();
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
	public Puzzle() {
		setTitle("puzzle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < btn.length - 1; i++)
					btn[i].setText((i + 1) + "");
				btn[8].setText("");
			}
		});
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setForeground(Color.GRAY);
		contentPane.add(btnNewButton, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		btn = new MyButton[9];
		// MyButton 객체 생성후 배열에 할당
		for (int i = 0; i < btn.length - 1; i++) {
			btn[i] = new MyButton((i + 1) + "");

		}
		// 맨 마지막은 텍스트 없이 생성
		btn[8] = new MyButton("");

		// btn배열을 패널에 붙이기
		for (int i = 0; i < btn.length; i++) {
			btn[i].addActionListener(this);
			panel.add(btn[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyButton b = (MyButton) e.getSource();

		if (b.index == 0) {
			if (btn[1].getText().equals("")) {
				btn[1].setText(b.getText());
				b.setText("");
			} else if (btn[3].getText().equals("")) {
				btn[3].setText(b.getText());
				b.setText("");
			}
		} else if (b.index == 1) {
			if (btn[0].getText().equals("")) {
				btn[0].setText(b.getText());
				b.setText("");
			} else if (btn[2].getText().equals("")) {
				btn[2].setText(b.getText());
				b.setText("");
			} else if (btn[4].getText().equals("")) {
				btn[4].setText(b.getText());
				b.setText("");
			}
		} else if (b.index == 2) {
			if (btn[1].getText().equals("")) {
				btn[1].setText(b.getText());
				b.setText("");
			} else if (btn[5].getText().equals("")) {
				btn[5].setText(b.getText());
				b.setText("");
			}
		} else if (b.index == 3) {
			if (btn[0].getText().equals("")) {
				btn[0].setText(b.getText());
				b.setText("");
			} else if (btn[4].getText().equals("")) {
				btn[4].setText(b.getText());
				b.setText("");
			} else if (btn[6].getText().equals("")) {
				btn[6].setText(b.getText());
				b.setText("");
			}
		} else if (b.index == 4) {
			if (btn[1].getText().equals("")) {
				btn[1].setText(b.getText());
				b.setText("");
			} else if (btn[3].getText().equals("")) {
				btn[3].setText(b.getText());
				b.setText("");
			} else if (btn[5].getText().equals("")) {
				btn[5].setText(b.getText());
				b.setText("");
			} else if (btn[7].getText().equals("")) {
				btn[7].setText(b.getText());
				b.setText("");
			}
		} else if (b.index == 5) {
			if (btn[2].getText().equals("")) {
				btn[2].setText(b.getText());
				b.setText("");
			} else if (btn[4].getText().equals("")) {
				btn[4].setText(b.getText());
				b.setText("");
			}
		}

	}

}
