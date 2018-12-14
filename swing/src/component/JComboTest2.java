package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JComboTest2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComboTest2 frame = new JComboTest2();
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
	public JComboTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		DefaultComboBoxModel<String> model= new DefaultComboBoxModel<>();
		model.addElement("����");
		model.addElement("�ݼ�");
		model.addElement("����");
		model.addElement("ȭ��");
		model.addElement("��");
		model.addElement("�伺");
		model.addElement("õ�ռ�");
		model.addElement("�ؿռ�");
		
		JComboBox comboBox = new JComboBox(model);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//���� ���õ� ������ textField �����ֱ�
				textField.setText(comboBox.getSelectedItem().toString());
				
			}
		});
		contentPane.add(comboBox, BorderLayout.SOUTH);
	}

}
