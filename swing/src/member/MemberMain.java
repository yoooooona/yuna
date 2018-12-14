package member;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;

public class MemberMain extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable table;
	private JTextField txtname;
	private JTextField txtage;
	private JTextField txtgender;
	private DefaultTableModel model;
	private JButton btn_input,btn_del;
	private JButton btnall;
	MemberDAO dao;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMain frame = new MemberMain();
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
	public MemberMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.WEST);
		
		
		String columnNames[]= {"�̸�", "����", "����"};
		model=new DefaultTableModel(columnNames,0) {
				//�� ������ ���� ���ϰ� ����� ��
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		table = new JTable(model);
		//�ʵ���� �����ϸ� �ڵ� ����
		table.setAutoCreateRowSorter(true);
		//table.setModel(model);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		panel.add(lblNewLabel);
		
		txtname = new JTextField();
		panel.add(txtname);
		txtname.setColumns(5);
		
		JLabel lblNewLabel_1 = new JLabel("\uB098\uC774");
		panel.add(lblNewLabel_1);
		
		txtage = new JTextField();
		panel.add(txtage);
		txtage.setColumns(5);
		
		JLabel lblNewLabel_2 = new JLabel("\uC131\uBCC4");
		panel.add(lblNewLabel_2);
		
		txtgender = new JTextField();
		panel.add(txtgender);
		txtgender.setColumns(5);
		
		btn_input = new JButton("\uC785\uB825");
		panel.add(btn_input);
		
		btn_del = new JButton("\uC0AD\uC81C");
		panel.add(btn_del);
		
		btnall = new JButton("\uC804\uCCB4 \uC870\uD68C");
		panel.add(btnall);
		
		JLabel label = new JLabel("");
		panel.add(label);
	
		dao=new MemberDAO();
		
		btn_input.addActionListener(this);
		btn_del.addActionListener(this);
		btnall.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn =(JButton) e.getSource();
		
		if(btn==btn_input) {
			//�̸� , ����, ������ ������ ��
			//���̺� �߰�
			String name=txtname.getText();
			String age=txtage.getText();
			String gender=txtgender.getText();
			//���̺� �߰�
			//���̺� ���� �߰� ������ �ʰ�, model�� �߰��Ѵ�.
			//String data[]= {name, age, gender}; �迭�� ó��
			Vector<String> data =new Vector<>();
			data.addElement(name);
			data.addElement(age);
			data.addElement(gender);
			model.addRow(data);
			
			txtname.setText("");
			txtage.setText("");
			txtgender.setText("");
			
			//memberTBL �� ������ �߰��ϱ�
			//MemberDAO�� insert_member()�޼ҵ带 ȣ���� ��
			//������� �޾Ƽ� �Է¼��� or �Է½��� â ����
			MemberDAO dao=new MemberDAO();
			int result=dao.insert_member(name, Integer.parseInt(age), gender);
			 if(result > 0) {
				 JOptionPane.showMessageDialog(this, "�Է¼���", "���", JOptionPane.INFORMATION_MESSAGE);
			 } else {
					JOptionPane.showMessageDialog(this, "�Է½���", "���", JOptionPane.WARNING_MESSAGE);
			 }
		}else if(btn==btn_del){
			//����ڰ� ������ ���� ���̺��� ����
			
			//����ڰ� ������ �� ��������
			int row=table.getSelectedRow();
			model.removeRow(row);
		}else { //������ȸ
			//get_members()�� ȣ���Ͽ� ����� ���� �Ŀ�
			//�� ����� JTable�� �𵨿� �����ֱ�
			ArrayList<MemberVO> list=dao.get_members();
			
			for(MemberVO vo:list) {
				Vector<Object> vec=new Vector<>();
				vec.addElement(vo.getName());
				vec.addElement(vo.getAge());
				vec.addElement(vo.getGender());
				model.addRow(vec);
			}
		}
		
	}

}
