package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class CalculatorTest1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorTest1 frame = new CalculatorTest1();
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
	public CalculatorTest1() {
		setTitle("\uC774\uC790\uACC4\uC0B0\uAE30");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uC6D0\uAE08\uC744 \uC785\uB825\uD558\uC2DC\uC624");
		lblNewLabel_1.setBounds(101, 8, 112, 15);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 5, 116, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(206, 33, 116, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uC774\uC728\uC744 \uC785\uB825\uD558\uC2DC\uC624");
		lblNewLabel.setBounds(101, 36, 133, 15);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uBCC0\uD658");
		btnNewButton.setBounds(157, 118, 97, 23);
		panel.add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(123, 151, 184, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
	}
}
