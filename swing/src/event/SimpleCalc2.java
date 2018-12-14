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

public class SimpleCalc2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField op1;
	private JTextField op2;
	private JTextField result;
	private JButton btnsub,btnsum,btnmin,btn,btnmul;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalc2 frame = new SimpleCalc2();
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
	public SimpleCalc2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnsum = new JButton("+");
		panel.add(btnsum);
		
		btnmin = new JButton("-");
		panel.add(btnmin);
		
		btnsub = new JButton("*");
		panel.add(btnsub);
		
		btnmul = new JButton("/");
		panel.add(btnmul);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		op1 = new JTextField();
		panel_1.add(op1);
		op1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("?");
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
		
		btnsub.addActionListener(this);
		btnmin.addActionListener(this);
		btnsum.addActionListener(this);
		btnmul.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn=(JButton)e.getSource();
		//btnok가 눌러지면
		/*if(op1.getText().length()>0)
			num1=Integer.parseLnt(op1.getText());
			if(op2.getText().length()>0)
			num2=Integer.parseLnt(op2.getText());
			int temp=0;
*/		if(btn==btnsum) {
	//temp=num1+num2;
			int num1=Integer.parseInt(op1.getText());
			int num2=Integer.parseInt(op2.getText());
		//op1,op2 값 가져오기(~.getText();
		//계산 결과를 result에 담기 (result.setText();
			result.setText(num1+num2+"");
		}else if(btn==btnsub){
		//btncancel이 눌러지면
			//temp=num1*num2;
			int num1=Integer.parseInt(op1.getText());
			int num2=Integer.parseInt(op2.getText());
			result.setText(num1*num2+"");
		}else if(btn==btnmin) {
			//temp=num1-num2;
			int num1=Integer.parseInt(op1.getText());
			int num2=Integer.parseInt(op2.getText());
			result.setText(num1-num2+"");
			
		}else {
			int num1=Integer.parseInt(op1.getText());
			int num2=Integer.parseInt(op2.getText());
			result.setText(num1/num2+"");
			/*try {
				temp=num1/num2;
			}catch(ArithmeticException ex) {
				System.out.println(ex.getMessage());
			}
		}*/
			//result.setText(temp+"");
	}
	}	
}

