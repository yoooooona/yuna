package component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;

public class RadioTeest2 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioTeest2 frame = new RadioTeest2();
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
	public RadioTeest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("\uC0AC\uC774\uC988\uB97C \uC120\uD0DD\uD574\uC8FC\uC138\uC694");
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "size", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		contentPane.add(panel_2);
		
		JRadioButton rdbtnsmall = new JRadioButton("small size");
		panel_2.add(rdbtnsmall);
		
		JRadioButton rdbtnmidium = new JRadioButton("midium size");
		panel_2.add(rdbtnmidium);
		
		JRadioButton rdbtnlarge = new JRadioButton("large size");
		panel_2.add(rdbtnlarge);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(20);
		
		ButtonGroup grp = new ButtonGroup();
		grp.add(rdbtnsmall);
		grp.add(rdbtnmidium);
		grp.add(rdbtnlarge);
		
		JButton btnNewButton = new JButton("\uCD08\uAE30\uD654");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//라디오 버튼 모두 해제
				grp.clearSelection();
			}
		});
		panel_2.add(btnNewButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		textField.setText(e.getActionCommand());
		
	}

}
