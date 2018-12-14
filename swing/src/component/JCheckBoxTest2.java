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
		
		//그룹으로 설정할 때(하나만 버튼으로 사용할 때)
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
		//체크가 해제될 때 textField에서도 내용이 지워짐
		}else {
			//전체 문자열 가져오기
			String original=textField.getText();
			//선택 해제된 문자열 가져오기
			String selStr=check.getText();
			//전체 문자열에서 선택 해제된 문자열과 일치하는 곳의
			//위치를 찾아 지우기
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
