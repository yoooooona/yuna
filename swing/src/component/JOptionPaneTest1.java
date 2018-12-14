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
			int retval=JOptionPane.showConfirmDialog(this, "��ȭ���� �����","��ȭ����",JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			//retval == 0 Ȯ�� retval == 2 ���
			System.out.println(retval);
		}else if(btn==message) {
			JOptionPane.showMessageDialog(this, "������ �ʰ��Ͽ����ϴ�.", "���", JOptionPane.ERROR_MESSAGE);
			
		}else if(btn==input) {
			/*JOptionPane.showInputDialog(this, "�Է� ���̾�α�","�Ľ��� �������ּ���" , JOptionPane.YES_NO_OPTION);*/
			String value[]= {"����","����","����"};
			JOptionPane.showInputDialog(this, "�Ľ��� �����ϼ���", "�Ľ�", JOptionPane.QUESTION_MESSAGE,null,value,value[0]);
		}else {
			String option[]= {"Well-Done", "Medium", "Rare"};
			int result=JOptionPane.showOptionDialog(this, "������ũ�� ��� �丮�ұ��?","������ũ �ֹ�" ,JOptionPane.DEFAULT_OPTION ,
					JOptionPane.QUESTION_MESSAGE,null,option ,option[0]);
			System.out.println("����ڰ� ������ �� :"+option[result]);
			
			}
		}
	}


