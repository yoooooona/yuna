package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCheckBoxTest2 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JPanel panel;
	private JCheckBox chckbx2;
	private JCheckBox chckbx3;
	private JCheckBox chckbx4;
	private JCheckBox chckbx1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckBoxTest2 frame = new JCheckBoxTest2();
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
	public JCheckBoxTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		chckbx1 = new JCheckBox("\uC0AC\uACFC");
		panel.add(chckbx1);
		
		chckbx2 = new JCheckBox("\uC218\uBC15");
		panel.add(chckbx2);
		
		chckbx3 = new JCheckBox("\uB538\uAE30");
		panel.add(chckbx3);
		
		chckbx4 = new JCheckBox("\uBCF5\uC22D\uC544");
		panel.add(chckbx4);
		
		chckbx1.addActionListener(this);
		chckbx2.addActionListener(this);
		chckbx3.addActionListener(this);
		chckbx4.addActionListener(this);
		
		//�׷����� ������ ��(�ϳ��� ��ư���� ����� ��)
		/*ButtonGroup grp=new ButtonGroup();
		grp.add(chckbx1);
		grp.add(chckbx2);
		grp.add(chckbx3);
		grp.add(chckbx4);*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox check = (JCheckBox)e.getSource();
		if(check.isSelected()) {
		textField.setText(textField.getText()+check.getText());
		//üũ�� ������ �� textField������ ������ ������
		}else {
			//��ü ���ڿ� ��������
			String original=textField.getText();
			//���� ������ ���ڿ� ��������
			String selStr=check.getText();
			//��ü ���ڿ����� ���� ������ ���ڿ��� ��ġ�ϴ� ����
			//��ġ�� ã�� �����
			//StringBuffer buf=new StringBuffer(original);
			int start=original.indexOf(selStr);
			int end=start+selStr.length();
			textField.select(start, end);
			textField.replaceSelection("");
			//buf.delete(start, start+end);
			//textField.setText(buf.toString());
		}
	}
}
