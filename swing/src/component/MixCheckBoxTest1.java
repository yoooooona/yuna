package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.awt.CardLayout;
import javax.swing.JLabel;

public class MixCheckBoxTest1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JCheckBox chckbx1;
	private JCheckBox chckbx2;
	private JCheckBox chckbx3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MixCheckBoxTest1 frame = new MixCheckBoxTest1();
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
	public MixCheckBoxTest1() {
		setTitle("\uCCB4\uD06C\uBC15\uC2A4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 4, 0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		chckbx1 = new JCheckBox("\uC0AC\uACFC");
		panel.add(chckbx1);

		chckbx2 = new JCheckBox("\uD3EC\uB3C4");
		panel.add(chckbx2);

		chckbx3 = new JCheckBox("\uC624\uB80C\uC9C0");
		panel.add(chckbx3);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MixCheckBoxTest1.class.getResource("/component/apple.gif")));
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(MixCheckBoxTest1.class.getResource("/component/grape.gif")));
		panel_2.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(MixCheckBoxTest1.class.getResource("/component/orange.gif")));
		panel_3.add(lblNewLabel_2);

		chckbx1.addActionListener(this);
		chckbx2.addActionListener(this);
		chckbx3.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox fruit = (JCheckBox) e.getSource();
		if (fruit==chckbx1) {
			apple=new ImageIcon(MixCheckBoxTest1.class.getResource("/component/apple.gif"));
			lblNewLabel.setIcon(apple);
		} else if(fruit==chckbx2){
			grape=new ImageIcon(MixCheckBoxTest1.class.getResource("/component/apple.gif"));
			lblNewLabel_1.setIcon(grape);
		}else {
			orange
		}
			
	}

}
