package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Color;

public class CalculatorTest2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField result;
	private JButton btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorTest2 frame = new CalculatorTest2();
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
	public CalculatorTest2() {
		setForeground(Color.RED);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\uAC70\uB9AC\uB97C \uB9C8\uC77C\uB2E8\uC704\uB85C \uC785\uB825\uD558\uC138\uC694");
		panel.add(label);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		result = new JTextField();
		panel_2.add(result);
		result.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		btn = new JButton("\uBCC0\uD658");
		panel_1.add(btn);
		pack();
		
		btn.addActionListener(this);
		//1∏∂¿œ =1.60934km
   }
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn=(JButton)e.getSource();	
		
		if(btn==btn) {
			int num1=Integer.parseInt(textField.getText());
			
			result.setText(num1*1.60934+"");
		}else {
			btn.setText("");
			result.setText("");
		
      	}
	}
}
