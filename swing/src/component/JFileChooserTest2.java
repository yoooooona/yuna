package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class JFileChooserTest2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnopen, btnsave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFileChooserTest2 frame = new JFileChooserTest2();
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
	public JFileChooserTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		btnopen = new JButton("open");
		panel.add(btnopen);
		
		btnsave = new JButton("save");
		panel.add(btnsave);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(20);
		
		btnopen.addActionListener(this);
		btnsave.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn=(JButton)e.getSource();
		JFileChooser chooser=new JFileChooser();
		
		if(btn==btnopen) {//��ư Ŭ���� ���Ͽ��� â �����ֱ�
			chooser.setCurrentDirectory(new File("c:/"));
			int retval=chooser.showOpenDialog(this);
			
			if(retval==JFileChooser.APPROVE_OPTION) { //�����ư Ŭ���� 
				File f=chooser.getSelectedFile();
				//textField.setText(f.getName());
				textField.setText(f.getPath());
			}else { //��ҹ�ư Ŭ����
				
			}
		}else {//��ư Ŭ���� �������� â �����ֱ�
			//���� ���� ���� �����ϱ�
			chooser.addChoosableFileFilter(new FileNameExtensionFilter("�ؽ�Ʈ����(*.txt)", "txt"));
			chooser.addChoosableFileFilter(new FileNameExtensionFilter("�̹�������(*.jpg,*.gif,*.bmp,*.png)","jpg","gif","bmp","png"));
			chooser.showSaveDialog(this);
		}
		
	}

}
