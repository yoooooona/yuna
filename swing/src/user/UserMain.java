package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import member.MemberVO;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class UserMain extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textname;
	private JTextField textaddr;
	private JTextField textbirth;
	private JTextField textField_7;
	private JTextField textField_3;
	private JTextField textnumber;
	private JTextField textaddr1;
	
	private JButton registbtn, searchbtn, updatebtn, deletebtn;
	UserDao dao;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMain frame = new UserMain();
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
	public UserMain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dw\\Desktop\\overwatch.png"));
		setTitle("\uC624\uBC84\uC6CC\uCE58");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.PINK);
		panel.setBackground(Color.PINK);
		tabbedPane.addTab("\uD68C\uC6D0\uB4F1\uB85D", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		 registbtn = new JButton("\uB4F1\uB85D");
		registbtn.setBackground(Color.PINK);
		panel.add(registbtn, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setForeground(new Color(255, 105, 180));
		panel_4.setBackground(new Color(255, 240, 245));
		panel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);
		
		textname = new JTextField();
		panel_4.add(textname);
		textname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_2);
		
		textbirth = new JTextField();
		panel_4.add(textbirth);
		textbirth.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uC8FC\uC18C");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel);
		
		textaddr = new JTextField();
		panel_4.add(textaddr);
		textaddr.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 218, 185));
		tabbedPane.addTab("\uD68C\uC6D0\uC870\uD68C", null, panel_1, null);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_8.add(panel_5, BorderLayout.NORTH);
		panel_5.setBackground(new Color(255, 204, 255));
		
		JLabel lblNewLabel_3 = new JLabel("\uBC88\uD638 ");
		panel_5.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		searchbtn = new JButton("\uAC80\uC0C9");
		
		panel_5.add(searchbtn);
		
		String columnNames[]= {"번호","이름", "생일", "주소"};
		model=new DefaultTableModel(columnNames,0) {
				//셀 수정을 하지 못하게 만드는 것
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		table = new JTable();
		panel_8.add(table, BorderLayout.CENTER);
		searchbtn.addActionListener(this);
		table.setModel(model);
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("\uD68C\uC6D0\uC218\uC815", null, panel_2, null);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.PINK);
		panel_2.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("\uBC88\uD638");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_5);
		
		textnumber = new JTextField();
		panel_6.add(textnumber);
		textnumber.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_4);
		
		textaddr1 = new JTextField();
		panel_6.add(textaddr1);
		textaddr1.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(250, 250, 210));
		panel_2.add(panel_7);
		
		updatebtn = new JButton("\uC218\uC815");
		panel_7.add(updatebtn);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 228, 225));
		tabbedPane.addTab("\uD68C\uC6D0\uC0AD\uC81C", null, panel_3, null);
		
		JLabel lblNewLabel_6 = new JLabel("\uC774\uB984 ");
		panel_3.add(lblNewLabel_6);
		
		textField_7 = new JTextField();
		panel_3.add(textField_7);
		textField_7.setColumns(10);
		
		deletebtn = new JButton("\uC0AD\uC81C");
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.add(deletebtn);
		
		//Dao 객체 생성
		dao=new UserDao();
		
		registbtn.addActionListener(this);
		searchbtn.addActionListener(this);
		updatebtn.addActionListener(this);
		deletebtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn=(JButton)e.getSource();
		
		if(btn==registbtn) {  //회원등록
			//사용자가 입력한 이름, 생년월일, 주소를 가지고 온다
			//DB에 가지고 온 데이터를 삽입한 후
			//삽입성공시 "삽입성공" 메시지를 띄우고
			//삽입실패시 "삽입실패" 메시지를 띄운다.
			String name = textname.getText();
			String birthday = textbirth.getText();
			String addr =textaddr.getText();
			int result=dao.user_insert(name, birthday, addr);
			if(result>0)
				JOptionPane.showMessageDialog(this, "입력성공", "결과", JOptionPane.PLAIN_MESSAGE);
			else
				JOptionPane.showMessageDialog(this, "입력실패", "결과", JOptionPane.ERROR_MESSAGE);
			
		}else if(btn==searchbtn) {//회원조회
			//회원번호를 입력받아서 검색버튼 클릭시
			//UserDAO의 getUser(no)호출
			//받은결과를 table에 출력하기
			
			UserVO vo=dao.getUser(Integer.parseInt(textField_3.getText()));
			if(vo!=null) {
				Vector<String> data=new Vector<>();
				data.addElement(String.valueOf(vo.getNo()));
				data.addElement(vo.getName());
				data.addElement(vo.getBirthday());
				data.addElement(vo.getAddress());
				model.addRow(data);
			}else {
				System.out.println("null");
			}
		
		}else if(btn==updatebtn) { 
			int no = Integer.parseInt(textnumber.getText());
			String addr =textaddr1.getText();
			int result =dao.user_update(no, addr);
			if(result>0)
				JOptionPane.showMessageDialog(this, "수정성공", "결과", JOptionPane.PLAIN_MESSAGE);
			else
				JOptionPane.showMessageDialog(this, "수정실패", "결과", JOptionPane.ERROR_MESSAGE);
		}else {
			int no = Integer.parseInt(textField_7.getText());
			int result =dao.user_delete(no);
			if(result >0)
				JOptionPane.showMessageDialog(this, "삭제성공", "결과", JOptionPane.PLAIN_MESSAGE);
			else
				JOptionPane.showMessageDialog(this, "삭제실패", "결과", JOptionPane.ERROR_MESSAGE);
		}
			
		
		
	}

}
