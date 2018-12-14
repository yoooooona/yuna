package event;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class SimpleCalc extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField op1;
	private JTextField op2;
	private JTextField result;
	private JButton btnok;
	private JButton btncancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalc frame = new SimpleCalc();
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
	public SimpleCalc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnok = new JButton("\uD655\uC778");
		panel.add(btnok);
		
		btncancel = new JButton("\uCDE8\uC18C");
		panel.add(btncancel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		op1 = new JTextField();
		panel_1.add(op1);
		op1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("+");
		panel_1.add(lblNewLabel);
		
		op2 = new JTextField();
		panel_1.add(op2);
		op2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("=");
		panel_1.add(lblNewLabel_1);
		
		result = new JTextField();
		panel_1.add(result);
		result.setColumns(10);
		pack(); //딱맞춰줌 
		
		btnok.addActionListener(this);
		btncancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn=(JButton)e.getSource();
		//btnok가 눌러지면
	
		if(btn==btnok) {
			int num1=Integer.parseInt(op1.getText());
			int num2=Integer.parseInt(op2.getText());
		//op1,op2 값 가져오기(~.getText();
		//계산 결과를 result에 담기 (result.setText();
			result.setText(num1+num2+"");
		}else {
		//btncancel이 눌러지면
		//op1,op2,result에 있는 숫자 지우기 
			op1.setText("");
			op2.setText("");
			result.setText("");
		}
	}	
	

}
