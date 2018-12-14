package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class JTableTest2 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable table;
	private JTextField txtname;
	private JTextField txtage;
	private JTextField textField_2;
	private JTextField txtgender;
	private DefaultTableModel model;
	private JButton btn_input,btn_del;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableTest2 frame = new JTableTest2();
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
	public JTableTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		
		String columnNames[]= {"이름", "나이", "성별"};
		model=new DefaultTableModel(columnNames,0) {
				//셀 수정을 하지 못하게 만드는 것
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		table = new JTable(model);
		//필드명을 선택하면 자동 정렬
		table.setAutoCreateRowSorter(true);
		//table.setModel(model);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
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
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("");
		panel.add(label);
	
		btn_input.addActionListener(this);
		btn_del.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn =(JButton) e.getSource();
		
		if(btn==btn_input) {
			//이름 , 나이, 성별을 가져온 후
			//테이블에 추가
			String name=txtname.getText();
			String age=txtage.getText();
			String gender=txtgender.getText();
			//테이블에 추가
			//테이블에 직접 추가 하지는 않고, model에 추가한다.
			//String data[]= {name, age, gender}; 배열로 처리
			Vector<String> data =new Vector<>();
			data.addElement(name);
			data.addElement(age);
			data.addElement(gender);
			model.addRow(data);
			
			txtname.setText("");
			txtage.setText("");
			txtgender.setText("");
			
		}else {
			//사용자가 선택한 행을 테이블에서 삭제
			
			//사용자가 선택한 행 가져오기
			int row=table.getSelectedRow();
			model.removeRow(row);
		}
		
	}

}
