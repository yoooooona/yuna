package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class JListTest5 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JListTest5 frame = new JListTest5();
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
	public JListTest5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		//userTBL �� ��ü ������ �о�ͼ� JList�� �����ֱ�
		//Vector�� ��������
		UserDao dao=new UserDao();
		Vector<UserVO> user=dao.getUsers();
		//��ü������ ������ ��
		//JList list = new JList(user);
		
		//�̸��� JList�� ������ ��
		String name[]=new String[user.size()];
		for(int i=0;i<user.size();i++) {
			name[i]=user.get(i).getName();
		}
		JList list=new JList(name);
		scrollPane.setViewportView(list);
	}

}
