package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PanelChangeTest2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem item1, item2, item3;
	private JMenu mnNewMenu,  mnNewMenu_1,  mnNewMenu_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelChangeTest2 frame = new PanelChangeTest2();
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
	public PanelChangeTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("\uCCAB\uBC88\uC9F8");
		menuBar.add(mnNewMenu);
		
		item1 = new JMenuItem("New menu item");
		mnNewMenu.add(item1);
		
		mnNewMenu_1 = new JMenu("\uB450\uBC88\uC9F8");
		menuBar.add(mnNewMenu_1);
		
		item2 = new JMenuItem("New menu item");
		mnNewMenu_1.add(item2);
		
		mnNewMenu_2 = new JMenu("\uC138\uBC88\uC9F8");
		menuBar.add(mnNewMenu_2);
		
		item3 = new JMenuItem("New menu item");
		mnNewMenu_2.add(item3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item=(JMenuItem)e.getSource();
		
		if(item==item1) {
			setContentPane(new PanelTest1());
		}else if(item==item2) {
			setContentPane(new PanelTest2());
		}else {
			setContentPane(new PanelTest3());
		}
		validate();
		
	}

}
