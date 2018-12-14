package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JTextField;

public class JListTest2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JListTest2 frame = new JListTest2();
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
	public JListTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/*Vector<String> item=new Vector<>();
		item.addElement("런던");
		item.addElement("파리");
		item.addElement("시드니");
		item.addElement("로스앤젤레스");
		item.addElement("서울");		*/
		
		DefaultListModel<String> item=new DefaultListModel<>();
		item.addElement("서울");
		item.addElement("대전");
		item.addElement("대구");
		item.addElement("부산");
		item.addElement("광주");	
		
		JList list = new JList(item);
		list.addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				textField.setText(list.getSelectedValue()+"");	
				List<String> selList=list.getSelectedValuesList();
				for(String str:selList) {
					if(e.getValueIsAdjusting())
						System.out.println(str);
				}
				
			}
		});
		contentPane.add(list, BorderLayout.CENTER);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
	}

}




























