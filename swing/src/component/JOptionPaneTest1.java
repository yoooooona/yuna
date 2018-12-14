package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class JOptionPaneTest1 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton confirm,message,input,option;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPaneTest1 frame = new JOptionPaneTest1();
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
	public JOptionPaneTest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		confirm = new JButton("confirm");
		panel.add(confirm);
		
		message = new JButton("message");
		panel.add(message);
		
		input = new JButton("input");
		panel.add(input);
		
		option = new JButton("option");
		panel.add(option);
		
		confirm.addActionListener(this);
		message.addActionListener(this);
		input.addActionListener(this);
		option.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn=(JButton)e.getSource();
		
		if(btn==confirm) {
			int retval=JOptionPane.showConfirmDialog(this, "대화상자 만들기","대화상자",JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			//retval == 0 확인 retval == 2 취소
			System.out.println(retval);
		}else if(btn==message) {
			JOptionPane.showMessageDialog(this, "범위를 초과하였습니다.", "경고", JOptionPane.ERROR_MESSAGE);
			
		}else if(btn==input) {
			/*JOptionPane.showInputDialog(this, "입력 다이얼로그","후식을 선택해주세요" , JOptionPane.YES_NO_OPTION);*/
			String value[]= {"감자","고구마","수박"};
			JOptionPane.showInputDialog(this, "후식을 선택하세요", "후식", JOptionPane.QUESTION_MESSAGE,null,value,value[0]);
		}else {
			String option[]= {"Well-Done", "Medium", "Rare"};
			int result=JOptionPane.showOptionDialog(this, "스테이크를 어떻게 요리할까요?","스테이크 주문" ,JOptionPane.DEFAULT_OPTION ,
					JOptionPane.QUESTION_MESSAGE,null,option ,option[0]);
			System.out.println("사용자가 선택한 값 :"+option[result]);
			
			}
		}
	}


