package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class CalculatorTest3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lbl;
	private JButton btn;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorTest3 frame = new CalculatorTest3();
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
	public CalculatorTest3() {
		setTitle("Celsius Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		lbl = new JLabel("Celsius");
		contentPane.add(lbl);
		
		btn = new JButton("convert");
		contentPane.add(btn);
		
		lblNewLabel_1 = new JLabel("32 Fahrenheit");
		contentPane.add(lblNewLabel_1);
		pack();
		btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn=(JButton)e.getSource();	
		
		if(btn==btn) {
			int num1=Integer.parseInt(textField.getText());
		}else {
		
			btn.setText("");
		
	}
	

	}	
	

}
