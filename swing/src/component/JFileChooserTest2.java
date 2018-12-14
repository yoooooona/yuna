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
		
		if(btn==btnopen) {//버튼 클릭시 파일열기 창 보여주기
			chooser.setCurrentDirectory(new File("c:/"));
			int retval=chooser.showOpenDialog(this);
			
			if(retval==JFileChooser.APPROVE_OPTION) { //열기버튼 클릭기 
				File f=chooser.getSelectedFile();
				//textField.setText(f.getName());
				textField.setText(f.getPath());
			}else { //취소버튼 클릭시
				
			}
		}else {//버튼 클릭시 파일저장 창 보여주기
			//파일 저장 유형 설정하기
			chooser.addChoosableFileFilter(new FileNameExtensionFilter("텍스트파일(*.txt)", "txt"));
			chooser.addChoosableFileFilter(new FileNameExtensionFilter("이미지파일(*.jpg,*.gif,*.bmp,*.png)","jpg","gif","bmp","png"));
			chooser.showSaveDialog(this);
		}
		
	}

}
