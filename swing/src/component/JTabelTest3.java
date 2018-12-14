package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTabelTest3 extends JFrame implements TableModelListener{

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTabelTest3 frame = new JTabelTest3();
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
	public JTabelTest3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		Object[][] data = { { "김철수", "서울", 24, false },
				{ "김영희", "부산", 22, true }, 
				{ "이동수", "경기", 59, false }, 
			};
		String[] columnNames = { "이름", "주소", "나이", "가입여부" };
		model = new DefaultTableModel(data, columnNames);
		table = new JTable();
		table.setModel(model);
		
		TableColumn city=table.getColumnModel().getColumn(1);
		JComboBox<String> combo=new JComboBox<>();
		combo.addItem("서울");
		combo.addItem("대구");
		combo.addItem("부산");
		combo.addItem("대전");
		combo.addItem("광주");
		combo.addItem("울산");
		city.setCellEditor(new DefaultCellEditor(combo));
		
		scrollPane.setViewportView(table);
		
		table.getModel().addTableModelListener(this);
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		int row=e.getFirstRow();
		int col=e.getColumn();
		if(col==2) {
			TableModel model=(TableModel)e.getSource();
			String data=(String)model.getValueAt(row, col);
			if(Integer.parseInt(data)>120) {
				JOptionPane.showMessageDialog(this, "볌위초과","경고", JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}

}
