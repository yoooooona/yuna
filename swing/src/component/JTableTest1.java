package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class JTableTest1 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableTest1 frame = new JTableTest1();
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
	public JTableTest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"홍길동", 35, "남"},
				{"최유나", 23, "여"},
			},
			new String[] {
				"\uC774\uB984", "\uB098\uC774", "\uC131\uBCC4"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("\uCD9C\uB825");
		button.addActionListener (new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//출력 버튼을 누르면 테이블이 가지고 있는 내용이
				//화면으로 출력되도록 만들기
				
				//table이 가지고 있는 모델 가져오기
				TableModel model=table.getModel();
				try {
					table.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
				
				for(int i=0;i<model.getRowCount();i++) {
					for(int j=0;j<model.getColumnCount();j++) {
						System.out.println(model.getValueAt(i,j)+"\t");
					}
					System.out.println();
				}
			
		}
	});

		contentPane.add(button, BorderLayout.SOUTH);
 }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
