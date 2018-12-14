package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;

public class CalculatorTest4 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorTest4 frame = new CalculatorTest4();
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
	public CalculatorTest4() {
		setTitle("\uC804\uC790\uACC4\uC0B0\uAE30");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(40);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 5, 0, 5));
		
		JButton btnNewButton_5 = new JButton("Backs...");
		btnNewButton_5.setForeground(Color.BLUE);
		panel_1.add(btnNewButton_5);
		
		JButton button_11 = new JButton("");
		panel_1.add(button_11);
		
		JButton btnNewButton_3 = new JButton("");
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("CE");
		btnNewButton_1.setForeground(Color.RED);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("C");
		btnNewButton_4.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton_4.setForeground(Color.RED);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("7");
		btnNewButton.setForeground(Color.BLUE);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_10 = new JButton("8");
		btnNewButton_10.setForeground(Color.BLUE);
		panel_1.add(btnNewButton_10);
		
		JButton btnNewButton_2 = new JButton("9");
		btnNewButton_2.setForeground(Color.BLUE);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_6 = new JButton("/");
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("squ");
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("4");
		btnNewButton_8.setForeground(Color.BLUE);
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("5");
		btnNewButton_9.setForeground(Color.BLUE);
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_11 = new JButton("6");
		btnNewButton_11.setForeground(Color.BLUE);
		panel_1.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("*");
		panel_1.add(btnNewButton_12);
		
		JButton button_10 = new JButton("%");
		panel_1.add(button_10);
		
		JButton button_9 = new JButton("1");
		button_9.setForeground(Color.BLUE);
		panel_1.add(button_9);
		
		JButton button_8 = new JButton("2");
		button_8.setForeground(Color.BLUE);
		panel_1.add(button_8);
		
		JButton button_7 = new JButton("3");
		button_7.setForeground(Color.BLUE);
		panel_1.add(button_7);
		
		JButton button_6 = new JButton("-");
		panel_1.add(button_6);
		
		JButton btnT = new JButton("t/2");
		panel_1.add(btnT);
		
		JButton button_4 = new JButton("0");
		button_4.setForeground(Color.BLUE);
		panel_1.add(button_4);
		
		JButton button_3 = new JButton("+/-");
		button_3.setForeground(Color.BLUE);
		panel_1.add(button_3);
		
		JButton button_2 = new JButton(".");
		panel_1.add(button_2);
		
		JButton button_1 = new JButton("+");
		panel_1.add(button_1);
		
		JButton btnNewButton_13 = new JButton("=");
		panel_1.add(btnNewButton_13);
	}

}
